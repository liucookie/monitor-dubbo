package com.cast.serviceman.api.service;

import com.cast.serviceman.api.entity.VirtualMachine;
import com.cast.serviceman.api.entity.common.ResponseModel;

import java.util.List;

/**
 * 虚拟机
 */
public interface VirtualService {
    //根据分组id查询虚拟机
    ResponseModel<List<VirtualMachine>> queryVirtualByGId(String groupId);

    void delete(String id);

    void add(VirtualMachine po);

    void update(VirtualMachine po);

    ResponseModel<VirtualMachine> queryById(String id);
}
