package com.cast.serviceman.service;

import com.cast.serviceman.api.entity.SassDto;
import com.cast.serviceman.api.entity.SatInfo;
import com.cast.serviceman.api.entity.ServiceDto;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.service.ComputerServerService;

import com.cast.serviceman.api.service.SassService;
import com.cast.serviceman.api.service.SatInfoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * <p>Title: </p>
 * <p>Description:</p>
 *
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history: Created by wanglei on  2020/9/8
 */

public class ApiConectTest {

    private static SassService computerServerService;
    /**
     * 静态准备工作
     */
    @BeforeAll
    static void prepareSystem() {
//        ClientDubboUtil clientDubboUtil = ClientDubboUtil.getInstance();
//        ClientDubboUtil <ComputerServerService> dubboApiUtil = new ClientDubboUtil<ComputerServerService>();
        ClientDubboUtil <SassService> clientDubboUtil =  ClientDubboUtil.getInstance();
        computerServerService =  clientDubboUtil.getReferenceConfig("serviceman1.0","1.0", SassService.class);
    }

    @Test
    void queryTaskTemplateTest() throws Exception{
        String aaa = computerServerService.getport();
        System.out.println(aaa);
    }
}
