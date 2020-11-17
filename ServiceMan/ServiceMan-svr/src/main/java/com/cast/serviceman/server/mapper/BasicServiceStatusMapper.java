package com.cast.serviceman.server.mapper;

import com.cast.serviceman.api.entity.BasicServiceStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasicServiceStatusMapper {
    int deleteByPrimaryKey(String basicId);

    int insert(BasicServiceStatus record);

    int insertSelective(BasicServiceStatus record);

    BasicServiceStatus selectByPrimaryKey(String basicId);

    List<BasicServiceStatus> queryAll(@Param("ip") String ip);

    int updateByPrimaryKeySelective(BasicServiceStatus record);

    int updateByPrimaryKey(BasicServiceStatus record);
}