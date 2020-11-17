package com.cast.serviceman.api.entity;

/**
 * 软件服务包实体类
 */
public class ServicePackage {
    private String servicePackageId;

    private String servicePackageName;

    private String servicePackageFile;

    private String servicePackageType;

    public String getServicePackageId() {
        return servicePackageId;
    }

    public void setServicePackageId(String servicePackageId) {
        this.servicePackageId = servicePackageId == null ? null : servicePackageId.trim();
    }

    public String getServicePackageName() {
        return servicePackageName;
    }

    public void setServicePackageName(String servicePackageName) {
        this.servicePackageName = servicePackageName == null ? null : servicePackageName.trim();
    }

    public String getServicePackageFile() {
        return servicePackageFile;
    }

    public void setServicePackageFile(String servicePackageFile) {
        this.servicePackageFile = servicePackageFile == null ? null : servicePackageFile.trim();
    }

    public String getServicePackageType() {
        return servicePackageType;
    }


    public void setServicePackageType(String servicePackageType) {
        this.servicePackageType = servicePackageType == null ? null : servicePackageType.trim();
    }
}