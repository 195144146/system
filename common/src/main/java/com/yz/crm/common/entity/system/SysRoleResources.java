package com.yz.crm.common.entity.system;

import com.yz.crm.common.entity.BaseEntity;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-04-12 14:02
 * @description: 角色资源表role_resources
 **/
public class SysRoleResources extends BaseEntity {

    private static final long serialVersionUID = 9089027827951617417L;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 资源id
     */
    private Long resourcesId;

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

    /**
     * 获取资源id
     * @return
     */
    public Long getResourcesId() {
        return resourcesId;
    }

    /**
     * 设置资源id
     * @param resourcesId
     */
    public void setResourcesId(Long resourcesId) {
        this.resourcesId = resourcesId;
    }

}
