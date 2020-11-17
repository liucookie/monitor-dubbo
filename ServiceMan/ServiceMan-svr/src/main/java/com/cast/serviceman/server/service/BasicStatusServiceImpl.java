package com.cast.serviceman.server.service;

import ch.ethz.ssh2.Connection;
import com.cast.serviceman.api.entity.BasicServiceStatus;
import com.cast.serviceman.api.entity.ServiceDto;
import com.cast.serviceman.api.entity.SoftServiceStatus;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.entity.vo.BasicSoftStatusVO;
import com.cast.serviceman.api.entity.vo.SoftStatusVO;
import com.cast.serviceman.api.service.BasicStatusService;
import com.cast.serviceman.api.service.ComputerServerService;
import com.cast.serviceman.common.CpuFileds;
import com.cast.serviceman.server.mapper.BasicServiceStatusMapper;
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
 * 基础服务运行状态
 */
@Component
@DubboService(version = "1.0", group = "serviceman1.0", retries = 3, timeout = 3000)
public class BasicStatusServiceImpl implements BasicStatusService {

    @Resource
    private BasicServiceStatusMapper basicServiceMapper;
    @Autowired
    private ComputerServerService computerServerService;

    /**
     * 增加
     * @param po
     * @return
     */
    @Override
    @Transactional
    public ResponseModel<Integer> add(BasicServiceStatus po) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        po.setBasicId(CommonUtils.generateUUID());
        int number = basicServiceMapper.insert(po);
        if (number > 0) {
            responseModel.success(number);
        } else {
            responseModel.failed("添加基础服务状态失败");
        }
        return responseModel;
    }

    @Override
    @Transactional
    public ResponseModel<Integer> update(BasicServiceStatus po) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        int number = basicServiceMapper.updateByPrimaryKeySelective(po);
        if (number > 0) {
            responseModel.success(number);
        } else {
            responseModel.failed("修改基础服务状态失败");
        }
        return responseModel;
    }

    @Override
    @Transactional
    public ResponseModel<Integer> delete(String id) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        int number = basicServiceMapper.deleteByPrimaryKey(id);
        if (number > 0) {
            responseModel.success(number);
        } else {
            responseModel.failed("删除基础服务状态失败");
        }
        return responseModel;
    }


    /**
     * 查询所有的基础服务运行状态
     * ip ip地址
     * state 状态
     *
     * @return responseModel
     */
    @Override
    public ResponseModel<BasicSoftStatusVO> queryAll(String ip, String state) {
        ResponseModel<BasicSoftStatusVO> responseModel = new ResponseModel<>();
        BasicSoftStatusVO softStatusVO = new BasicSoftStatusVO();
        List<BasicServiceStatus> list = basicServiceMapper.queryAll(ip);
        for (BasicServiceStatus soft : list) {
            ServiceDto serviceDto = computerServerService.queryByIp(soft.getIp());
            if (null == serviceDto) {
                continue;
            }
            soft.setVirtualName(serviceDto.getServiceName());
            Connection connection = null;
            try {
                //初始设置为故障
                soft.setStatus("stop");
                //创建连接
                connection = ConnectionUtil.getConnect(serviceDto.getServiceIp(), 22, serviceDto.getServiceAccount(), serviceDto.getServicePassword());
                if (!connection.isAuthenticationComplete()) {
                    continue;
                }
                //执行p s grep命令
                String cmd = CpuFileds.getPsGrep() + " " + soft.getSoftName() + "|grep -v grep";;
                BufferedReader reader1 = ConnectionUtil.getSession(connection, cmd);
                String cpuInfo = ConnectionUtil.readBuffer(reader1);
                //初始设置为故障
                soft.setStatus("stop");
                //如果返回的命令不为空,说明是运行中
                if(StringUtils.isNotEmpty(cpuInfo)){
                    soft.setStatus("running");
                }
                IOUtils.closeQuietly(reader1);
                //根据返回的数据判断软件服务是否正常
            } catch (IOException e) {
                responseModel.setErrorMsg("连接失败");
            } finally {
                connection.close();
            }
        }
        if (StringUtils.isNotEmpty(state)) {
            list = list.stream().filter(stats -> StringUtils.equals(state, stats.getStatus())).collect(Collectors.toList());
        }
        //运行中的
        List<BasicServiceStatus> list1 = list.stream().filter(stats -> StringUtils.equals("running", stats.getStatus())).collect(Collectors.toList());

        softStatusVO.setBasicServiceStatusList(list);
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
     * 查询单个基础服务运行状态
     *
     * @return responseModel
     */
    @Override
    public ResponseModel<BasicServiceStatus> queryById(String id) {
        ResponseModel<BasicServiceStatus> responseModel = new ResponseModel<>();
        BasicServiceStatus serviceDto = basicServiceMapper.selectByPrimaryKey(id);
        responseModel.setData(serviceDto);
        return responseModel;
    }
}
