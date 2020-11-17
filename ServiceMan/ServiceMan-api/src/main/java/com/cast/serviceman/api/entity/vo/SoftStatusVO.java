package com.cast.serviceman.api.entity.vo;

import com.cast.serviceman.api.entity.SoftServiceStatus;

import java.io.Serializable;
import java.util.List;

public class SoftStatusVO implements Serializable {
    private static final long serialVersionUID = -8652468122445472526L;

    //全部软件服务
    private int totalCount;
    //停止的软件服务
    private int stopCount;
    //运行中的软件服务
    private int runningCount;

    //软件服务运行
    private List<SoftServiceStatus> softServiceStatuses;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getStopCount() {
        return stopCount;
    }

    public void setStopCount(int stopCount) {
        this.stopCount = stopCount;
    }

    public int getRunningCount() {
        return runningCount;
    }

    public void setRunningCount(int runningCount) {
        this.runningCount = runningCount;
    }

    public List<SoftServiceStatus> getSoftServiceStatuses() {
        return softServiceStatuses;
    }

    public void setSoftServiceStatuses(List<SoftServiceStatus> softServiceStatuses) {
        this.softServiceStatuses = softServiceStatuses;
    }
}
