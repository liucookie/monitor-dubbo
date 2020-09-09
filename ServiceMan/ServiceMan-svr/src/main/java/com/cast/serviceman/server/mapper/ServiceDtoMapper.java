package com.cast.serviceman.server.mapper;

import com.cast.serviceman.api.entity.ServiceDto;

import java.util.List;

public interface ServiceDtoMapper {
    int deleteByPrimaryKey(String serviceId);

    int deleteByVirtualId(String virtualId);

    int insert(ServiceDto record);

    int insertSelective(ServiceDto record);

    ServiceDto selectByPrimaryKey(String serviceId);

    List<ServiceDto> queryVirtualByGId(String virtualId);

    int updateByPrimaryKeySelective(ServiceDto record);

    int updateByPrimaryKey(ServiceDto record);
}