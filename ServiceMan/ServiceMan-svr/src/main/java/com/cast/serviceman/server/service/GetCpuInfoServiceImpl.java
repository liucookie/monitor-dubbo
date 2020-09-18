package com.cast.serviceman.server.service;

import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.service.GetCpuInfoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@Component
@DubboService(version = "1.0",group = "serviceman1.0",retries = 3,timeout = 3000)
public class GetCpuInfoServiceImpl implements GetCpuInfoService {

    @Override
    public ResponseModel<Object> getInfo() {
        //查cpu




        //查磁盘



        //查内存


        return null;
    }
}
