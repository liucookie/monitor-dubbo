package com.cast.serviceman.api.service;

import com.cast.serviceman.api.entity.SoftServiceStatus;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.entity.vo.CpuInfoVO;
import com.cast.serviceman.api.entity.vo.CpuSingleInfoVO;
import com.cast.serviceman.api.entity.vo.SoftStatusVO;

import java.io.IOException;
import java.util.List;

/**
 * 查询虚拟机磁盘,cpu,内存
 */
public interface GetCpuInfoService {

    //获取所有机器的cpu,磁盘,内存
    ResponseModel<CpuInfoVO> getInfo(String satId, String serviceName, String ip, String state);

    //综合监控-服务器,  获取单个机器的cpu,磁盘,内存
    ResponseModel<CpuSingleInfoVO> getInfoByIP(String ip);

    //关机
    ResponseModel<Integer> shutDown(String ip);

    //重启
    ResponseModel<Integer> restart(String ip);

    //调用软件服务包

    //部署
    ResponseModel<Object> deploy(String ip,String fileName)  throws IOException;


    /**
     * 对软件进行停止,启动等操作
     * @param ip 虚拟机的ip
     * @param fileName 软件服务包的文件名
     * @param state  安装软件的状态,例如 启动 安装  重启  停止
     * @return
     */
    ResponseModel<SoftStatusVO> deploySoftware( String ip , String state, String fileName);


}
