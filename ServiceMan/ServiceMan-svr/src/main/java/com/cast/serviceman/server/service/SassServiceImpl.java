package com.cast.serviceman.server.service;

import com.cast.serviceman.api.entity.SassDto;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.service.SassService;
import com.cast.serviceman.server.mapper.SassDtoMapper;
import com.cast.serviceman.util.CommonUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * 软件服务
 */
@Component
@DubboService(version = "1.0",group = "serviceman1.0",retries = 3,timeout = 3000)
public class SassServiceImpl implements SassService {

    @Resource
    private SassDtoMapper sassDtoMapper;

//    @Autowired
//    private CuratorFramework zkClient;


    @Override
    @Transactional
    public void add(SassDto po) {
        po.setSaasId(CommonUtils.generateUUID());
        sassDtoMapper.insert(po);
    }

    @Override
    public ResponseModel<List<SassDto>> selectBySatId(Integer satId) {
        ResponseModel<List<SassDto>> responseModel = new ResponseModel<>();
        List<SassDto>  dto = sassDtoMapper.selectBySatId(satId);
        responseModel.setData(dto);
        return responseModel;
    }

    @Override
    public ResponseModel<SassDto> queryById(String id) {
        ResponseModel<SassDto> responseModel = new ResponseModel<>();
        SassDto  dto = sassDtoMapper.selectByPrimaryKey(id);
        responseModel.setData(dto);
        return responseModel;
    }

    @Override
    @Transactional
    public void update(SassDto po) {
        sassDtoMapper.updateByPrimaryKey(po);
    }

    @Override
    @Transactional
    public void delete(String id) {
        sassDtoMapper.deleteByPrimaryKey(id);
    }


    @Override
    public String getport() throws Exception {
//        List<String> list = zkClient.getChildren().forPath("/test");
//        String s = list.stream().sorted(String.CASE_INSENSITIVE_ORDER).findFirst().get();
        return null;
    }
}
