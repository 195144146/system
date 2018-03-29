package com.yz.crm.service.mapper;

import com.yz.crm.common.entity.User;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
//@Mapper
public interface UserMapper {
//    @Insert("insert into tablename ")
    void saveUser(User user);
}
