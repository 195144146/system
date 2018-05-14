package com.yz.crm.service.mapper;

import com.yz.crm.common.entity.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user(user_name,pass_word) values(#{userName},#{passWord})")
    void saveUser(User user);

    List<User> selectUser();


}
