package com.cast.serviceman.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 软件运行状态
 */
public class SoftServiceStatus implements Serializable {

    private static final long serialVersionUID = 856697018320454776L;
    //id
    private String softId;

    //软件服务名称
    private String softName;
    //运行模式
    private String model;
    //运行状态
    private String status;

    //虚拟机的PID
    private String pId;

    private String createUser;

    private Date createTime;

    private String lastModifyUser;

    private Date lastModifyTime;

    //虚拟机IP
    private String ip;

    //卫星id
    private String satId;

    //软件服务包文件名
    private  String filePackage;



    public String getFilePackage() {
        return filePackage;
    }

    public void setFilePackage(String filePackage) {
        this.filePackage = filePackage;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getSatId() {
        return satId;
    }

    public void setSatId(String satId) {
        this.satId = satId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSoftId() {
        return softId;
    }

    public void setSoftId(String softId) {
        this.softId = softId == null ? null : softId.trim();
    }

    public String getSoftName() {
        return softName;
    }

    public void setSoftName(String softName) {
        this.softName = softName == null ? null : softName.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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