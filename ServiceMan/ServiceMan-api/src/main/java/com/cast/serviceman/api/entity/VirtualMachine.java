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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getVirtualId() {
        return virtualId;
    }

    public void setVirtualId(String virtualId) {
        this.virtualId = virtualId;
    }

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