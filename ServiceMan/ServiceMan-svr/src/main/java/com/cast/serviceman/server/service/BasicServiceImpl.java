package com.cast.serviceman.server.service;

import com.cast.serviceman.api.entity.SBasicServiceDto;
import com.cast.serviceman.api.entity.TGroup;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.service.BasicService;
import com.cast.serviceman.server.mapper.SBasicServiceDtoMapper;
import com.cast.serviceman.server.mapper.TGroupMapper;
import com.cast.serviceman.util.CommonUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 基础服务
 */
@Service(version = "1.0",group = "serviceman1.0",retries = 3,timeout = 3000)
public class BasicServiceImpl implements BasicService {

    @Resource
    private SBasicServiceDtoMapper basicServiceMapper;

    @Resource
    private TGroupMapper groupMapper;

    @Override
    @Transactional
    public void add(SBasicServiceDto po) {
        po.setBasicServiceId(CommonUtils.generateUUID());
        basicServiceMapper.insert(po);
    }

    @Override
    public ResponseModel<List<SBasicServiceDto>> queryAll() {
        return null;
    }

    @Override
    @Transactional
    public void update(SBasicServiceDto po) {
        basicServiceMapper.updateByPrimaryKey(po);
    }

    @Override
    @Transactional
    public void delete(String id) {
        basicServiceMapper.deleteByPrimaryKey(id);
    }


    /**
     * 增加分组
     * @param dto
     */
    @Override
    public void addGroup(TGroup dto) {
        dto.setGroupId(CommonUtils.generateUUID());
        groupMapper.insert(dto);
    }

    /**
     * 查询分组
     * @return
     */
    @Override
    public ResponseModel<List<TGroup>> queryAllGroup() {
        ResponseModel<List<TGroup>> responseModel = new ResponseModel<>();
        List<TGroup>  list = groupMapper.queryAllGroup("1");
        responseModel.setData(list);
        return responseModel;
    }
}
