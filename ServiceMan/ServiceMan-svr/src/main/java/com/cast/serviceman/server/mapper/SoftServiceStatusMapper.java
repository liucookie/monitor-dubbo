package com.cast.serviceman.server.mapper;

import com.cast.serviceman.api.entity.SoftServiceStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SoftServiceStatusMapper {
    int delete(String softId);

    int insert(SoftServiceStatus record);

    //按照id查询服务
    SoftServiceStatus select(String softId);

    //查询软件服务
    List<SoftServiceStatus> queryAll(@Param("ip") String ip ,@Param("filePackage") String filePackage);

    int update(SoftServiceStatus record);



}