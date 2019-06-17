package com.yz.crm.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-04-12 14:13
 * @description:
 **/
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1964291652062711866L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 创建时间
     */
    private Date createdOn;

    /**
     * 修改人
     */
    private Long modifiedBy;

    /**
     * 修改时间
     */
    private Date modifiedOn;

    /**
     * 删除标志
     */
    private Boolean isDeleted;

    /**
     * 获取主键id
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取状态
     * @return
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建人
     * @return
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人
     * @param createdBy
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取创建时间
     * @return
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * 设置创建时间
     * @param createdOn 创建时间
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * 获取修改人
     * @return
     */
    public Long getModifiedBy() {
        return modifiedBy;
    }

    /**
     * 设置修改人
     * @param modifiedBy
     */
    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * 获取修改时间
     * @return
     */
    public Date getModifiedOn() {
        return modifiedOn;
    }

    /**
     * 设置修改时间
     * @param modifiedOn 修改时间
     */
    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    /**
     * 获取删除标志
     * @return
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置删除标志
     * @param isDeleted 删除标志
     */
    public void setIsDeleted(Boolean isDeleted) {
        isDeleted = isDeleted;
    }
}
