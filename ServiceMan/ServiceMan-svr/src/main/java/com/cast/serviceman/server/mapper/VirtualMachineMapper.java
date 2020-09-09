package com.cast.serviceman.server.mapper;

import com.cast.serviceman.api.entity.VirtualMachine;

import java.util.List;

public interface VirtualMachineMapper {
    int deleteByPrimaryKey(String virtualMachineId);

    int insert(VirtualMachine record);

    int insertSelective(VirtualMachine record);

    VirtualMachine selectByPrimaryKey(String virtualMachineId);

    List<VirtualMachine> queryVirtualByGId(String groupId);

    int updateByPrimaryKeySelective(VirtualMachine record);

    int updateByPrimaryKey(VirtualMachine record);
}