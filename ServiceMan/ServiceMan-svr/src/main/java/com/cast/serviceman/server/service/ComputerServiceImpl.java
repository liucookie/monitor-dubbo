package com.cast.serviceman.server.service;

import com.cast.serviceman.api.entity.ServiceDto;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.service.ComputerServerService;
import com.cast.serviceman.server.mapper.ServiceDtoMapper;
import com.cast.serviceman.server.mapper.TGroupMapper;
import com.cast.serviceman.util.CommonUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 服务器管理
 */

@Component
@DubboService(version = "1.0",group = "serviceman1.0",retries = 3,timeout = 3000)
public class ComputerServiceImpl implements ComputerServerService {

    @Resource
    private TGroupMapper groupMapper;
    @Value("${group.name}")
    private String groupName;
    @Value("${system.type}")
    private String systemType;

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
    public ResponseModel<Integer> add(ServiceDto dto) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        dto.setGroupId(groupMapper.selectByName(groupName));
        dto.setServiceId(CommonUtils.generateUUID());
        //设置服务器名称,vm+ip后两位
        String ip = dto.getServiceIp();
        String[] s = ip.split("\\.");
        String name = "vm" +s[2] + "." + s[3];
        dto.setServiceName(name);
        int number =  serviceDtoMapper.insert(dto);
        if(number > 0){
            responseModel.success(number);
        }else{
            responseModel.failed("增加服务失败");
        }
        return responseModel;

    }
    /**
     * 修改服务器, 虚拟机下
     * @param dto
     */
    @Override
    @Transactional
    public ResponseModel<Integer>  update(ServiceDto dto) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        //设置服务器名称,vm+ip后两位
        String ip = dto.getServiceIp();
        String[] s = ip.split("\\.");
        String name = "vm" +s[2] + "." + s[3];
        dto.setServiceName(name);
        int number = serviceDtoMapper.updateByPrimaryKey(dto);

        if(number > 0){
            responseModel.success(number);
        }else{
            //修改数据失败
            responseModel.failed("修改服务失败");
        }
        return responseModel;
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

    /**
     * 查询所有的虚拟机
     */

    @Override
    public  ResponseModel<List<ServiceDto>> queryAll(){
        ResponseModel<List<ServiceDto>> responseModel = new ResponseModel<>();
        List<ServiceDto> list =  serviceDtoMapper.queryAll();
        responseModel.setData(list);
        responseModel.setSuccess(true);
        return responseModel;
    }



}
