package com.cast.serviceman.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础服务器
 */
public class SBasicServiceDto implements Serializable {


    private static final long serialVersionUID = 3890784629354748538L;
    private String basicServiceId;

    private String dictionaryCode;

    private String basicServiceName;

    private String serviceId;

    private String basicServiceAccount;

    private String basicServicePassword;

    private String basicServicePid;

    private String basicServiceIp;

    private String basicServiceStatus;

    private String createUser;

    private Date createTime;

    private String lastModifyUser;

    private Date lastModifyTime;

    private String cpuCond;

    private String cpuKey;

    private String memoryCond;

    private String memoryKey;

    private String diskCond;

    private String diskKey;

    private String runningCond;

    private String runningKey;

    private String logCond;

    private String logKey;

    private String groupId;

    public String getCpuCond() {
        return cpuCond;
    }

    public void setCpuCond(String cpuCond) {
        this.cpuCond = cpuCond;
    }

    public String getCpuKey() {
        return cpuKey;
    }

    public void setCpuKey(String cpuKey) {
        this.cpuKey = cpuKey;
    }

    public String getMemoryCond() {
        return memoryCond;
    }

    public void setMemoryCond(String memoryCond) {
        this.memoryCond = memoryCond;
    }

    public String getMemoryKey() {
        return memoryKey;
    }

    public void setMemoryKey(String memoryKey) {
        this.memoryKey = memoryKey;
    }

    public String getDiskCond() {
        return diskCond;
    }

    public void setDiskCond(String diskCond) {
        this.diskCond = diskCond;
    }

    public String getDiskKey() {
        return diskKey;
    }

    public void setDiskKey(String diskKey) {
        this.diskKey = diskKey;
    }

    public String getRunningCond() {
        return runningCond;
    }

    public void setRunningCond(String runningCond) {
        this.runningCond = runningCond;
    }

    public String getRunningKey() {
        return runningKey;
    }

    public void setRunningKey(String runningKey) {
        this.runningKey = runningKey;
    }

    public String getLogCond() {
        return logCond;
    }

    public void setLogCond(String logCond) {
        this.logCond = logCond;
    }

    public String getLogKey() {
        return logKey;
    }

    public void setLogKey(String logKey) {
        this.logKey = logKey;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBasicServiceId() {
        return basicServiceId;
    }

    public void setBasicServiceId(String basicServiceId) {
        this.basicServiceId = basicServiceId == null ? null : basicServiceId.trim();
    }


    public String getBasicServiceName() {
        return basicServiceName;
    }

    public void setBasicServiceName(String basicServiceName) {
        this.basicServiceName = basicServiceName == null ? null : basicServiceName.trim();
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getBasicServiceAccount() {
        return basicServiceAccount;
    }

    public void setBasicServiceAccount(String basicServiceAccount) {
        this.basicServiceAccount = basicServiceAccount == null ? null : basicServiceAccount.trim();
    }

    public String getBasicServicePassword() {
        return basicServicePassword;
    }

    public void setBasicServicePassword(String basicServicePassword) {
        this.basicServicePassword = basicServicePassword == null ? null : basicServicePassword.trim();
    }

    public String getBasicServicePid() {
        return basicServicePid;
    }

    public void setBasicServicePid(String basicServicePid) {
        this.basicServicePid = basicServicePid == null ? null : basicServicePid.trim();
    }

    public String getBasicServiceIp() {
        return basicServiceIp;
    }

    public void setBasicServiceIp(String basicServiceIp) {
        this.basicServiceIp = basicServiceIp == null ? null : basicServiceIp.trim();
    }

    public String getBasicServiceStatus() {
        return basicServiceStatus;
    }

    public void setBasicServiceStatus(String basicServiceStatus) {
        this.basicServiceStatus = basicServiceStatus == null ? null : basicServiceStatus.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastModifyUser() {
        return lastModifyUser;
    }

    public void setLastModifyUser(String lastModifyUser) {
        this.lastModifyUser = lastModifyUser == null ? null : lastModifyUser.trim();
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getDictionaryCode() {
        return dictionaryCode;
    }

    public void setDictionaryCode(String dictionaryCode) {
        this.dictionaryCode = dictionaryCode;
    }


    @Override
    public String toString() {
        return "SBasicServiceDto{" +
                "basicServiceId='" + basicServiceId + '\'' +
                ", dictionaryCode='" + dictionaryCode + '\'' +
                ", basicServiceName='" + basicServiceName + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", basicServiceAccount='" + basicServiceAccount + '\'' +
                ", basicServicePassword='" + basicServicePassword + '\'' +
                ", basicServicePid='" + basicServicePid + '\'' +
                ", basicServiceIp='" + basicServiceIp + '\'' +
                ", basicServiceStatus='" + basicServiceStatus + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", lastModifyUser='" + lastModifyUser + '\'' +
                ", lastModifyTime=" + lastModifyTime +
                ", cpuCond='" + cpuCond + '\'' +
                ", cpuKey='" + cpuKey + '\'' +
                ", memoryCond='" + memoryCond + '\'' +
                ", memoryKey='" + memoryKey + '\'' +
                ", diskCond='" + diskCond + '\'' +
                ", diskKey='" + diskKey + '\'' +
                ", runningCond='" + runningCond + '\'' +
                ", runningKey='" + runningKey + '\'' +
                ", logCond='" + logCond + '\'' +
                ", logKey='" + logKey + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}