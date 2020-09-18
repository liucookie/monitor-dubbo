package com.cast.serviceman.api.service;

import com.cast.serviceman.api.entity.ServiceDto;
import com.cast.serviceman.api.entity.common.ResponseModel;

import java.util.List;

/**
 * 服务器相关接口
 */
public interface ComputerServerService {
    ResponseModel<List<ServiceDto>> queryVirtualByGId(String groupId);

    ResponseModel<Integer> add(ServiceDto dto);

    ResponseModel<Integer>  update(ServiceDto dto);

    ServiceDto queryById(String id);

    /**
     * 查询所有的服务器信息
     * @return
     */
    ResponseModel<List<ServiceDto>> queryAll();


}
