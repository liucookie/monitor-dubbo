package com.cast.serviceman.api.entity;

import java.io.Serializable;

/**
 * 卫星表
 */
public class SatInfo implements Serializable {


    private static final long serialVersionUID = 8472666208533867312L;

    private Integer satKey;

    private String satId;

    private String satName;

    private String satNo;

    private Integer satIntflag;

    private Integer radius;

    private Long minTime;

    private Byte hasDelay;

    private Byte cmdMode;

    private Float rngDelay;

    private Byte isSat;

    private String xwrapper;

    private String rangeZero;

    public Integer getSatKey() {
        return satKey;
    }

    public void setSatKey(Integer satKey) {
        this.satKey = satKey;
    }

    public String getSatId() {
        return satId;
    }

    public void setSatId(String satId) {
        this.satId = satId == null ? null : satId.trim();
    }

    public String getSatName() {
        return satName;
    }

    public void setSatName(String satName) {
        this.satName = satName == null ? null : satName.trim();
    }

    public String getSatNo() {
        return satNo;
    }

    public void setSatNo(String satNo) {
        this.satNo = satNo == null ? null : satNo.trim();
    }

    public Integer getSatIntflag() {
        return satIntflag;
    }

    public void setSatIntflag(Integer satIntflag) {
        this.satIntflag = satIntflag;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public Long getMinTime() {
        return minTime;
    }

    public void setMinTime(Long minTime) {
        this.minTime = minTime;
    }

    public Byte getHasDelay() {
        return hasDelay;
    }

    public void setHasDelay(Byte hasDelay) {
        this.hasDelay = hasDelay;
    }

    public Byte getCmdMode() {
        return cmdMode;
    }

    public void setCmdMode(Byte cmdMode) {
        this.cmdMode = cmdMode;
    }

    public Float getRngDelay() {
        return rngDelay;
    }

    public void setRngDelay(Float rngDelay) {
        this.rngDelay = rngDelay;
    }

    public Byte getIsSat() {
        return isSat;
    }

    public void setIsSat(Byte isSat) {
        this.isSat = isSat;
    }

    public String getXwrapper() {
        return xwrapper;
    }

    public void setXwrapper(String xwrapper) {
        this.xwrapper = xwrapper == null ? null : xwrapper.trim();
    }

    public String getRangeZero() {
        return rangeZero;
    }

    public void setRangeZero(String rangeZero) {
        this.rangeZero = rangeZero == null ? null : rangeZero.trim();
    }
}