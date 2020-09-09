//package com.cast.serviceman.service;
//
//import com.cast.serviceman.api.entity.common.ResponseModel;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.List;
//
//public class UserServiceTest {
//
//    /**
//     * 上下文信息
//     */
//    static ClassPathXmlApplicationContext context;
//    /**
//     * 后台服务接口类
//     */
//    private static UserService userService;
//
//    /**
//     * 静态准备工作
//     */
//    @BeforeAll
//    static void prepareSystem() {
//        String url = "client.xml";
//        context = new ClassPathXmlApplicationContext(new String[]{url});
//        context.start();
//        userService = context.getBean(UserService.class);
//
//    }
//
//    @Test
//    void queryAll() {
//        ResponseModel<List<User>> responseModel = userService.queryAll();
//        System.out.println(responseModel.getData().size());
//        System.out.println(responseModel.getData());
//        System.out.println(responseModel.getPage());
//        System.out.println((responseModel.getTotalCount()));
//
//
//    }
//
//
//}
