package com.cast.serviceman.server.service;

import com.cast.serviceman.api.entity.SatInfo;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.service.SatInfoService;
import com.cast.serviceman.server.mapper.SatInfoMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 卫星
 */
@Component
@DubboService(version = "1.0",group = "serviceman1.0",retries = 3,timeout = 3000)
public class SatInfoServiceImpl implements SatInfoService {

    @Resource
    private SatInfoMapper satInfoMapper;

    @Override
    public ResponseModel<List<SatInfo>> queryAll() {
        ResponseModel<List<SatInfo>> responseModel = new ResponseModel<>();
        List<SatInfo>  list = satInfoMapper.queryAll();
        responseModel.setData(list);
        responseModel.setSuccess(true);
        return responseModel;
    }



}
