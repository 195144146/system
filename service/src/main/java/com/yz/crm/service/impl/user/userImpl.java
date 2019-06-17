package com.yz.crm.service.impl.user;

import com.yz.crm.common.entity.system.SysUser;
import com.yz.crm.service.mapper.UserMapper;
import com.yz.crm.service.service.user.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("userImpl")
public class userImpl implements IUser {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<SysUser> saveUser(List<SysUser> param) {
        param.forEach((SysUser user)->{
            userMapper.saveUser(user);
        });
        return param;
    }

    @Override
    public List<SysUser> selectUser(SysUser param) {
        return userMapper.selectUser();
    }


}
