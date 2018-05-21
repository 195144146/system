package com.yz.crm.common.entity.user;

import com.yz.crm.common.entity.BaseEntity;
import java.util.Date;
import java.util.List;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-04-12 14:00
 * @description: 资源表resources
 **/
public class Resources extends BaseEntity {
    private static final long serialVersionUID = 5472533237383238624L;

    private Long id;
    private String name;
    private String path;
    private Integer type;
    private Long parentId;
    private Long createdBy;
    private Date createdOn;
    private Long modifiedBy;
    private Long modifiedOn;
    private Boolean isDeleted;
    private Integer sequence;
    private List<Resources> children;

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public List<Resources> getChildren() {
        return children;
    }

    public void setChildren(List<Resources> children) {
        this.children = children;
    }

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    public Long getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Long modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

}