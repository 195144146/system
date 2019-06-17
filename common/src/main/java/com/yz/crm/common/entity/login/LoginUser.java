package com.yz.crm.common.entity.login;

import com.yz.crm.common.entity.system.SysResources;
import com.yz.crm.common.entity.system.SysUser;

import java.util.List;

/**
 * 登陆用户Bean
 * Created By 虞嘉俊 195144146@qq.com on 2019/5/21
 */
public class LoginUser extends SysUser {
    private static final long serialVersionUID = -2492960669610504814L;

    /**
     * 资源列表
     */
    List<SysResources> resources;

    /**
     * 获取资源列表
     * @return
     */
    public List<SysResources> getResources() {
        return resources;
    }

    /**
     * 设置资源列表
     * @param resources
     */
    public void setResources(List<SysResources> resources) {
        this.resources = resources;
    }
}
