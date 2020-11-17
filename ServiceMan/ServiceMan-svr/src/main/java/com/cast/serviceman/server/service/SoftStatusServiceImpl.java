package com.cast.serviceman.server.service;

import ch.ethz.ssh2.Connection;
import com.cast.serviceman.api.entity.ServiceDto;
import com.cast.serviceman.api.entity.ServicePackage;
import com.cast.serviceman.api.entity.SoftServiceStatus;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.entity.vo.SoftStatusVO;
import com.cast.serviceman.api.service.ComputerServerService;
import com.cast.serviceman.api.service.SoftStatusService;
import com.cast.serviceman.common.CpuFileds;
import com.cast.serviceman.server.mapper.ServiceDtoMapper;
import com.cast.serviceman.server.mapper.ServicePackageMapper;
import com.cast.serviceman.server.mapper.SoftServiceStatusMapper;
import com.cast.serviceman.util.CommonUtils;
import com.cast.serviceman.util.ConnectionUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 软件服务运行状态
 */
@Component
@DubboService(version = "1.0", group = "serviceman1.0", retries = 3, timeout = 3000)
public class SoftStatusServiceImpl implements SoftStatusService {

    @Resource
    private SoftServiceStatusMapper basicServiceMapper;

    @Autowired
    private ComputerServerService computerServerService;
    @Resource
    private ServiceDtoMapper serviceDtoMapper;

    @Resource
    private ServicePackageMapper servicePackageMapper;

    /**
     * 增加
     * @param po
     * @return
     */
    @Override
    @Transactional
    public ResponseModel<Integer> add(SoftServiceStatus po) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        po.setSoftId(CommonUtils.generateUUID());
        int number = basicServiceMapper.insert(po);
        if (number > 0) {
            responseModel.success(number);
        } else {
            responseModel.failed("添加软件服务状态失败");
        }
        return responseModel;
    }

    @Override
    @Transactional
    public ResponseModel<Integer> update(SoftServiceStatus po) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        int number = basicServiceMapper.update(po);
        if (number > 0) {
            responseModel.success(number);
        } else {
            responseModel.failed("修改软件服务状态失败");
        }
        return responseModel;
    }

    @Override
    @Transactional
    public ResponseModel<Integer> delete(String id) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        int number = basicServiceMapper.delete(id);
        if (number > 0) {
            responseModel.success(number);
        } else {
            responseModel.failed("删除软件服务状态失败");
        }
        return responseModel;
    }


    /**
     * 查询所有的软件服务运行状态
     *
     * @param satId 卫星id
     * @param ip    虚拟机iP
     * @return
     */
    @Override
    public ResponseModel<SoftStatusVO> querySoft(String satId, String ip, String pId, String state ,String filePackage) {
        ResponseModel<SoftStatusVO> responseModel = new ResponseModel<>();
        SoftStatusVO softStatusVO = new SoftStatusVO();
        List<SoftServiceStatus> list = basicServiceMapper.queryAll(ip,filePackage);
        for (SoftServiceStatus soft : list) {
            ServiceDto serviceDto = computerServerService.queryByIp(soft.getIp());
            if (null == serviceDto) {
                continue;
            }
            Connection connection = null;
            try {
                //初始设置为故障

                //创建连接
                connection = ConnectionUtil.getConnect(serviceDto.getServiceIp(), 22, serviceDto.getServiceAccount(), serviceDto.getServicePassword());
                //判断是否获取到连接
                if (!connection.isAuthenticationComplete()) {
                    continue;
                }
                //执行  ps -e|grep  命令
                String cmd = CpuFileds.getPsGrep() + " " + soft.getSoftName()+ "|grep -v grep";
                BufferedReader reader1 = ConnectionUtil.getSession(connection, cmd);
                String cpuInfo = ConnectionUtil.readBuffer(reader1);

                //如果返回的命令不为空,说明是运行中
                if (StringUtils.isNotEmpty(cpuInfo)) {
                    String[] st = cpuInfo.trim().split("\\s+");
                    String a = st[0];
                    // 设置进程id
                    soft.setpId(a);
                    soft.setStatus("running");
                }
                IOUtils.closeQuietly(reader1);
                //根据返回的数据判断软件服务是否正常
            } catch (IOException e) {
                responseModel.setErrorMsg("连接失败");
            } finally {
                assert connection != null;
                connection.close();
            }
        }
        //过滤条件,pid.状态
        if (StringUtils.isNotEmpty(pId)) {
            list = list.stream().filter(stats -> StringUtils.equals(pId, stats.getpId())).collect(Collectors.toList());
        }
        if (StringUtils.isNotEmpty(state)) {
            list = list.stream().filter(stats -> StringUtils.equals(state, stats.getStatus())).collect(Collectors.toList());
        }
        List<SoftServiceStatus> list1 = list.stream().filter(stats -> StringUtils.equals("running", stats.getStatus())).collect(Collectors.toList());

        softStatusVO.setSoftServiceStatuses(list);
        //运行中的
        softStatusVO.setRunningCount(list1.size());
        //停止的
        softStatusVO.setStopCount(list.size() - list1.size());
        //全部的
        softStatusVO.setTotalCount(list.size());
        responseModel.setData(softStatusVO);
        return responseModel;
    }

    /**
     * 查询单个软件服务运行状态
     *
     * @return responseModel
     */
    @Override
    public ResponseModel<SoftServiceStatus> queryById(String id) {
        ResponseModel<SoftServiceStatus> responseModel = new ResponseModel<>();
        SoftServiceStatus serviceDto = basicServiceMapper.select(id);
        responseModel.setData(serviceDto);
        return responseModel;
    }

    /**
     * 停止服务
     *
     * @param pId 进程id
     * @param ip  虚拟机ip
     * @return
     */
    @Override
    public ResponseModel<Object> stopService(String pId, String ip) {
        ResponseModel<Object> responseModel = new ResponseModel<>();
        ServiceDto dto = serviceDtoMapper.queryByIp(ip);
        Connection connection = null;
        try {
            //创建连接
            connection = ConnectionUtil.getConnect(dto.getServiceIp(), 22, dto.getServiceAccount(), dto.getServicePassword());
            BufferedReader reader = ConnectionUtil.getSession(connection, CpuFileds.getKILL() + "  " + pId);
            IOUtils.closeQuietly(reader);
        } catch (IOException e) {
            responseModel.setErrorMsg("连接失败");
        } finally {
            assert connection != null;
            connection.close();
        }
        return responseModel;
    }

    /**
     * 软件包的调用
     */

    @Override
    public  ResponseModel<List<ServicePackage>> queryAll(){
        ResponseModel<List<ServicePackage>> responseModel = new ResponseModel<>();
        List<ServicePackage> list = servicePackageMapper.queryAll();
        responseModel.setData(list);
        responseModel.setSuccess(true);
        return responseModel;
    }

    @Override
    public ResponseModel<SoftStatusVO> query() {
        ResponseModel<SoftStatusVO> responseModel = new ResponseModel<>();
        SoftStatusVO softStatusVO = new SoftStatusVO();
        List<SoftServiceStatus> list = basicServiceMapper.queryAll(null,null);
        softStatusVO.setSoftServiceStatuses(list);
        responseModel.setData(softStatusVO);
        responseModel.setSuccess(true);
        return  responseModel;
    }
}
