package com.cast.serviceman;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhaogeng
 * @Classname ServiceManApplication
 * @Description 系统的主启动类，用来启动系统
 * @Date 2020/8/21 10:00
 */
@SpringBootApplication
@EnableTransactionManagement
//@ImportResource(locations = "classpath:service.xml")
@MapperScan(value = {"com.cast.serviceman.server.mapper"})
public class ServiceManApplication {
    private static final Logger log = LoggerFactory.getLogger(ServiceManApplication.class);
    public static void main(String[] args) {
        log.info("-------------------------------------app start -------------------------------");
        SpringApplication.run(ServiceManApplication.class, args);
        log.info("---------------------服务提供者启动成功---------------app start success! -----------------------");
    }
}
