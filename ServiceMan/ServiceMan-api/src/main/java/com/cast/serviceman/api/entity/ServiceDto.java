package com.cast.serviceman.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务器
 */
public class ServiceDto implements Serializable {

    private static final long serialVersionUID = -9166639544832771182L;
    private String serviceId;

    private String dictionariesTableId;

    private String groupId;

    private String serviceName;

    private String serviceIp;

    private String serviceAccount;

    private String servicePassword;

    private String createUser;

    private Date createTime;

    private String lastModifyUser;

    private Date lastModifyTime;

    private String virtualId;

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

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getDictionariesTableId() {
        return dictionariesTableId;
    }

    public void setDictionariesTableId(String dictionariesTableId) {
        this.dictionariesTableId = dictionariesTableId == null ? null : dictionariesTableId.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getServiceIp() {
        return serviceIp;
    }

    public void setServiceIp(String serviceIp) {
        this.serviceIp = serviceIp == null ? null : serviceIp.trim();
    }

    public String getServiceAccount() {
        return serviceAccount;
    }

    public void setServiceAccount(String serviceAccount) {
        this.serviceAccount = serviceAccount == null ? null : serviceAccount.trim();
    }

    public String getServicePassword() {
        return servicePassword;
    }

    public void setServicePassword(String servicePassword) {
        this.servicePassword = servicePassword == null ? null : servicePassword.trim();
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

    public String getVirtualId() {
        return virtualId;
    }

    public void setVirtualId(String virtualId) {
        this.virtualId = virtualId == null ? null : virtualId.trim();
    }

    public String getCpuCond() {
        return cpuCond;
    }

    public void setCpuCond(String cpuCond) {
        this.cpuCond = cpuCond == null ? null : cpuCond.trim();
    }

    public String getCpuKey() {
        return cpuKey;
    }

    public void setCpuKey(String cpuKey) {
        this.cpuKey = cpuKey == null ? null : cpuKey.trim();
    }

    public String getMemoryCond() {
        return memoryCond;
    }

    public void setMemoryCond(String memoryCond) {
        this.memoryCond = memoryCond == null ? null : memoryCond.trim();
    }

    public String getMemoryKey() {
        return memoryKey;
    }

    public void setMemoryKey(String memoryKey) {
        this.memoryKey = memoryKey == null ? null : memoryKey.trim();
    }

    public String getDiskCond() {
        return diskCond;
    }

    public void setDiskCond(String diskCond) {
        this.diskCond = diskCond == null ? null : diskCond.trim();
    }

    public String getDiskKey() {
        return diskKey;
    }

    public void setDiskKey(String diskKey) {
        this.diskKey = diskKey == null ? null : diskKey.trim();
    }

    public String getRunningCond() {
        return runningCond;
    }

    public void setRunningCond(String runningCond) {
        this.runningCond = runningCond == null ? null : runningCond.trim();
    }

    public String getRunningKey() {
        return runningKey;
    }

    public void setRunningKey(String runningKey) {
        this.runningKey = runningKey == null ? null : runningKey.trim();
    }

    public String getLogCond() {
        return logCond;
    }

    public void setLogCond(String logCond) {
        this.logCond = logCond == null ? null : logCond.trim();
    }

    public String getLogKey() {
        return logKey;
    }

    public void setLogKey(String logKey) {
        this.logKey = logKey == null ? null : logKey.trim();
    }
}