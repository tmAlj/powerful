package com.wsd.powerful.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class UmsAdminOrgn implements Serializable {
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long adminId;

    @ApiModelProperty(value = "组织id")
    private Long orgnId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getOrgnId() {
        return orgnId;
    }

    public void setOrgnId(Long orgnId) {
        this.orgnId = orgnId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", adminId=").append(adminId);
        sb.append(", orgnId=").append(orgnId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}