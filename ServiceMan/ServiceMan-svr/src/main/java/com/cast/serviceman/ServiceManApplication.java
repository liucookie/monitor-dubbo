package com.cast.serviceman;

import com.cast.serviceman.util.ArgsUtil;
import com.cast.serviceman.util.BootStartUtil;
import com.cast.serviceman.util.DESUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Map;

/**
 * @author zhaogeng
 * @Classname ServiceManApplication
 * @Description 系统的主启动类，用来启动系统
 * @Date 2020/8/21 10:00
 */
@SpringBootApplication
@EnableDubbo
@EnableTransactionManagement
//@ImportResource(locations = "classpath:service.xml")
@MapperScan(value = {"com.cast.serviceman.server.mapper"})
public class ServiceManApplication {
    private static final Logger log = LoggerFactory.getLogger(ServiceManApplication.class);

    public static void main(String[] args) throws Exception {
        log.info("---------------------------Starting......-----------------------------------------");
        Map<String, String> map = ArgsUtil.getCommand(args);
        log.info(map.toString());
        String key = map.get("order_password");
        log.info("-----------------------------" + key + "------------------------------------");
        //解密
        if (StringUtils.isNoneEmpty(key)) {
            String value = null;
            try {
                value = DESUtil.getDecryptString(key);
            } catch (Exception e) {
                log.info("没有拿到key密码");
            }
            if (value.equals("test")) {
                log.info("Database_Cipher_PASSWORD:" + BootStartUtil.getInstance("F:/bootstart_cipher.ini").getDatabasePassword());
            } else {
                log.info("密码错误");
            }
        } else {
            log.info("Database_PASSWORD:" + BootStartUtil.getInstance("F:/bootstart.ini").getDatabasePassword());
        }
        log.info("-------------------------------------app start -------------------------------");
        SpringApplication.run(ServiceManApplication.class, args);
        log.info("---------------------服务提供者启动成功---------------app start success! -----------------------");
    }

}
