package com.cast.serviceman.api.service;

import com.cast.serviceman.api.entity.BasicServiceStatus;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.entity.vo.BasicSoftStatusVO;

import java.util.List;

/**
 * 基础服务运行状态相关接口
 */
public interface BasicStatusService {

    ResponseModel<Integer>  add(BasicServiceStatus po);

    ResponseModel<Integer>  update(BasicServiceStatus po);

    ResponseModel<Integer>  delete(String id);

    /**
     * 查询所有的基础服务运行状态
     * @return
     */
    ResponseModel<BasicSoftStatusVO> queryAll(String ip,  String state);

    /**
     * 查询单个的基础服务运行状态
     * @return
     */
    ResponseModel<BasicServiceStatus> queryById(String id);


}
