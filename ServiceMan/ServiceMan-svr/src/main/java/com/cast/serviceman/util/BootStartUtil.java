package com.cast.serviceman.util;

import java.io.*;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 通过ini文件找到配置属性
 */
public class BootStartUtil {

    //文件路径
    private String path = "F:/bootstart.ini";

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

    //存储取到的kv
    Map<String, String> textMap = new HashMap<>();


    /**
     * 根据文件初始化bootstart.ini文件
     */
    private void initApplicationContext() {

        getFile();

        //zookeeper_url
        zookeeperUrl = textMap.get("zookeeper_url");

        //卫星的code
        satelliteCode = textMap.get("satellite_code");

        //数据库的url
        databaseUrl = textMap.get("database_url");

        //数据库的用户名
        databaseUser = textMap.get("database_user");

        //数据库的密码
        databasePassword = textMap.get("database_password");
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
    public static BootStartUtil getInstance() {
        if (null == instance) {
            synchronized (BootStartUtil.class) { // 对其进行锁,防止两个线程同时进入同步代码区
                // 双重检查,非常重要,如果两个同时访问的线程,当第一线程访问完同步代码区后,生成一个实例;当第二个已进入getInstance方法等待的线程进入同步代码区时,也会产生一个新的实例
                if (instance == null) {
                    instance = new BootStartUtil();
                    instance.initApplicationContext();
                }
            }
        }
        return instance;
    }

    /**
     * 读取配置文件的内容
     */
    private void getFile() {
        try {
            String encoding = "GBK";//编码格式
            File file = new File(path);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);//一行一行读取配置文件内容
                while (bufferedReader.readLine() != null) {
                    String text = null;
                    text = bufferedReader.readLine();
                    //对读取的进行=截取,形成键值对
                    String[] tests = text.split("=");
                    textMap.put(tests[0].trim(), tests[1].trim());
                }
                read.close();
            } else {
                log.error("启动错误，找不到配置文件！");
            }
        } catch (Exception e) {
            log.error("读取文件内容出错,文件内容格式错误！");
            e.printStackTrace();
        }
    }


}
