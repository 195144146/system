package com.yz.crm.common.entity.user;

import com.yz.crm.common.entity.BaseEntity;

import java.util.Date;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-04-11 16:45
 * @description: 角色类 role
 **/
public class Role extends BaseEntity {
    private static final long serialVersionUID = -736376964070927120L;
    private Long id;
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
