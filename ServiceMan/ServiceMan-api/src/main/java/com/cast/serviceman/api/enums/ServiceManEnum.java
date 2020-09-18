package com.cast.serviceman.api.enums;

/**
 * 枚举类
 */
public enum ServiceManEnum {
    /**
     * 基础服务类型
     */
    BASE_SERVICE_TYPE("基础服务类型", "base_service_type");




    private String name;
    private String code;

    ServiceManEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }


}


