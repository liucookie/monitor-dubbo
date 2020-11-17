package com.cast.serviceman.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wanglei
 * @Classname ApiClientPortal
 * @Description 通过XML访问后台接口，可以用于测试
 * @Date 2020/7/2 13:55
 */
public class XmlClientPortal {
    private static final Logger log = LoggerFactory.getLogger(XmlClientPortal.class);

    public static void main(String[] args) {
        // String url = "http://10.20.160.198/wiki/display/dubbo/client.xml";  // 支持URL部署
        String url = "client.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{url});
        context.start();
    }
}
