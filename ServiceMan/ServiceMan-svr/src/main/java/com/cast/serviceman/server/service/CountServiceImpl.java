package com.cast.serviceman.server.service;

import com.cast.serviceman.api.entity.SassDto;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.entity.vo.MessageCountVO;
import com.cast.serviceman.api.entity.vo.SBasicServiceDtoVo;
import com.cast.serviceman.api.entity.vo.ServiceDtoVo;
import com.cast.serviceman.api.service.CountService;
import com.cast.serviceman.server.mapper.SBasicServiceDtoMapper;
import com.cast.serviceman.server.mapper.SassDtoMapper;
import com.cast.serviceman.server.mapper.ServiceDtoMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统计
 */
@Component
@DubboService(version = "1.0", group = "serviceman1.0", retries = 3, timeout = 3000)
public class CountServiceImpl implements CountService {

    @Resource
    private SBasicServiceDtoMapper basicServiceMapper;
    @Resource
    private ServiceDtoMapper serviceDtoMapper;
    @Resource
    private SassDtoMapper sassDtoMapper;


    /**
     * 查询服务器,软件服务,基础服务总数
     *
     * @return responseModel
     */
    @Override
    public ResponseModel<MessageCountVO> queryAll(String satId) {
        MessageCountVO messageCountVO = new MessageCountVO();
        ResponseModel<MessageCountVO> responseModel = new ResponseModel<>();
        //基础服务
        List<SBasicServiceDtoVo> list = basicServiceMapper.queryAll();
        //虚拟机服务器
        List<ServiceDtoVo> list1 = serviceDtoMapper.queryAll(satId,null,null);
        //软件服务
        List<SassDto> list2 = sassDtoMapper.selectBySatId(satId);


        messageCountVO.setBasicServiceCount(list.size());
        messageCountVO.setVirtualCount(list1.size());
        messageCountVO.setSoftServiceCount(list2.size());
        responseModel.setData(messageCountVO);
        return responseModel;
    }

}
