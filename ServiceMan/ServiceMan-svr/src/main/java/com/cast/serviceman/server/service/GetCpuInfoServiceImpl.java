package com.cast.serviceman.server.service;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.SCPInputStream;
import ch.ethz.ssh2.Session;
import com.cast.serviceman.api.entity.ServiceDto;
import com.cast.serviceman.api.entity.SoftServiceStatus;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.entity.vo.CpuInfoVO;
import com.cast.serviceman.api.entity.vo.CpuSingleInfoVO;
import com.cast.serviceman.api.entity.vo.ServiceDtoVo;
import com.cast.serviceman.api.entity.vo.SoftStatusVO;
import com.cast.serviceman.api.service.ComputerServerService;
import com.cast.serviceman.api.service.GetCpuInfoService;
import com.cast.serviceman.common.CpuFileds;
import com.cast.serviceman.server.mapper.ServiceDtoMapper;
import com.cast.serviceman.server.mapper.SoftServiceStatusMapper;
import com.cast.serviceman.util.ConnectionUtil;
import com.cast.serviceman.util.DateUtils;
import com.cast.serviceman.util.MathUtils;
import com.cast.serviceman.util.SFTPUtil;
import com.jcraft.jsch.SftpException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 查询虚拟机磁盘,cpu,内存
 */
@Component
@DubboService(version = "1.0", group = "serviceman1.0", retries = 3, timeout = 3000)
public class GetCpuInfoServiceImpl implements GetCpuInfoService {


    @Resource
    private ServiceDtoMapper serviceDtoMapper;
    @Autowired
    private ComputerServerService computerServerService;
    @Resource
    private SoftServiceStatusMapper softServiceStatusMapper;


    private static final Logger logger = LoggerFactory.getLogger(GetCpuInfoServiceImpl.class);

    //查询虚拟机磁盘,cpu,内存,磁盘
    @Override
    public ResponseModel<CpuInfoVO> getInfo(String satId, String serviceName, String ip, String state) {
        logger.info(DateUtils.getCurrentDate1());
        ResponseModel<CpuInfoVO> responseModel = new ResponseModel<>();
        List<ServiceDtoVo> serviceDtoVoList = serviceDtoMapper.queryAll(satId, serviceName, ip);
        List<CpuInfoVO.VirtualInfo> list = new ArrayList<>();
        CpuInfoVO totalVo = new CpuInfoVO();
        List<Map<String, String>> mapList = new ArrayList<>();
        int runningCount = 0;
        int warnCount = 0;
        for (ServiceDtoVo vo : serviceDtoVoList) {
            Connection connection = null;
            try {
                //创建连接
                connection = ConnectionUtil.getConnect(vo.getServiceIp(), 22, vo.getServiceAccount(), vo.getServicePassword());
                String status = "running";
                //如果服务器关机,则会获取连接异常
                if (!connection.isAuthenticationComplete()) {
                    status = "stop";
                    CpuInfoVO.VirtualInfo cpuInfoVO = new CpuInfoVO.VirtualInfo(vo.getServiceName(), status, null, null, null, vo.getServiceIp());
                    list.add(cpuInfoVO);
                    continue;
                }
                //运行中的
                runningCount = runningCount + 1;
                //1.查cpu
                BufferedReader reader1 = ConnectionUtil.getSession(connection, CpuFileds.getCpuInfo());
                String cpuInfo = ConnectionUtil.readBuffer(reader1);
                long cpu1 = 100 - Math.round(Double.parseDouble(cpuInfo));
                String cpu = cpu1 + "%";
                reader1.close();

                //2.查磁盘
                BufferedReader reader = ConnectionUtil.getSession(connection, CpuFileds.getDISK());
                StringBuffer sb = new StringBuffer();
                String buf = null;
                Float total = new Float(0);
                while ((buf = reader.readLine()) != null) {
                    sb.append(buf);
                    if (!buf.contains("已用%") && !buf.contains("Use%") && !buf.contains("use%")) {
                        String[] st = buf.trim().split("\\s+");
                        String a = st[4];
                        float result = new Float(a.substring(0, a.indexOf("%"))) / 100;
                        total += result;
                    }
                }
                reader.close();
                long disk1 = Math.round(total * 100);
                String disk = disk1 + "%";
                //3.查内存
                //总内存
                BufferedReader reader2 = ConnectionUtil.getSession(connection, CpuFileds.getTotalMemoryInfo());
                String allMemo = ConnectionUtil.readBuffer(reader2);
                //剩余内存
                BufferedReader reader3 = ConnectionUtil.getSession(connection, CpuFileds.getRemainMemoryInfo());
                String remainMemo = ConnectionUtil.readBuffer(reader3);
                String userMemo = MathUtils.get((Double.parseDouble(allMemo) - Double.parseDouble(remainMemo)) / Double.parseDouble(allMemo));
                String userMem = userMemo + "%";
                reader2.close();
                reader3.close();
                logger.info("cpu:********{}", cpu);
                logger.info("disk********{}", disk);
                logger.info("userMem****:{}", userMem);

                //封装虚拟机信息
                CpuInfoVO.VirtualInfo cpuInfoVO = new CpuInfoVO.VirtualInfo(vo.getServiceName(), status, cpu, userMem, disk, vo.getServiceIp());
                //判断虚拟机内存啥的是否以及超过阈值
                //1.cpu判断,如果大于阈值
                Map<String, String> map = new HashMap<>();
                //cpu的警戒值
                cpuInfoVO.setCpuSecurityLine(false);
                //内存的警戒值
                cpuInfoVO.setMemorySecurityLine(false);
                //磁盘
                cpuInfoVO.setDiskSecurityLine(false);

                if (cpu1 >= Long.parseLong(vo.getCpuKey())) {
                    cpuInfoVO.setCpuSecurityLine(true);
                    map.put("info", "虚拟机" + vo.getServiceName() + "cpu使用超过" + cpu1 + "%");
                    map.put("time", DateUtils.getCurrentDate1());
                    mapList.add(map);
                }
                //2内存
                if (Long.parseLong(userMemo) >= Long.parseLong(vo.getMemoryKey())) {
                    cpuInfoVO.setMemorySecurityLine(true);
                    map.put("info", "虚拟机" + vo.getServiceName() + "内存使用超过" + userMemo + "%");
                    map.put("time", DateUtils.getCurrentDate1());
                    mapList.add(map);
                }

                //3磁盘判断
                if (disk1 >= Long.parseLong(vo.getDiskKey())) {
                    cpuInfoVO.setDiskSecurityLine(true);
                    map.put("info", "虚拟机" + vo.getServiceName() + "磁盘使用超过" + disk1 + "%");
                    map.put("time", DateUtils.getCurrentDate1());
                    mapList.add(map);
                }
                if (null != mapList) {
                    warnCount = warnCount + 1;
                }
                //返回告警信息
                list.add(cpuInfoVO);
            } catch (IOException e) {
                responseModel.setErrorMsg(e.getMessage());
                logger.error(e.getMessage());
                return responseModel;
            } finally {
                ConnectionUtil.closeConnection(connection);
            }
        }
        totalVo.setMapList(mapList);
        //根据所有的虚拟机排序
        //Collections.sort(list, Comparator.comparing(CpuInfoVO.VirtualInfo::getCpu));
        //根据状态过滤
        if (StringUtils.isNotEmpty(state)) {
            list = list.stream().filter(stats -> StringUtils.equals(state, stats.getStatus())).collect(Collectors.toList());
        }
        totalVo.setTotalCount(serviceDtoVoList.size());
        totalVo.setRunningCount(runningCount);
        totalVo.setStopCount(serviceDtoVoList.size() - runningCount);
        totalVo.setWarnCount(warnCount);
        totalVo.setVirtualInfos(list);
        responseModel.setData(totalVo);
        logger.info(DateUtils.getCurrentDate1());
        return responseModel;
    }

    /**
     * 综合监控-服务器,  获取单个机器的cpu,磁盘,内存
     *
     * @param ip
     * @return
     */
    @Override
    public ResponseModel<CpuSingleInfoVO> getInfoByIP(String ip) {

        ResponseModel<CpuSingleInfoVO> responseModel = new ResponseModel<>();
        CpuSingleInfoVO cpuSingleInfoVO = null;
        ResponseModel<CpuInfoVO> responseModel1 = getInfo(null, null, ip, null);
        //查询出虚拟机内存信息
        List<CpuInfoVO.VirtualInfo> virtualInfos = responseModel1.getData().getVirtualInfos();
        CpuInfoVO.VirtualInfo cpuInfo = virtualInfos.get(0);
        //告警信息
        List<Map<String, String>> mapList = responseModel1.getData().getMapList();
        //查询出虚拟机信息,查总内存信息
        List<ServiceDtoVo> serviceDtoVoList = serviceDtoMapper.queryAll(null, null, ip);
        ServiceDtoVo vo = serviceDtoVoList.get(0);
        Connection connection = null;
        try {
            //创建连接
            connection = ConnectionUtil.getConnect(vo.getServiceIp(), 22, vo.getServiceAccount(), vo.getServicePassword());
            if (!connection.isAuthenticationComplete()) {
                responseModel.setErrorMsg("连接失败");
                return responseModel;
            }
            //总内存
            BufferedReader reader2 = ConnectionUtil.getSession(connection, CpuFileds.getTotalMemoryInfo());
            String allMemo = ConnectionUtil.readBuffer(reader2);
            reader2.close();
            //剩余内存
            BufferedReader reader3 = ConnectionUtil.getSession(connection, CpuFileds.getRemainMemoryInfo());
            String remainMemo = ConnectionUtil.readBuffer(reader3);
            reader3.close();


            //总磁盘
            //2.查磁盘,GB
            BufferedReader reader = ConnectionUtil.getSession(connection, CpuFileds.getTotalIdskInfoGb());
            StringBuffer sb = new StringBuffer();
            String buf = null;
            int totalDisk = 0;
            while ((buf = reader.readLine()) != null) {
                sb.append(buf);
                if (!buf.contains("已用%") && !buf.contains("Use%") && !buf.contains("use%")) {
                    String[] st = buf.trim().split("\\s+");
                    String a = st[1];
                    int totalDisk1 = Integer.parseInt(a);
                    totalDisk += totalDisk1;
                }
            }
            reader.close();

            //查看版本信息
            BufferedReader reader4 = ConnectionUtil.getSession(connection, CpuFileds.getVESION());
            String version = ConnectionUtil.readBuffer(reader4);
            reader4.close();
            //查询运行时间
            BufferedReader reader5 = ConnectionUtil.getSession(connection, CpuFileds.getRunningTime());
            String runningTime = ConnectionUtil.readBuffer(reader5);
            reader5.close();
            //查询cpu核数
            BufferedReader reader6 = ConnectionUtil.getSession(connection, CpuFileds.getCpuCore());
            String cpuCore = ConnectionUtil.readBuffer(reader6);
            reader5.close();
            String cpuCore1 = cpuCore.split(":")[1];
            reader6.close();
            cpuSingleInfoVO = new CpuSingleInfoVO(cpuInfo.getVirtualName(), cpuInfo.getStatus(), cpuInfo.getCpu(), cpuInfo.getMemory(), cpuInfo.getDisk(), cpuInfo.getIp());
            cpuSingleInfoVO.setMapList(mapList);
            cpuSingleInfoVO.setTotalDisk(totalDisk + "GB");
            cpuSingleInfoVO.setVersion(version);
            cpuSingleInfoVO.setRunningTime(runningTime);
            cpuSingleInfoVO.setTotalMemory(allMemo + "MB");
            cpuSingleInfoVO.setCpuCore(cpuCore1 + "核");
        } catch (IOException e) {
            responseModel.setErrorMsg("连接失败");
            logger.error(e.getMessage());
            return responseModel;
        } finally {
            connection.close();
        }
        responseModel.setData(cpuSingleInfoVO);
        return responseModel;
    }

    /**
     * 关机
     *
     * @param ip
     * @return
     */
    @Override
    public ResponseModel<Integer> shutDown(String ip) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        ServiceDto vo = serviceDtoMapper.queryByIp(ip);
        Connection connection = null;
        try {
            //创建连接
            connection = ConnectionUtil.getConnect(vo.getServiceIp(), 22, vo.getServiceAccount(), vo.getServicePassword());
            BufferedReader reader = ConnectionUtil.getSession(connection, CpuFileds.getShutDown());
            IOUtils.closeQuietly(reader);
            responseModel.success(1);
        } catch (IOException e) {
            responseModel.setErrorMsg("连接失败");
            logger.error(e.getMessage());
            return responseModel;
        } finally {
            connection.close();
        }
        return responseModel;
    }


    /**
     * 重启
     *
     * @param ip
     * @return
     */
    @Override
    public ResponseModel<Integer> restart(String ip) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        ServiceDto vo = serviceDtoMapper.queryByIp(ip);
        Connection connection = null;
        try {
            //创建连接
            connection = ConnectionUtil.getConnect(vo.getServiceIp(), 22, vo.getServiceAccount(), vo.getServicePassword());
            BufferedReader reader = ConnectionUtil.getSession(connection, CpuFileds.getReStart());
            IOUtils.closeQuietly(reader);
            responseModel.success(1);
        } catch (IOException e) {
            responseModel.setErrorMsg("连接失败");
            logger.error(e.getMessage());
            return responseModel;
        } finally {
            connection.close();
        }
        return responseModel;
    }


    //部署
    @Override
    @Transactional
    public ResponseModel<Object> deploy( String ip, String fileName) {
        ResponseModel<Object> responseModel = new ResponseModel<>();
        ServiceDto serviceDto = computerServerService.queryByIp(ip);
        List<SoftServiceStatus> count = softServiceStatusMapper.queryAll(ip, fileName);
        if (count.size() > 0) {
            responseModel.setErrorMsg("Installed");
            return responseModel;
        }
        //创建连接
        Connection connection = null;
        try {
            //创建连接
            connection = ConnectionUtil.getConnect(serviceDto.getServiceIp(), 22, serviceDto.getServiceAccount(), serviceDto.getServicePassword());
            //判断是否获取到连接
            if (!connection.isAuthenticationComplete()) {
                responseModel.setErrorMsg("服务器连接失败");
                return responseModel;
            }
            SFTPUtil sftp = new SFTPUtil(serviceDto.getServiceAccount(), serviceDto.getServicePassword(), serviceDto.getServiceIp(), 22);
            sftp.login();
            //本机磁盘上的文件,读取文件
            String diskFile = fileName.substring(fileName.lastIndexOf("/") + 1);
            File file = new File("/usr/files/" + diskFile);
            InputStream is = new FileInputStream(file);
            int n = fileName.indexOf("/", 1);
            //基础路径 例如 /usr
            String basePath = fileName.substring(0, n);
            //路径 例如  liu/test
            String directory = fileName.substring(n + 1, fileName.lastIndexOf("/"));
            // xxx.jar
            String fileName1 = fileName.substring(fileName.lastIndexOf("/") + 1);
            //上传
            sftp.upload(basePath, directory, fileName1, is);
            sftp.logout();
            responseModel.setSuccess(true);
            is.close();
            return responseModel;
        } catch (IOException e) {
            responseModel.setErrorMsg("服务器连接失败");
            return responseModel;
        } catch (SftpException e) {
            responseModel.setErrorMsg("服务器连接失败");
            return responseModel;
        } finally {
            ConnectionUtil.closeConnection(connection);
        }
    }


    /**
     * 对软件进行启动,停止等操作
     *
     * @param ip       虚拟机的ip
     * @param fileName 软件服务包的文件名
     * @param state    安装软件的状态,例如 启动 安装  重启  停止
     * @return
     */
    @Override
    public ResponseModel<SoftStatusVO> deploySoftware( String ip, String state, String fileName) {
        ResponseModel<SoftStatusVO> responseModel = new ResponseModel<>();
        SoftStatusVO softStatusVO = new SoftStatusVO();
        List<SoftServiceStatus> softServiceStatuses = new ArrayList<>();
        SoftServiceStatus serviceStatus = new SoftServiceStatus();
        serviceStatus.setIp(ip);
        serviceStatus.setFilePackage(fileName);
        ServiceDto serviceDto = computerServerService.queryByIp(ip);
        List<SoftServiceStatus> count = softServiceStatusMapper.queryAll(ip, fileName);
        if (count.size() <= 0) {
            responseModel.setErrorMsg("该虚拟机未安装该软件,不能进行安装以外的操作");
            return responseModel;
        }
        //创建连接
        Connection connection = null;
        try {
            //创建连接
            connection = ConnectionUtil.getConnect(serviceDto.getServiceIp(), 22, serviceDto.getServiceAccount(), serviceDto.getServicePassword());
            //判断是否获取到连接
            if (!connection.isAuthenticationComplete()) {
                responseModel.setErrorMsg("服务器连接失败!");
                return responseModel;
            }
            //启动命令
            if (state.equals("start")) {
                BufferedReader reader1 = ConnectionUtil.getSession(connection, CpuFileds.getDeploySoftware(state, fileName));
                String cpuInfo = ConnectionUtil.readBuffer(reader1);
                if (StringUtils.equals("RUN", cpuInfo) || StringUtils.equals("RUNNING", cpuInfo)) {
                    if (StringUtils.equals("RUNNING", cpuInfo)) {
                        responseModel.setErrorMsg("服务正在启动,无法再次启动");
                        return responseModel;
                    }
                    BufferedReader reader2 = ConnectionUtil.getSession(connection, CpuFileds.getDeploySoftware("status", fileName));
                    String pid = ConnectionUtil.readBuffer(reader2);
                    if (StringUtils.equals("NOTRUN", pid)) {
                        responseModel.setErrorMsg("服务启动失败");
                        return responseModel;
                    }else {
                        serviceStatus.setpId(pid);
                    }
                    serviceStatus.setStatus("running");
                } else {
                    responseModel.setErrorMsg("服务启动失败");
                    return responseModel;
                }
            }
            //停止命令
            if (state.equals("stop")) {
                BufferedReader reader1 = ConnectionUtil.getSession(connection, CpuFileds.getDeploySoftware(state, fileName));
                String cpuInfo = ConnectionUtil.readBuffer(reader1);
                if (StringUtils.equals("STOP", cpuInfo) || StringUtils.equals("NOTRUN", cpuInfo)) {
                    if (StringUtils.equals("NOTRUN", cpuInfo)){
                        responseModel.setErrorMsg("服务未启动,无法进行停止操作");
                        return responseModel;
                    }
                    serviceStatus.setpId(" ");
                    serviceStatus.setStatus("stop");
                } else {
                    responseModel.setErrorMsg("服务停止失败");
                    return responseModel;
                }
            }
            softServiceStatusMapper.update(serviceStatus);
            softServiceStatuses.add(serviceStatus);
            softStatusVO.setSoftServiceStatuses(softServiceStatuses);
            responseModel.setData(softStatusVO);
            return responseModel;
        } catch (Exception e) {
            responseModel.setErrorMsg("服务器连接失败!");
            return responseModel;
        } finally {
            connection.close();
        }
    }
}
















