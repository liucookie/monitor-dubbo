package com.cast.serviceman.server.mapper;

import com.cast.serviceman.api.entity.SBasicServiceDto;
import com.cast.serviceman.api.entity.vo.SBasicServiceDtoVo;

import java.util.List;

public interface SBasicServiceDtoMapper {
    int deleteByPrimaryKey(String basicServiceId);

    int insert(SBasicServiceDto record);

    int insertSelective(SBasicServiceDto record);

    /**
     * 查询单个
     * @param basicServiceId
     * @return
     */
    SBasicServiceDtoVo selectByPrimaryKey(String basicServiceId);

    List<SBasicServiceDto> queryByGroupId(String groupId);

    int updateByPrimaryKeySelective(SBasicServiceDto record);

    int updateByPrimaryKey(SBasicServiceDto record);


    /**
     * 查询所有基础服务信息
     * @return
     */
    List<SBasicServiceDtoVo> queryAll();


}