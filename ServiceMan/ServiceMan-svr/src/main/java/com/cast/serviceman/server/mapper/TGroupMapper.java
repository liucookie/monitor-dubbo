package com.cast.serviceman.server.mapper;

import com.cast.serviceman.api.entity.TGroup;

import java.util.List;

public interface TGroupMapper {
    int deleteByPrimaryKey(String groupId);

    int insert(TGroup record);

    int insertSelective(TGroup record);

    TGroup selectByPrimaryKey(String groupId);

    List<TGroup> queryAllGroup(String pId);

    int updateByPrimaryKeySelective(TGroup record);

    int updateByPrimaryKey(TGroup record);
}