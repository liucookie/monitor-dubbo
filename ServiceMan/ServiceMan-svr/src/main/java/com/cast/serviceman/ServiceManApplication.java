package com.cast.serviceman;


import com.cast.serviceman.util.ArgsUtil;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
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
        log.info("--------------------------------------------------------------------");
        Map<String,String> map1 = ArgsUtil.getCommand(args);
        log.info(map1.toString());
        log.info("-------------------------------------app start -------------------------------");
        SpringApplication.run(ServiceManApplication.class, args);
        log.info("---------------------服务提供者启动成功---------------app start success! -----------------------");
    }
}
