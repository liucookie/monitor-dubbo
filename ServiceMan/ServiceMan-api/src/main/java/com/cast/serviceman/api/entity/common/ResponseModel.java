package com.cast.serviceman.api.entity.common;

import java.io.Serializable;

/**
 * @author by zhaogeng
 * @Classname ResponseModel
 * @Description 系统返回对象的
 */
public class ResponseModel<T> implements Serializable {

    private static final long serialVersionUID = 6820388536266967850L;
    /**
     * 接口成功标识 true:成功 ；false 失败
     */
    private boolean success;

    /**
     * 失败信息，当接口失败是返回详细信息
     */
    private String errorMsg;

    /**
     * 接口返回值数据
     */
    private T data;

    /**
     * 数据总条数
     */
    private Long totalCount;

    /**
     * 总页数
     */
    private Integer page;

    public void success(T data) {
        this.success = true;
        this.data = data;
    }

    public void success(T data, Long totalCount, Integer page) {
        this.success = true;
        this.data = data;
        this.totalCount = totalCount;
        this.page = page;
    }

    public void success() {
        this.success = true;
    }

    public void failed() {
        this.success = false;
    }

    public void failed(String errorMsg) {
        this.errorMsg = errorMsg;
        this.success = false;
    }

    public void failed(String errorMsg, T data) {
        this.errorMsg = errorMsg;
        this.data = data;
        this.success = false;
    }

    public ResponseModel(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public ResponseModel() {
    }


    public ResponseModel(boolean success) {
        this.success = success;
    }

    public ResponseModel(boolean success, String errorMsg) {
        this.success = success;
        this.errorMsg = errorMsg;
    }

    public ResponseModel(boolean success, String errorMsg, T data) {
        this.success = success;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;

    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "success=" + success +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                ", totalCount=" + totalCount +
                ", page=" + page +
                '}';
    }
}
