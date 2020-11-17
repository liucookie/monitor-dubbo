package com.cast.serviceman.service;

import com.cast.serviceman.api.service.GetCpuInfoService;
import com.cast.serviceman.api.service.SoftStatusService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>Title: </p>
 * <p>Description:</p>
 *
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history: Created by wanglei on  2020/9/8
 */

public class SoftStatusImplTest {

    private static SoftStatusService service;

    /**
     * 静态准备工作
     */
    @BeforeAll
    static void prepareSystem() {
//        ClientDubboUtil clientDubboUtil = ClientDubboUtil.getInstance();
//        ClientDubboUtil <ComputerServerService> dubboApiUtil = new ClientDubboUtil<ComputerServerService>();
        ClientDubboUtil<SoftStatusService> clientDubboUtil = ClientDubboUtil.getInstance();
        service = clientDubboUtil.getReferenceConfig("serviceman1.0", "1.0", SoftStatusService.class);
    }



    @Test
    void start() throws Exception {
        service.querySoft("APSTAR09","192.168.3.200 ",null,null,null);
    }


}
