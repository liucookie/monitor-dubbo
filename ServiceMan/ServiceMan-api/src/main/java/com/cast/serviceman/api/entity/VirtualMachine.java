package com.cast.serviceman.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 虚拟机
 */
public class VirtualMachine implements Serializable {


    private static final long serialVersionUID = 1270591397983921164L;
    private String virtualMachineId;

    private String virtualmachineName;

    private String groupId;

    private String dictionariesId;

    private String virtualMachineIp;

    private String virtualMachineAccount;

    private String virtualMachinePassword;

    private String virtualMachineOperatingState;

    private String serviceLivingName;

    private String virtualmachineDeployState;

    private Date virtualMachineRunningTime;

    private String virtualMachineMemory;

    private String virtualMachineStorage;

    private String createUser;

    private Date createTime;

    private String lastModifyUser;

    private Date lastModifyTime;

    public String getVirtualMachineId() {
        return virtualMachineId;
    }

    public void setVirtualMachineId(String virtualMachineId) {
        this.virtualMachineId = virtualMachineId == null ? null : virtualMachineId.trim();
    }

    public String getVirtualmachineName() {
        return virtualmachineName;
    }

    public void setVirtualmachineName(String virtualmachineName) {
        this.virtualmachineName = virtualmachineName == null ? null : virtualmachineName.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getDictionariesId() {
        return dictionariesId;
    }

    public void setDictionariesId(String dictionariesId) {
        this.dictionariesId = dictionariesId == null ? null : dictionariesId.trim();
    }

    public String getVirtualMachineIp() {
        return virtualMachineIp;
    }

    public void setVirtualMachineIp(String virtualMachineIp) {
        this.virtualMachineIp = virtualMachineIp == null ? null : virtualMachineIp.trim();
    }

    public String getVirtualMachineAccount() {
        return virtualMachineAccount;
    }

    public void setVirtualMachineAccount(String virtualMachineAccount) {
        this.virtualMachineAccount = virtualMachineAccount == null ? null : virtualMachineAccount.trim();
    }

    public String getVirtualMachinePassword() {
        return virtualMachinePassword;
    }

    public void setVirtualMachinePassword(String virtualMachinePassword) {
        this.virtualMachinePassword = virtualMachinePassword == null ? null : virtualMachinePassword.trim();
    }

    public String getVirtualMachineOperatingState() {
        return virtualMachineOperatingState;
    }

    public void setVirtualMachineOperatingState(String virtualMachineOperatingState) {
        this.virtualMachineOperatingState = virtualMachineOperatingState == null ? null : virtualMachineOperatingState.trim();
    }

    public String getServiceLivingName() {
        return serviceLivingName;
    }

    public void setServiceLivingName(String serviceLivingName) {
        this.serviceLivingName = serviceLivingName == null ? null : serviceLivingName.trim();
    }

    public String getVirtualmachineDeployState() {
        return virtualmachineDeployState;
    }

    public void setVirtualmachineDeployState(String virtualmachineDeployState) {
        this.virtualmachineDeployState = virtualmachineDeployState == null ? null : virtualmachineDeployState.trim();
    }

    public Date getVirtualMachineRunningTime() {
        return virtualMachineRunningTime;
    }

    public void setVirtualMachineRunningTime(Date virtualMachineRunningTime) {
        this.virtualMachineRunningTime = virtualMachineRunningTime;
    }

    public String getVirtualMachineMemory() {
        return virtualMachineMemory;
    }

    public void setVirtualMachineMemory(String virtualMachineMemory) {
        this.virtualMachineMemory = virtualMachineMemory == null ? null : virtualMachineMemory.trim();
    }

    public String getVirtualMachineStorage() {
        return virtualMachineStorage;
    }

    public void setVirtualMachineStorage(String virtualMachineStorage) {
        this.virtualMachineStorage = virtualMachineStorage == null ? null : virtualMachineStorage.trim();
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