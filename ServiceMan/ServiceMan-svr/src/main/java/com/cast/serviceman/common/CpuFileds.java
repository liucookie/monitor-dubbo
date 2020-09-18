package com.cast.serviceman.common;

public class CpuFileds {
    // cpu空闲
    private static final String CPU_INFO="top -b -n 1 | grep Cpu | awk '{print $8}";
    //获取剩余内存
    private static final String REMAIN_MEMORY_INFO="top -b -n 1 | grep Cpu | awk '{print $8}";
    //总内存
    private static final String TOTAL_MEMORY_INFO="free -m | grep \"Mem\" | awk '{print $2}'";
    //磁盘
    private static final String DISK="df -h";
}
