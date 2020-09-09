package com.cast.serviceman.server.service;

import com.cast.serviceman.api.entity.ServiceDto;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.service.ComputerServerService;
import com.cast.serviceman.server.mapper.ServiceDtoMapper;
import com.cast.serviceman.util.CommonUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 服务器管理
 */
@Service(version = "1.0",group = "serviceman1.0",retries = 3,timeout = 3000)
public class ComputerServiceImpl implements ComputerServerService {

    @Resource
    private ServiceDtoMapper serviceDtoMapper;

    @Override
    public ResponseModel<List<ServiceDto>> queryVirtualByGId(String virtualId) {
        ResponseModel<List<ServiceDto>> responseModel = new ResponseModel<>();
        List<ServiceDto>  list = serviceDtoMapper.queryVirtualByGId(virtualId);
        responseModel.setData(list);
        responseModel.setSuccess(true);
        return responseModel;
    }

    /**
     * 增加服务器, 虚拟机下
     * @param dto
     */
    @Override
    @Transactional
    public void add(ServiceDto dto) {
        dto.setServiceId(CommonUtils.generateUUID());
        //设置服务器名称,vm+ip后两位
        String ip = dto.getServiceIp();
        String[] s = ip.split("\\.");
        String name = "vm" +s[2] + "." + s[3];
        dto.setServiceName(name);
        serviceDtoMapper.insert(dto);
    }
    /**
     * 修改服务器, 虚拟机下
     * @param dto
     */
    @Override
    @Transactional
    public void update(ServiceDto dto) {
        //设置服务器名称,vm+ip后两位
        String ip = dto.getServiceIp();
        String[] s = ip.split("\\.");
        String name = "vm" +s[2] + "." + s[3];
        dto.setServiceName(name);
        serviceDtoMapper.updateByPrimaryKey(dto);
    }


    /**
     * 查询单个服务器信息
     * @param id
     * @return
     */
    @Override
    public ServiceDto queryById(String id) {
        ServiceDto dto = serviceDtoMapper.selectByPrimaryKey(id);
        return dto;
    }


}
