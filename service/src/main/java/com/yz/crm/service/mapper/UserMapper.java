package com.yz.crm.service.mapper;

import com.yz.crm.common.entity.system.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user(user_name,pass_word) values(#{userName},#{passWord})")
    void saveUser(SysUser user);

    List<SysUser> selectUser();


}
