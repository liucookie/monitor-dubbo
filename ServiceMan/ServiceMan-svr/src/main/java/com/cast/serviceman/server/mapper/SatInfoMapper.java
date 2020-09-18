package com.cast.serviceman.server.mapper;

import com.cast.serviceman.api.entity.SatInfo;

import java.util.List;

public interface SatInfoMapper {
    int deleteByPrimaryKey(Integer satKey);

    int insert(SatInfo record);

    int insertSelective(SatInfo record);

    SatInfo selectByPrimaryKey(Integer satKey);


    List<SatInfo> queryAll();

    int updateByPrimaryKeySelective(SatInfo record);

    int updateByPrimaryKey(SatInfo record);
}