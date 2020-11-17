package com.cast.serviceman.configuration;

import org.apache.dubbo.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * <p>Title: duboo的代码配置类 </p>
 * <p>Description:</p>
 *
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history: Created by wanglei on  2020/9/8
 */
@Configuration
public class DubboConfiguration {
    //<dubbo:application name="boot-user-service-provider"></dubbo:application>

    private String address_1 = "192.168.71.7:2181,192.168.71.7:2182,192.168.71.7:2183";

    //private String address_1 = "192.168.0.118:2181";
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("serviceman-provider");
        return applicationConfig;
    }

    //<dubbo:registry protocol="zookeeper" address="127.0.0.1:2181"></dubbo:registry>
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setCheck(false);
        registryConfig.setAddress(address_1);
        registryConfig.setTimeout(30000);
        return registryConfig;
    }


    /**
     * 通信协议配置项
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        // 打包时要把这个，不在一个网段无法会虚拟一个ip导致无法访问,ip为host文件部署服务器的IP
       // protocolConfig.setHost("192.168.71.140");
        // 本地调试模式，不会注册到zookeeper上，但是主要在custom端配置本地调式模式
        // referenceConfig.setUrl("localhost:20881");
//        protocolConfig.setRegister(false);
        protocolConfig.setPort(-1);
        protocolConfig.setName("dubbo");
        protocolConfig.setSerialization("kryo");
        ApplicationConfig app = new ApplicationConfig("serviceman-provider");
        app.setQosEnable(false);

        return protocolConfig;
        
    }

    /**
     * 监控中心
     * @return
     */
    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig monitorConfig = new MonitorConfig();
        return monitorConfig;
    }

    /**
     * 客户端检测
     * !--消费者-->
     *  关闭服务消费方所有服务的启动检查。dubbo缺省会在启动时检查依赖的服务是否可用，不可用时会抛出异常，阻止Spring初始化完成。url="dubbo//172.16.1.112:20880"
     * @return
     */

    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setCheck(false);
        return consumerConfig;
    }


}
