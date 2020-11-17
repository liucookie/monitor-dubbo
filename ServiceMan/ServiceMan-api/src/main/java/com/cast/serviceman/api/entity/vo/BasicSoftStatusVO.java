package com.cast.serviceman.api.entity.vo;

import com.cast.serviceman.api.entity.BasicServiceStatus;
import com.cast.serviceman.api.entity.SoftServiceStatus;

import java.io.Serializable;
import java.util.List;

public class BasicSoftStatusVO implements Serializable {

    private static final long serialVersionUID = -8169921009900452450L;
    private int totalCount;
    private int stopCount;
    private int runningCount;

    private List<BasicServiceStatus> basicServiceStatusList;

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

    public List<BasicServiceStatus> getBasicServiceStatusList() {
        return basicServiceStatusList;
    }

    public void setBasicServiceStatusList(List<BasicServiceStatus> basicServiceStatusList) {
        this.basicServiceStatusList = basicServiceStatusList;
    }
}
