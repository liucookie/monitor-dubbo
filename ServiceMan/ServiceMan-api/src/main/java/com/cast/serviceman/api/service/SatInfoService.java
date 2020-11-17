package com.cast.serviceman.api.service;

import com.cast.serviceman.api.entity.SatInfo;
import com.cast.serviceman.api.entity.SatInfo;
import com.cast.serviceman.api.entity.common.ResponseModel;

import java.util.List;

/**
 * 卫星信息表
 */
public interface SatInfoService {


    ResponseModel<List<SatInfo>> queryAll();



}
