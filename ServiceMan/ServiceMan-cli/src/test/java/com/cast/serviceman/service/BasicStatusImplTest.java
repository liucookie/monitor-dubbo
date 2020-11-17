package com.cast.serviceman.service;

import com.cast.serviceman.api.service.BasicStatusService;
import com.cast.serviceman.api.service.SoftStatusService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * <p>Title: </p>
 * <p>Description:</p>
 *
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history: Created by wanglei on  2020/9/8
 */

public class BasicStatusImplTest {

    private static BasicStatusService service;

    /**
     * 静态准备工作
     */
    @BeforeAll
    static void prepareSystem() {
//        ClientDubboUtil clientDubboUtil = ClientDubboUtil.getInstance();
//        ClientDubboUtil <ComputerServerService> dubboApiUtil = new ClientDubboUtil<ComputerServerService>();
        ClientDubboUtil<BasicStatusService> clientDubboUtil = ClientDubboUtil.getInstance();
        service = clientDubboUtil.getReferenceConfig("serviceman1.0", "1.0", BasicStatusService.class);
    }



    @Test
    void start() throws Exception {
        service.queryAll("192.168.3.200",null);
    }


}
