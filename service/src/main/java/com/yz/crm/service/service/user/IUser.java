package com.yz.crm.service.service.user;

import com.yz.crm.common.entity.system.SysUser;
import java.util.List;

public interface IUser {
    /**
     * 保存用户
     * @param param
     * @return
     */
    List<SysUser> saveUser(List<SysUser> param);

    /**
     * 查询用户信息
     * @param param
     * @return
     */
    List<SysUser> selectUser(SysUser param);
}
