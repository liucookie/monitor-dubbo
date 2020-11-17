package com.cast.serviceman.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 记录服务的信息
 */
public class SassDto  implements Serializable {

    private static final long serialVersionUID = 829160443309285902L;

    private String saasId;

    private String saasName;

    private String saasKey;

    private Integer saasPid;

    private String serviceCourseName;

    private String dictionariesId;

    private String virtualMachineId;

    private String saasRunningStatus;

    private String saasType;

    private String createUser;

    private Date createTime;

    private String lastModifyUser;

    private Date lastModifyTime;

    private String satId;


    public String getSatId() {
        return satId;
    }

    public void setSatId(String satId) {
        this.satId = satId;
    }

    public String getSaasId() {
        return saasId;
    }

    public void setSaasId(String saasId) {
        this.saasId = saasId == null ? null : saasId.trim();
    }

    public String getSaasName() {
        return saasName;
    }

    public void setSaasName(String saasName) {
        this.saasName = saasName == null ? null : saasName.trim();
    }

    public String getSaasKey() {
        return saasKey;
    }

    public void setSaasKey(String saasKey) {
        this.saasKey = saasKey == null ? null : saasKey.trim();
    }

    public Integer getSaasPid() {
        return saasPid;
    }

    public void setSaasPid(Integer saasPid) {
        this.saasPid = saasPid;
    }

    public String getServiceCourseName() {
        return serviceCourseName;
    }

    public void setServiceCourseName(String serviceCourseName) {
        this.serviceCourseName = serviceCourseName == null ? null : serviceCourseName.trim();
    }

    public String getDictionariesId() {
        return dictionariesId;
    }

    public void setDictionariesId(String dictionariesId) {
        this.dictionariesId = dictionariesId == null ? null : dictionariesId.trim();
    }

    public String getVirtualMachineId() {
        return virtualMachineId;
    }

    public void setVirtualMachineId(String virtualMachineId) {
        this.virtualMachineId = virtualMachineId == null ? null : virtualMachineId.trim();
    }

    public String getSaasRunningStatus() {
        return saasRunningStatus;
    }

    public void setSaasRunningStatus(String saasRunningStatus) {
        this.saasRunningStatus = saasRunningStatus == null ? null : saasRunningStatus.trim();
    }

    public String getSaasType() {
        return saasType;
    }

    public void setSaasType(String saasType) {
        this.saasType = saasType == null ? null : saasType.trim();
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

    @Override
    public String toString() {
        return "SassDto{" +
                "saasId='" + saasId + '\'' +
                ", saasName='" + saasName + '\'' +
                ", saasKey='" + saasKey + '\'' +
                ", saasPid=" + saasPid +
                ", serviceCourseName='" + serviceCourseName + '\'' +
                ", dictionariesId='" + dictionariesId + '\'' +
                ", virtualMachineId='" + virtualMachineId + '\'' +
                ", saasRunningStatus='" + saasRunningStatus + '\'' +
                ", saasType='" + saasType + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", lastModifyUser='" + lastModifyUser + '\'' +
                ", lastModifyTime=" + lastModifyTime +
                ", satId='" + satId + '\'' +
                '}';
    }
}