package com.cast.serviceman.server.mapper;

import com.cast.serviceman.api.entity.ServiceDto;
import com.cast.serviceman.api.entity.vo.ServiceDtoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceDtoMapper {
    int deleteByPrimaryKey(String serviceId);

    int deleteByVirtualId(String virtualId);

    int insert(ServiceDto record);

    int insertSelective(ServiceDto record);

    ServiceDto selectByPrimaryKey(String serviceId);

    ServiceDto queryByIp(String ip);

    List<ServiceDto> queryVirtualByGId(String virtualId);

    int updateByPrimaryKeySelective(ServiceDto record);

    int updateByPrimaryKey(ServiceDto record);

    /**
     * 查询所有的虚拟机信息
     * @return
     */
    List<ServiceDtoVo> queryAll(@Param("satId") String satId, @Param("serviceName") String serviceName ,  @Param("ip") String ip);

}