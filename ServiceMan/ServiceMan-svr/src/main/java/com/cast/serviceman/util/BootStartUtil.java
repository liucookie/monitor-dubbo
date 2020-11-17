package com.cast.serviceman.util;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.reloading.PeriodicReloadingTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @Description 通过ini文件找到配置属性
 */
public class BootStartUtil {

//    //文件路径
//    private String path = "F:/bootstart_cipher.ini";

    /**
     * zookeeper的url
     */
    private String zookeeperUrl = null;
    /**
     * 卫星的code值
     */
    private String satelliteCode = null;
    /**
     * 数据库连接url
     */
    private String databaseUrl = null;
    /**
     * 数据库连接用户名user
     */
    private String databaseUser = null;
    /**
     * 数据库连接密码
     */
    private String databasePassword = null;

    //日志
    private static final Logger log = LoggerFactory.getLogger(BootStartUtil.class);

    //实例对象
    private volatile static BootStartUtil instance = null;

    public BootStartUtil() {
    }

    /**
     * 根据文件初始化bootstart.ini文件
     */
    private void initApplicationContext(String path) {
        try {
            PropertiesConfiguration config = getFile(path);

            //zookeeper_url
            zookeeperUrl = config.getString("zookeeper_url");

            //卫星的code
            satelliteCode = config.getString("satellite_code");

            //数据库的url
            databaseUrl = config.getString("database_url");

            //数据库的用户名
            databaseUser = config.getString("database_user");

            //数据库的密码
            databasePassword = config.getString("database_password");

        } catch (Exception cex) {
            log.error("启动错误，找不到配置文件！");
        }
    }


    public String getZookeeperUrl() {
        return zookeeperUrl;
    }

    public String getSatelliteCode() {
        return satelliteCode;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    /**
     * 获取实例对象
     *
     * @return
     */
    public static BootStartUtil getInstance(String path) {
        if (null == instance) {
            synchronized (BootStartUtil.class) { // 对其进行锁,防止两个线程同时进入同步代码区
                // 双重检查,非常重要,如果两个同时访问的线程,当第一线程访问完同步代码区后,生成一个实例;当第二个已进入getInstance方法等待的线程进入同步代码区时,也会产生一个新的实例
                if (instance == null) {
                    instance = new BootStartUtil();
                    instance.initApplicationContext(path);
                }
            }
        }
        return instance;
    }

    /**
     * @throws Exception <codeInfo> : 文件扫描策略
     */
    public PropertiesConfiguration getFile(String path) throws Exception {
        //初始化Parameters
        Parameters params = new Parameters();
        //读取文件路径
        File propertiesFile = new File(path);
        //加载配置文件
        ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration> builder = new ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration>(
                PropertiesConfiguration.class).configure(params.fileBased().setFile(propertiesFile));
        //拿到config的各种配置
        PropertiesConfiguration config = builder.getConfiguration();
        //配置检查触发器
        PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(builder.getReloadingController(), null, 1,
                TimeUnit.SECONDS);
        //启动
        trigger.start();

        return config;
    }


}
