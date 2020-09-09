package com.cast.serviceman.api.service;

import com.cast.serviceman.api.entity.ServiceDto;
import com.cast.serviceman.api.entity.VirtualMachine;
import com.cast.serviceman.api.entity.common.ResponseModel;

import java.util.List;

public interface ComputerServerService {
    ResponseModel<List<ServiceDto>> queryVirtualByGId(String groupId);

    void add(ServiceDto dto);

    void update(ServiceDto dto);

    ServiceDto queryById(String id);



}
