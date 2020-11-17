package com.cast.serviceman.server.mapper;


import com.cast.serviceman.api.entity.ServicePackage;

import java.util.List;

/**
 * 软件服务包
 */
public interface ServicePackageMapper {

    //查询所有的软件服务包
    List<ServicePackage> queryAll();


}