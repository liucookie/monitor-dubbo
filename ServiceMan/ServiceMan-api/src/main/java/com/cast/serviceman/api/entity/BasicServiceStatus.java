package com.cast.serviceman.api.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 基础服务运行状态
 */

public class BasicServiceStatus implements Serializable {

    private static final long serialVersionUID = -5176026219425027782L;
    private String basicId;

    private String softName;

    private String model;

    private String status;

    private String createUser;

    private Date createTime;

    private String lastModifyUser;

    private Date lastModifyTime;

    private String ip;

    private String virtualName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getVirtualName() {
        return virtualName;
    }

    public void setVirtualName(String virtualName) {
        this.virtualName = virtualName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getBasicId() {
        return basicId;
    }

    public void setBasicId(String basicId) {
        this.basicId = basicId == null ? null : basicId.trim();
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