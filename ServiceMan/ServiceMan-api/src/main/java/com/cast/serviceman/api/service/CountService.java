package com.cast.serviceman.api.service;

import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.entity.vo.MessageCountVO;


/**
 * 统计
 */
public interface CountService {

    /**
     * 查询服务器,软件服务,基础服务总数
     * @return
     */
    ResponseModel<MessageCountVO> queryAll(String satId);
    



}
