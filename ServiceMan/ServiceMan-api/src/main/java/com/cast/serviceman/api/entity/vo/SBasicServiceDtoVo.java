package com.cast.serviceman.api.entity.vo;

import com.cast.serviceman.api.entity.SBasicServiceDto;

public class SBasicServiceDtoVo extends SBasicServiceDto {


    private static final long serialVersionUID = 8132525818644516796L;

    /**
     * 字典表类型名称
     */
    private String dictionaryName;

    /**
     * 所属分组的名称
     */
    private String groupName;

    /**
     * 承载环境的服务器名称
     */
    private String serviceName;

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getServiceName() {
        return serviceName;
    }


    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }


    @Override
    public String toString() {
        return "SBasicServiceDtoVo{" +
                "dictionaryName='" + dictionaryName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}' + super.toString();
    }


}
