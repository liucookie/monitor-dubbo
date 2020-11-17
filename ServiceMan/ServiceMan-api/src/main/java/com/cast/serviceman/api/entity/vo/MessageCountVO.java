package com.cast.serviceman.api.entity.vo;

import java.io.Serializable;

public class MessageCountVO implements Serializable {

    private static final long serialVersionUID = -5341787374445166308L;


    //基础服务总数
    private Integer basicServiceCount;
    //虚拟机服务器总数
    private Integer virtualCount;
    //软件服务总数
    private Integer softServiceCount;


    public Integer getBasicServiceCount() {
        return basicServiceCount;
    }

    public void setBasicServiceCount(Integer basicServiceCount) {
        this.basicServiceCount = basicServiceCount;
    }

    public Integer getVirtualCount() {
        return virtualCount;
    }

    public void setVirtualCount(Integer virtualCount) {
        this.virtualCount = virtualCount;
    }

    public Integer getSoftServiceCount() {
        return softServiceCount;
    }

    public void setSoftServiceCount(Integer softServiceCount) {
        this.softServiceCount = softServiceCount;
    }
}
