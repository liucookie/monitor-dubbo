//package com.cast.serviceman.client.controller;
//
//import com.cast.serviceman.api.entity.SBasicServiceDto;
//import com.cast.serviceman.api.entity.TGroup;
//import com.cast.serviceman.api.entity.common.ResponseModel;
//import com.cast.serviceman.api.service.BasicService;
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
//@RestController
//@RequestMapping("basicServer")
//@Api(tags = "基础服务接口")
//public class BasicServerController {
//
//    /**
//     * dubbo 2.7.7 以后, reference改为 dubboReference
//     */
////    @Reference(version = "1.0",group = "serviceman1.0",retries = 3,timeout = 3000)
//    @DubboReference(version = "1.0",group = "serviceman1.0",retries = 3,timeout = 3000)
//    private BasicService basicService;
//
////    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
////    @ApiOperation(value = "查询基础服务(author:lx)")
////    public ResponseModel<List<SBasicServiceDto>> getAll(){
////        ResponseModel<List<SBasicServiceDto>> vo =  basicService.queryAll();
////        return vo;
////    }
//
//    @RequestMapping(value = "/add",method = RequestMethod.POST)
//    @ApiOperation(value = "增加基础服务(author:lx)")
//    public ResponseModel add(@RequestBody SBasicServiceDto po ){
//        basicService.add(po);
//        return new ResponseModel(true);
//    }
//
//    @RequestMapping(value = "/update",method = RequestMethod.PUT)
//    @ApiOperation(value = "更新基础服务(author:lx)")
//    public ResponseModel update(@RequestBody SBasicServiceDto po ){
//        basicService.update(po);
//        return new ResponseModel(true);
//    }
//
//    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
//    @ApiOperation(value = "删除基础服务(author:lx)")
//    public ResponseModel delete(String id){
//        basicService.delete(id);
//        return new ResponseModel(true);
//    }
//
//    @RequestMapping(value = "/addGroup",method = RequestMethod.POST)
//    @ApiOperation(value = "创建分组(author:lx)")
//    public ResponseModel add(@RequestBody TGroup po ){
//        basicService.addGroup(po);
//        return new ResponseModel(true);
//    }
//
////    @RequestMapping(value = "/getAllGroup",method = RequestMethod.GET)
////    @ApiOperation(value = "查询所有分组(author:lx)")
////    public ResponseModel<List<TGroup>> getAllGroup(){
////        ResponseModel<List<TGroup>> vo =  basicService.queryAllGroup();
////        return vo;
////    }
//}
