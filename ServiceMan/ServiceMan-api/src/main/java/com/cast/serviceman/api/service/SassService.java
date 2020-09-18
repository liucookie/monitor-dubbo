package com.cast.serviceman.api.service;

import com.cast.serviceman.api.entity.SassDto;
import com.cast.serviceman.api.entity.TGroup;
import com.cast.serviceman.api.entity.common.ResponseModel;

import java.util.List;
/**
 * 软件服务
 */
public interface SassService {

    void  add(SassDto po);

    void  update(SassDto po);

    //根据卫星id查询下属卫星列表
    ResponseModel<List<SassDto>> selectBySatId(Integer satId);

    //根据软件id查询
    ResponseModel<SassDto> queryById(String id);

    void delete(String id);

    String getport() throws Exception;

}
