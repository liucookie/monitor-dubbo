package com.cast.serviceman.server.service;

import com.cast.serviceman.api.entity.VirtualMachine;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.service.VirtualService;
import com.cast.serviceman.server.mapper.ServiceDtoMapper;
import com.cast.serviceman.server.mapper.VirtualMachineMapper;
import com.cast.serviceman.util.CommonUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 虚拟机
 */
@Component
@DubboService(version = "1.0",group = "serviceman1.0",retries = 3,timeout = 3000)
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
     * @param id 虚拟机id
     */
    @Override
    @Transactional
    public void delete(String id) {
        //删除虚拟机下的所有服务器
//         List<ServiceDto >  list = serviceDtoMapper.queryVirtualByGId(id);
        serviceDtoMapper.deleteByVirtualId(id);
        //删除虚拟机
        virtualMachineMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void add(VirtualMachine po) {
        po.setVirtualId(CommonUtils.generateUUID());
        virtualMachineMapper.insert(po);
    }

    @Override
    @Transactional
    public void update(VirtualMachine po) {
        virtualMachineMapper.updateByPrimaryKey(po);
    }

    @Override
    public ResponseModel<VirtualMachine> queryById(String id) {
        ResponseModel<VirtualMachine> responseModel = new ResponseModel<>();
        VirtualMachine  virtualMachine = virtualMachineMapper.selectByPrimaryKey(id);
        responseModel.setData(virtualMachine);
        return responseModel;
    }
}
