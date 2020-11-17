package com.cast.serviceman.api.entity.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 虚拟机信息,响应体,单个
 */
public class CpuSingleInfoVO extends CpuInfoVO implements Serializable {

    private static final long serialVersionUID = 4556802884517472924L;

    //虚拟机名称
    private String virtualName;
    //状态
    private String status;
    //cpu信息
    private String cpu;
    //内存
    private String memory;
    //磁盘
    private String disk;


    //IP地址
    private String ip;

    //使用磁盘
    private String totalDisk;

    //使用内存
    private String totalMemory;

    //版本信息
    private String version;

    //运行时间
    private String runningTime;

    //cpu核心数
    private String cpuCore;



    public String getCpuCore() {
        return cpuCore;
    }

    public void setCpuCore(String cpuCore) {
        this.cpuCore = cpuCore;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(String totalMemory) {
        this.totalMemory = totalMemory;
    }

    public String getVirtualName() {
        return virtualName;
    }

    public void setVirtualName(String virtualName) {
        this.virtualName = virtualName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTotalDisk() {
        return totalDisk;
    }

    public void setTotalDisk(String totalDisk) {
        this.totalDisk = totalDisk;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public CpuSingleInfoVO(String virtualName, String status, String cpu, String memory, String disk, String ip) {
        this.virtualName = virtualName;
        this.status = status;
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
        this.ip = ip;
    }
}
