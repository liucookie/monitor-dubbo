package com.cast.serviceman.server.service;

import com.cast.serviceman.api.entity.SBasicServiceDto;
import com.cast.serviceman.api.entity.TGroup;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.entity.vo.SBasicServiceDtoVo;
import com.cast.serviceman.api.service.BasicService;
import com.cast.serviceman.server.mapper.SBasicServiceDtoMapper;
import com.cast.serviceman.server.mapper.TGroupMapper;
import com.cast.serviceman.util.CommonUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 基础服务
 */
@Component
@DubboService(version = "1.0", group = "serviceman1.0", retries = 3, timeout = 3000)
public class BasicServiceImpl implements BasicService {

    @Resource
    private SBasicServiceDtoMapper basicServiceMapper;

    @Resource
    private TGroupMapper groupMapper;
    @Value("${group.name}")
    private String groupName;
    @Value("${system.type}")
    private String systemType;

    @Override
    @Transactional
    public ResponseModel<Integer> add(SBasicServiceDto po) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        po.setGroupId(groupMapper.selectByName(groupName));
        po.setBasicServiceId(CommonUtils.generateUUID());
        //设置服务器名称,vm+ip后两位
        String ip = po.getBasicServiceIp();
        String[] s = ip.split("\\.");
        String name = "BAS" + s[2] + "." + s[3];
        po.setBasicServiceName(name);
        int number = basicServiceMapper.insert(po);
        if (number > 0) {
            responseModel.success(number);
        } else {
            responseModel.failed("添加基础服务失败");
        }
        return responseModel;
    }

    @Override
    public ResponseModel<List<SBasicServiceDto>> queryByGroupId(String groupId) {
        ResponseModel<List<SBasicServiceDto>> responseModel = new ResponseModel<>();
        List<SBasicServiceDto> list = basicServiceMapper.queryByGroupId(groupId);
        responseModel.setData(list);
        responseModel.setSuccess(true);
        return responseModel;
    }

    @Override
    @Transactional
    public ResponseModel<Integer> update(SBasicServiceDto po) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        //设置服务器名称,vm+ip后两位
        String ip = po.getBasicServiceIp();
        String[] s = ip.split("\\.");
        String name = "BAS" + s[2] + "." + s[3];
        po.setBasicServiceName(name);
        int number = basicServiceMapper.updateByPrimaryKeySelective(po);
        if (number > 0) {
            responseModel.success(number);
        } else {
            responseModel.failed("添加基础服务失败");
        }
        return responseModel;
    }

    @Override
    @Transactional
    public ResponseModel<Integer> delete(String id) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        int number = basicServiceMapper.deleteByPrimaryKey(id);
        if (number > 0) {
            responseModel.success(number);
        } else {
            responseModel.failed("修改基础服务失败");
        }
        return responseModel;
    }


    /**
     * 增加分组
     *
     * @param dto
     */
    @Override
    public void addGroup(TGroup dto) {
        dto.setGroupId(CommonUtils.generateUUID());
        groupMapper.insert(dto);
    }

    /**
     * 查询分组
     *
     * @return
     */
    @Override
    public ResponseModel<List<TGroup>> queryAllGroup(String pId) {
        ResponseModel<List<TGroup>> responseModel = new ResponseModel<>();
        List<TGroup> list = groupMapper.queryAllGroup(pId);
        responseModel.setData(list);
        return responseModel;
    }

    /**
     * 查询所有的基础服务信息
     *
     * @return responseModel
     */
    @Override
    public ResponseModel<List<SBasicServiceDtoVo>> queryAll() {
        ResponseModel<List<SBasicServiceDtoVo>> responseModel = new ResponseModel<>();
        List<SBasicServiceDtoVo> list = basicServiceMapper.queryAll();
        responseModel.setData(list);
        return responseModel;
    }

    @Override
    public ResponseModel<SBasicServiceDtoVo> queryById(String id) {
        ResponseModel<SBasicServiceDtoVo> responseModel = new ResponseModel<>();
        SBasicServiceDtoVo serviceDto = basicServiceMapper.selectByPrimaryKey(id);
        responseModel.setData(serviceDto);
        return responseModel;
    }
}
