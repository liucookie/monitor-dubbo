package com.cast.serviceman.client.controller;

import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.entity.vo.CpuInfoVO;
import com.cast.serviceman.api.service.GetCpuInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("basicServer")
@Api(tags = "基础服务接口")
public class BasicServerController {
    /**
     * dubbo 2.7.7 以后, reference改为 dubboReference
     */
    @DubboReference(version = "1.0",group = "serviceman1.0",retries = 3,timeout = 2000)
    public GetCpuInfoService getCpuInfoService;

    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    @ApiOperation(value = "获取所有机器的cpu,磁盘,内存(author:lx)")
    public ResponseModel<CpuInfoVO> getInfo(){
        ResponseModel<CpuInfoVO> vo =  getCpuInfoService.getInfo(null,null,null,null);
        return vo;
    }


}
