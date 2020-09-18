package com.cast.serviceman.server.mapper;

import com.cast.serviceman.api.entity.SBasicServiceDto;

import java.util.List;

public interface SBasicServiceDtoMapper {
    int deleteByPrimaryKey(String basicServiceId);

    int insert(SBasicServiceDto record);

    int insertSelective(SBasicServiceDto record);

    SBasicServiceDto selectByPrimaryKey(String basicServiceId);

    List<SBasicServiceDto> queryByGroupId(String groupId);

    int updateByPrimaryKeySelective(SBasicServiceDto record);

    int updateByPrimaryKey(SBasicServiceDto record);
}