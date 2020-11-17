package com.cast.serviceman.common;

public class CpuFileds {
    // cpu空闲
    private static final String CPU_INFO="top -b -n 1 | grep Cpu | awk '{print $8}'";
    //获取剩余内存
    private static final String REMAIN_MEMORY_INFO="free -m | grep \"Mem\" | awk '{print $4+$6}'";
    //总内存
    private static final String TOTAL_MEMORY_INFO="free -m | grep \"Mem\" | awk '{print $2}'";
    //总磁盘内存 GB
    private static final String TOTAL_IDSK_INFO_GB="df --block-size=1073741824";

    //磁盘
    private static final String DISK="df -h";

    private static final String PS_GREP="ps -ef|grep";

    //虚拟机版本
    private static final String VESION="cat /etc/centos-release";
    //运行时间
    private static final String RUNNING_TIME="cat /proc/uptime| awk -F. '{run_days=$1 / 86400;run_hour=($1 % 86400)/3600;run_minute=($1 % 3600)/60;run_second=$1 % 60;printf(\"%d天%d时%d分%d秒\",run_days,run_hour,run_minute,run_second)}'";
    //关机
    private static final String SHUT_DOWN="halt";
    //重启
    private static final String RE_START="reboot";

    //cpu核数
    private static final String CPU_CORE="cat /proc/cpuinfo| grep \"cpu cores\"| uniq";

    //杀进程
    private static final String KILL="kill   ";

    private static final String START_JAR= "java -jar"; //nohup

    public static String getStartJar(String jarName) {
        return START_JAR + "  "+ "/usr/jar/"+ jarName + "  " + ">/usr/jar/log.out &";
    }

    private  static  final  String  DEPLOY_SOFTWARE = "sh  /opt/vela2/serviceman.sh    ";

    public static String getDeploySoftware(String state,String fileName) {
//        String logDir = fileName.substring(0,fileName.lastIndexOf("/") + 1);

        String logDir = fileName.replace(".jar",".out");
        return DEPLOY_SOFTWARE + state +"   "+fileName + "  " + logDir;
    }

    public static String getCpuCore() {
        return CPU_CORE;
    }

    public static String getStartJar() {
        return START_JAR;
    }

    public static String getKILL() {
        return KILL;
    }

    public static String getShutDown() {
        return SHUT_DOWN;
    }

    public static String getReStart() {
        return RE_START;
    }

    public static String getCpuInfo() {
        return CPU_INFO;
    }

    public static String getRemainMemoryInfo() {
        return REMAIN_MEMORY_INFO;
    }

    public static String getTotalMemoryInfo() {
        return TOTAL_MEMORY_INFO;
    }

    public static String getDISK() {
        return DISK;
    }

    public static String getPsGrep() {
        return PS_GREP;
    }

    public static String getTotalIdskInfoGb() {
        return TOTAL_IDSK_INFO_GB;
    }

    public static String getVESION() {
        return VESION;
    }

    public static String getRunningTime() {
        return RUNNING_TIME;
    }


}
