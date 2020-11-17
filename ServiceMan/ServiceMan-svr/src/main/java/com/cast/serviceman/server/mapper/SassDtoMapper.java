package com.cast.serviceman.server.mapper;

import com.cast.serviceman.api.entity.SassDto;

import java.util.List;

public interface SassDtoMapper {

    int deleteByPrimaryKey(String saasId);

    int insert(SassDto record);

    int insertSelective(SassDto record);

    SassDto selectByPrimaryKey(String saasId);

    List<SassDto> selectBySatId(String satId);

    int updateByPrimaryKeySelective(SassDto record);

    int updateByPrimaryKey(SassDto record);
}