package com.cast.serviceman.api.service;

import com.cast.serviceman.api.entity.common.ResponseModel;


/**
 * 基础服务相关接口
 */
public interface GetCpuInfoService {

    ResponseModel<Object> getInfo();
}
