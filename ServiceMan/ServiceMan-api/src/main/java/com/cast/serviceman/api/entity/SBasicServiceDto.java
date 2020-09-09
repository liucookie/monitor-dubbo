package com.cast.serviceman.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础服务器
 */
public class SBasicServiceDto implements Serializable {


    private static final long serialVersionUID = 3890784629354748538L;
    private String basicServiceId;

    private String dictionariesTableId;

    private String basicServiceName;

    private String virtualMachineId;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBasicServiceId() {
        return basicServiceId;
    }

    public void setBasicServiceId(String basicServiceId) {
        this.basicServiceId = basicServiceId == null ? null : basicServiceId.trim();
    }

    public String getDictionariesTableId() {
        return dictionariesTableId;
    }

    public void setDictionariesTableId(String dictionariesTableId) {
        this.dictionariesTableId = dictionariesTableId == null ? null : dictionariesTableId.trim();
    }

    public String getBasicServiceName() {
        return basicServiceName;
    }

    public void setBasicServiceName(String basicServiceName) {
        this.basicServiceName = basicServiceName == null ? null : basicServiceName.trim();
    }

    public String getVirtualMachineId() {
        return virtualMachineId;
    }

    public void setVirtualMachineId(String virtualMachineId) {
        this.virtualMachineId = virtualMachineId == null ? null : virtualMachineId.trim();
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
}