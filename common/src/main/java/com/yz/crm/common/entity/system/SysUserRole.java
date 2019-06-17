package com.yz.crm.common.entity.system;

import com.yz.crm.common.entity.BaseEntity;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-04-12 13:44
 * @description: 用户角色表user_role
 **/
public class SysUserRole extends BaseEntity{

    private static final long serialVersionUID = -8859567148442516253L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 获取用户id
     * @return
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取角色id
     * @return
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}
