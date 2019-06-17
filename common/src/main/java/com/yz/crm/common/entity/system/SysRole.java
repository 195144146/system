package com.yz.crm.common.entity.system;

import com.yz.crm.common.entity.BaseEntity;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-04-11 16:45
 * @description: 角色类 role
 **/
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = -736376964070927120L;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色类型
     */
    private Integer type;

    /**
     * 部门id
     */
    private Long deptId;

    /**
     * 获取角色名称
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取角色类型
     * @return
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置角色类型
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取部门id
     * @return
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置部门id
     * @param deptId
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

}
