package com.cast.serviceman.api.service;

import com.cast.serviceman.api.entity.SBasicServiceDto;
import com.cast.serviceman.api.entity.TGroup;
import com.cast.serviceman.api.entity.common.ResponseModel;

import java.util.List;

/**
 * 基础服务相关接口
 */
public interface BasicService {

    ResponseModel<Integer>  add(SBasicServiceDto po);

    ResponseModel<Integer>  update(SBasicServiceDto po);

    // 根据分组id查询下属基础服务
    ResponseModel<List<SBasicServiceDto>> queryByGroupId(String groupId);

    void delete(String id);

    void addGroup(TGroup dto);

    ResponseModel<List<TGroup>> queryAllGroup(String pId);
}
