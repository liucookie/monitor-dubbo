//package com.cast.serviceman.configuration;
//
//import org.apache.curator.RetryPolicy;
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.retry.ExponentialBackoffRetry;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ZooKeeperConfiguration {
//    private static final String ZOOKEEPER_URL = "192.168.0.118:2181";
//
//    @Bean
//    public CuratorFramework getCuratorFramework(){
//        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
//        CuratorFramework client = CuratorFrameworkFactory.newClient(ZOOKEEPER_URL,retryPolicy);
//        client.start();
//        return client;
//    }
//
//
//}
