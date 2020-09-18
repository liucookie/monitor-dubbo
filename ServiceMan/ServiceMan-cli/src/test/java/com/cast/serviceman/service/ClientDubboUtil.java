package com.cast.serviceman.service;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>Title: dubbo api调用方式的加载工具</p>
 * <p>Description: 可以在这里统一设置dubbo的配置信息，获取dubbo的接口类对象</p>
 *
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history: Created by wanglei on  2020/9/8
 */
public class ClientDubboUtil<T> {
    /**
     * 系统配置类
     */
    private  static ApplicationConfig application = new ApplicationConfig();
    /**
     * 注册配置缓存
     */
    private static Map<String, RegistryConfig> registryConfigCache = new ConcurrentHashMap<>();
    /**
     * 依赖配置缓存
     */
    private  Map<String, ReferenceConfig<T>> referenceCache = new ConcurrentHashMap<>();
    /**
     * 实例对象
     */
    private static volatile ClientDubboUtil  instance = null;

    private ClientDubboUtil(){

    }
    /**
     * 初始化加载配置信息
     */
    static {
        application.setName("serviceman-customer");
        getRegistryConfig("serviceman1.0","1.0");
    }

    /**
     * 获取dubbo的注册配置信息
     * @param group 分组信息
     * @param version 版本信息
     * @return 注册配置信息
     */
    private static  RegistryConfig getRegistryConfig(String group, String version) {
        /**
         * zookeeper 的地址
         */
        String zookeeperUrl = "192.168.0.118:2181";
        String key = zookeeperUrl + "-" + group + "-" + version;
        RegistryConfig registryConfig = registryConfigCache.get(key);
        if (null == registryConfig) {
            registryConfig = new RegistryConfig();
            registryConfig.setCheck(true);
            registryConfig.setProtocol("zookeeper");
            // registryConfig.setPort(zookeeperPort);
            registryConfig.setAddress(zookeeperUrl);
            registryConfigCache.put(key, registryConfig);
        }
        return registryConfig;
    }

    /**
     * 获取服务的代理对象，调用后台的接口
     * @param group 分组信息
     * @param version 版本信息
     * @param clazz 要获取的类
     * @return
     */
    public  T getReferenceConfig(String group, String version,Class<T> clazz) {
        String referenceKey = clazz.getName();
        ReferenceConfig<T> referenceConfig = referenceCache.get(referenceKey);
        if (null == referenceConfig) {
            referenceConfig = new ReferenceConfig<>();
            referenceConfig.setApplication(application);
            referenceConfig.setRegistry(getRegistryConfig(group, version));
            referenceConfig.setInterface(clazz);
            referenceConfig.setVersion(version);
            referenceConfig.setGroup(group);
            referenceConfig.setTimeout(100000);
            referenceCache.put(referenceKey, referenceConfig);
        }
        return (T)referenceConfig.get();
    }

    /**
     * 获取实例对象
     * @return
     */
    public static ClientDubboUtil getInstance() {
        if (null == instance) {
            synchronized (ClientDubboUtil.class) { // 对其进行锁,防止两个线程同时进入同步代码区
                // 双重检查,非常重要,如果两个同时访问的线程,当第一线程访问完同步代码区后,生成一个实例;当第二个已进入getInstance方法等待的线程进入同步代码区时,也会产生一个新的实例
                if (instance == null) {
                    instance = new ClientDubboUtil();
                }
            }
        }
        return instance;
    }

}
