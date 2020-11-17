package com.cast.serviceman.api.entity.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 虚拟机信息,响应体
 */
public class CpuInfoVO implements Serializable {

    private static final long serialVersionUID = 4556802884517472924L;

    private List<VirtualInfo> virtualInfos;

    //告警信息
    private List<Map<String, String>> mapList;
    //告警时间


    //虚拟机总数
    private int totalCount;
    //运行中总数
    private int runningCount;
    //已关机总数
    private int stopCount;
    //告警总数
    private int warnCount;

    public static class VirtualInfo implements Serializable {
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

        private String ip;

        //cpu的警戒值
        private boolean cpuSecurityLine;
        //内存的警戒值
        private  boolean memorySecurityLine;
        //磁盘
        private boolean diskSecurityLine;



        public VirtualInfo(String virtualName, String status, String cpu, String memory, String disk, String ip) {
            this.virtualName = virtualName;
            this.status = status;
            this.cpu = cpu;
            this.memory = memory;
            this.disk = disk;
            this.ip = ip;
        }

        public boolean isMemorySecurityLine() {
            return memorySecurityLine;
        }

        public void setMemorySecurityLine(boolean memorySecurityLine) {
            this.memorySecurityLine = memorySecurityLine;
        }

        public boolean isDiskSecurityLine() {
            return diskSecurityLine;
        }

        public void setDiskSecurityLine(boolean diskSecurityLine) {
            this.diskSecurityLine = diskSecurityLine;
        }

        public boolean isCpuSecurityLine() {
            return cpuSecurityLine;
        }

        public void setCpuSecurityLine(boolean cpuSecurityLine) {
            this.cpuSecurityLine = cpuSecurityLine;
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
    }



    public List<VirtualInfo> getVirtualInfos() {
        return virtualInfos;
    }

    public void setVirtualInfos(List<VirtualInfo> virtualInfos) {
        this.virtualInfos = virtualInfos;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getRunningCount() {
        return runningCount;
    }

    public void setRunningCount(int runningCount) {
        this.runningCount = runningCount;
    }

    public int getStopCount() {
        return stopCount;
    }

    public void setStopCount(int stopCount) {
        this.stopCount = stopCount;
    }

    public int getWarnCount() {
        return warnCount;
    }

    public void setWarnCount(int warnCount) {
        this.warnCount = warnCount;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Map<String, String>> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map<String, String>> mapList) {
        this.mapList = mapList;
    }

}
