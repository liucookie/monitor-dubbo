//package com.cast.serviceman.configuration;
//
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.zookeeper.CreateMode;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MasterRegister implements CommandLineRunner {
//
//    private static final String ROOT_PATH = "/test";
//
//    private static final Long WAIT_SECONDS = 3L;
//
//    public volatile boolean master = false;
//
//    public String masterPort;
//
//    @Autowired
//    private CuratorFramework zkClient;
//
//    @Value("${server.port}")
//    private  String port;
//
//    @Override
//    public void run(String... args) throws Exception {
//        //Spring 容器启动后创建临时节点
//        regist();
//    }
//
//    private void regist() {
//        try {
//            zkClient.create()
//                    .creatingParentsIfNeeded()
//                    .withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
//                    .forPath(ROOT_PATH + "/master", port.getBytes());
//        } catch (Exception ignored) {
//        }
//    }
//}
