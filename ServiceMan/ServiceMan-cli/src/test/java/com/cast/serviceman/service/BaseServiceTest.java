package com.cast.serviceman.service;

import com.cast.serviceman.api.entity.ServiceDto;
import com.cast.serviceman.api.service.ComputerServerService;
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

public class BaseServiceTest {

    private static ComputerServerService service;

    /**
     * 静态准备工作
     */
    @BeforeAll
    static void prepareSystem() {
//        ClientDubboUtil clientDubboUtil = ClientDubboUtil.getInstance();
//        ClientDubboUtil <ComputerServerService> dubboApiUtil = new ClientDubboUtil<ComputerServerService>();
        ClientDubboUtil<ComputerServerService> clientDubboUtil = ClientDubboUtil.getInstance();
        service = clientDubboUtil.getReferenceConfig("serviceman1.0", "1.0", ComputerServerService.class);
    }

    @Test
    void queryTaskTemplateTest() throws Exception {
        ServiceDto dto = new ServiceDto();
        dto.setServiceIp("192.168.0.130");
        service.add(dto);
    }
}
