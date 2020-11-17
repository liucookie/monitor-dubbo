package com.cast.serviceman.api.entity.vo;

import com.cast.serviceman.api.entity.ServiceDto;

public class ServiceDtoVo  extends ServiceDto  {


    private static final long serialVersionUID = 4981448687566403011L;
    /**
     * 分组的名称
     */
    private String groupName;

    public ServiceDtoVo() {

    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "ServiceDtoVo{" +
                "groupName='" + groupName + '\'' +
                '}'+ super.toString();
    }

}
