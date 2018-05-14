package com.yz.crm.service.impl.user;

import com.yz.crm.common.entity.user.User;
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
    public List<User> saveUser(List<User> param) {
        param.forEach((User user)->{
            userMapper.saveUser(user);
        });
        return param;
    }

    @Override
    public List<User> selectUser(User param) {
        return userMapper.selectUser();
    }


}
