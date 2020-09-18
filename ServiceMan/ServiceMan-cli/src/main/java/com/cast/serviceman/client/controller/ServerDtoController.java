//package com.cast.serviceman.client.controller;
//
//import com.cast.serviceman.api.entity.ServiceDto;
//import com.cast.serviceman.api.entity.common.ResponseModel;
//import com.cast.serviceman.api.service.ComputerServerService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.dubbo.config.annotation.DubboReference;
//import org.apache.dubbo.config.annotation.Reference;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * 服务器
// */
//@RestController
//@RequestMapping("computerServer")
//@Api(tags = "服务器相关接口")
//public class ServerDtoController {
//
////    @Reference(version = "1.0",group = "serviceman1.0",retries = 3,timeout = 3000)
//    @DubboReference(version = "1.0",group = "serviceman1.0",retries = 3,timeout = 3000)
//    private ComputerServerService service;
//
//    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
//    @ApiOperation(value = "根据虚拟机id查询下属服务器(author:lx)")
//    public ResponseModel<List<ServiceDto>> getAll(String id){
//        ResponseModel<List<ServiceDto>> vo =  service.queryVirtualByGId(id);
//        return vo;
//    }
//
//    @RequestMapping(value = "/getById",method = RequestMethod.GET)
//    @ApiOperation(value = "根据服务器id查询服务器(author:lx)")
//    public ResponseModel<ServiceDto> getById(String id){
//        ResponseModel<ServiceDto> rep = new ResponseModel<>();
//        ServiceDto vo =  service.queryById(id);
//        rep.setData(vo);
//        return rep;
//    }
//
//    @RequestMapping(value = "/add",method = RequestMethod.POST)
//    @ApiOperation(value = "增加属服务器(author:lx)")
//    public ResponseModel add(@RequestBody ServiceDto po ){
//        service.add(po);
//        return new ResponseModel(true);
//    }
//
//    @RequestMapping(value = "/update",method = RequestMethod.PUT)
//    @ApiOperation(value = "更新属服务器(author:lx)")
//    public ResponseModel update(@RequestBody ServiceDto po ){
//        service.update(po);
//        return new ResponseModel(true);
//    }
//
//
//}
