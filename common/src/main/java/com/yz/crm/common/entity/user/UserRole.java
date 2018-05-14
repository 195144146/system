package com.yz.crm.common.entity.user;

import com.yz.crm.common.entity.BaseEntity;

import java.util.Date;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-04-12 13:44
 * @description: 用户角色表user_role
 **/
public class UserRole extends BaseEntity{

    private static final long serialVersionUID = -8859567148442516253L;

    private Long id;
    private Long userId;
    private Long roleId;
    private Long createdBy;
    private Date createdOn;
    private Long modifiedBy;
    private Date modifiedOn;
    private Boolean isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
