package com.cast.serviceman.server.service;

import com.cast.serviceman.api.entity.SatInfo;
import com.cast.serviceman.api.entity.TGroup;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.service.BasicService;
import com.cast.serviceman.api.service.SatInfoService;
import com.cast.serviceman.server.mapper.SatInfoMapper;
import com.cast.serviceman.server.mapper.TGroupMapper;
import com.cast.serviceman.util.CommonUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public ResponseModel<SatInfo> queryById(Integer id) {
        ResponseModel<SatInfo> responseModel = new ResponseModel<>();
        SatInfo  info = satInfoMapper.selectByPrimaryKey(id);
        responseModel.setData(info);
        responseModel.setSuccess(true);
        return responseModel;
    }


}
