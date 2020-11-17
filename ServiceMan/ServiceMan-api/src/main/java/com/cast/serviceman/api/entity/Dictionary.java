package com.cast.serviceman.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典表,用于元数据查询
 *
 * @author zhaogeng
 */
public class Dictionary implements Serializable {

    private static final long serialVersionUID = 3884946938008520196L;

    private String dictionaryCode;

    private String dictionaryName;

    /**
     * 字典类型编码
     */
    private String dictionaryTypeCode;


    private Integer dictionaryOrder;


    private String dictionaryStatus;


    private String createUser;


    private String lastModifyUser;


    private Date createTime;


    private Date lastModifyTime;


    private String dictionaryDesc;


    public String getDictionaryCode() {
        return dictionaryCode;
    }


    public void setDictionaryCode(String dictionaryCode) {
        this.dictionaryCode = dictionaryCode == null ? null : dictionaryCode.trim();
    }

    public String getDictionaryName() {
        return dictionaryName;
    }


    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName == null ? null : dictionaryName.trim();
    }


    public String getDictionaryTypeCode() {
        return dictionaryTypeCode;
    }


    public void setDictionaryTypeCode(String dictionaryTypeCode) {
        this.dictionaryTypeCode = dictionaryTypeCode == null ? null : dictionaryTypeCode.trim();
    }


    public Integer getDictionaryOrder() {
        return dictionaryOrder;
    }


    public void setDictionaryOrder(Integer dictionaryOrder) {
        this.dictionaryOrder = dictionaryOrder;
    }


    public String getDictionaryStatus() {
        return dictionaryStatus;
    }


    public void setDictionaryStatus(String dictionaryStatus) {
        this.dictionaryStatus = dictionaryStatus == null ? null : dictionaryStatus.trim();
    }


    public String getCreateUser() {
        return createUser;
    }


    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }


    public String getLastModifyUser() {
        return lastModifyUser;
    }


    public void setLastModifyUser(String lastModifyUser) {
        this.lastModifyUser = lastModifyUser == null ? null : lastModifyUser.trim();
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getLastModifyTime() {
        return lastModifyTime;
    }


    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }


    public String getDictionaryDesc() {
        return dictionaryDesc;
    }


    public void setDictionaryDesc(String dictionaryDesc) {
        this.dictionaryDesc = dictionaryDesc == null ? null : dictionaryDesc.trim();
    }
}