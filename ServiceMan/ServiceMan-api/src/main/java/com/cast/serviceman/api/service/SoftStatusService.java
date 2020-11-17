package com.cast.serviceman.api.service;

import com.cast.serviceman.api.entity.ServicePackage;
import com.cast.serviceman.api.entity.SoftServiceStatus;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.entity.vo.SoftStatusVO;

import java.util.List;

/**
 * 软件服务运行状态相关接口
 */
public interface SoftStatusService {

    ResponseModel<Integer>  add(SoftServiceStatus po);

    ResponseModel<Integer>  update(SoftServiceStatus po);

    ResponseModel<Integer>  delete(String id);

    /**
     * 查询所有的软件服务运行状态
     * @param  satId 卫星id
     * @param  ip 虚拟机iP
     * @param  pId 进程id
     * @param  state 状态
     * @return
     */
    ResponseModel<SoftStatusVO> querySoft(String satId, String ip, String pId, String state,String filePackage);

    /**
     * 查询单个的软件服务运行状态
     * @return
     */
    ResponseModel<SoftServiceStatus> queryById(String id);

    /**
     * 停止服务
     * @param pId 进程id
     * @return
     */
    ResponseModel<Object> stopService(String pId,String ip);


    /**
     * 调用软件服务包文件
     */
    ResponseModel<List<ServicePackage>>  queryAll();

    /**
     *查询所有的软件服务运行状态
     */

    ResponseModel<SoftStatusVO> query();

}
