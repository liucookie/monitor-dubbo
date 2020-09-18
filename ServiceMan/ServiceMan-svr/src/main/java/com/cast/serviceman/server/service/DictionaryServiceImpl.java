package com.cast.serviceman.server.service;

import com.cast.serviceman.api.entity.Dictionary;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.service.DictionaryService;
import com.cast.serviceman.server.mapper.DictionaryMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@DubboService(version = "1.0", group = "serviceman1.0", retries = 3, timeout = 3000)
public class DictionaryServiceImpl implements DictionaryService {

    @Resource
    private DictionaryMapper dictionaryMapper;


    @Override
    public ResponseModel<List<Dictionary>> queryTypeCode(String dictionaryTypeCode) {
        ResponseModel<List<Dictionary>> responseModel = new ResponseModel<>();
        List<Dictionary> list = dictionaryMapper.queryTypeCode(dictionaryTypeCode);
        responseModel.setData(list);
        responseModel.setSuccess(true);
        return responseModel;
    }
}
