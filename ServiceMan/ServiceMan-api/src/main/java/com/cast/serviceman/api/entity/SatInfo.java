package com.cast.serviceman.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 卫星表
 */
public class SatInfo implements Serializable {


    private static final long serialVersionUID = 8472666208533867312L;


    private String satId;

    private String satName;

    private String satEN_Name;

    private Date satDate;

    public String getSatId() {
        return satId;
    }

    public void setSatId(String satId) {
        this.satId = satId;
    }

    public String getSatName() {
        return satName;
    }

    public void setSatName(String satName) {
        this.satName = satName;
    }

    public String getSatEN_Name() {
        return satEN_Name;
    }

    public void setSatEN_Name(String satEN_Name) {
        this.satEN_Name = satEN_Name;
    }

    public Date getSatDate() {
        return satDate;
    }

    public void setSatDate(Date satDate) {
        this.satDate = satDate;
    }
}