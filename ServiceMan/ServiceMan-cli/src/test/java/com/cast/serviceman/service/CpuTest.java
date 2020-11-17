package com.cast.serviceman.service;

import com.cast.serviceman.api.entity.ServiceDto;
import com.cast.serviceman.api.service.ComputerServerService;
import com.cast.serviceman.api.service.GetCpuInfoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * <p>Title: </p>
 * <p>Description:</p>
 *
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history: Created by wanglei on  2020/9/8
 */

public class CpuTest {

    private static GetCpuInfoService service;

    /**
     * 静态准备工作
     */
    @BeforeAll
    static void prepareSystem() {
//        ClientDubboUtil clientDubboUtil = ClientDubboUtil.getInstance();
//        ClientDubboUtil <ComputerServerService> dubboApiUtil = new ClientDubboUtil<ComputerServerService>();
        ClientDubboUtil<GetCpuInfoService> clientDubboUtil = ClientDubboUtil.getInstance();
        service = clientDubboUtil.getReferenceConfig("serviceman1.0", "1.0", GetCpuInfoService.class);
    }

    @Test
    void queryTaskTemplateTest() throws Exception {

//        service.getInfo("APSTAR09");
        service.getInfo(null,null,null,null);
    }

    @Test
    void queryOneTest() throws Exception {

//        service.getInfo("APSTAR09");
        service.getInfoByIP("192.168.3.200");
    }

//    @Test
//    void deployTest() throws Exception {
//        service.deploy("192.168.3.200", "ServiceMan-svr-1.0-SNAPSHOT.jar");
//    }
//
//    @Test
//    void start() throws Exception {
//        service.startJar("192.168.3.200", "ServiceMan-svr-1.0-SNAPSHOT.jar");
//    }

}
