package com.cast.serviceman.api.service;

import com.cast.serviceman.api.entity.SBasicServiceDto;
import com.cast.serviceman.api.entity.TGroup;
import com.cast.serviceman.api.entity.common.ResponseModel;

import java.util.List;

public interface BasicService {

    void  add(SBasicServiceDto po);

    void  update(SBasicServiceDto po);

    ResponseModel<List<SBasicServiceDto>> queryAll();

    void delete(String id);

    void addGroup(TGroup dto);

    ResponseModel<List<TGroup>> queryAllGroup();
}
