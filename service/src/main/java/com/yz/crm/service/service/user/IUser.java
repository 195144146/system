package com.yz.crm.service.service.user;


import com.yz.crm.common.entity.User;

import java.util.List;

public interface IUser {
    /**
     * 保存用户
     * @param param
     * @return
     */
    List<User> saveUser(List<User> param);

    /**
     * 查询用户信息
     * @param param
     * @return
     */
    List<User> selectUser(User param);
}
