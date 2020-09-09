package com.cast.serviceman.server.mapper;

import com.cast.serviceman.api.entity.SBasicServiceDto;

public interface SBasicServiceDtoMapper {
    int deleteByPrimaryKey(String basicServiceId);

    int insert(SBasicServiceDto record);

    int insertSelective(SBasicServiceDto record);

    SBasicServiceDto selectByPrimaryKey(String basicServiceId);

    int updateByPrimaryKeySelective(SBasicServiceDto record);

    int updateByPrimaryKey(SBasicServiceDto record);
}