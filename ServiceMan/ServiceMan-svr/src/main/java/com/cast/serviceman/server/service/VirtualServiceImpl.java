package com.cast.serviceman.server.service;

import com.cast.serviceman.api.entity.ServiceDto;
import com.cast.serviceman.api.entity.TGroup;
import com.cast.serviceman.api.entity.VirtualMachine;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.service.VirtualService;
import com.cast.serviceman.server.mapper.ServiceDtoMapper;
import com.cast.serviceman.server.mapper.VirtualMachineMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 虚拟机
 */
@Service(version = "1.0",group = "serviceman1.0",retries = 3,timeout = 3000)
public class VirtualServiceImpl implements VirtualService {

    @Resource
    private VirtualMachineMapper virtualMachineMapper;
    @Resource
    private ServiceDtoMapper serviceDtoMapper;

    /**
     * 分组id查询下面所有的虚拟机
     * @param groupId
     * @return
     */
    @Override
    public ResponseModel<List<VirtualMachine>> queryVirtualByGId(String groupId) {
        ResponseModel<List<VirtualMachine>> responseModel = new ResponseModel<>();
        List<VirtualMachine>  list = virtualMachineMapper.queryVirtualByGId(groupId);
        responseModel.setData(list);
        return responseModel;
    }

    /**
     * 删除虚拟机,以及服务器
     * @param id
     */
    @Override
    public void delete(String id) {
        //删除虚拟机下的所有服务器
//         List<ServiceDto >  list = serviceDtoMapper.queryVirtualByGId(id);
        serviceDtoMapper.deleteByVirtualId(id);
        //删除虚拟机
        virtualMachineMapper.deleteByPrimaryKey(id);
    }
}
