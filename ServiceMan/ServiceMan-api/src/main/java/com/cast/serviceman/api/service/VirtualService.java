package com.cast.serviceman.api.service;

import com.cast.serviceman.api.entity.VirtualMachine;
import com.cast.serviceman.api.entity.common.ResponseModel;

import java.util.List;

public interface VirtualService {
    ResponseModel<List<VirtualMachine>> queryVirtualByGId(String groupId);

    void delete(String id);
}
