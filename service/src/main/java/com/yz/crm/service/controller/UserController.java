package com.yz.crm.service.controller;

import com.yz.crm.common.entity.user.User;
import com.yz.crm.service.service.user.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/user",method = RequestMethod.POST)
public class UserController {

    @Autowired
    IUser userImpl;

    @RequestMapping("/save")
    public List<User> saveUser(@RequestBody List<User> requestBody){
//        List<User> rtl = userImpl.saveUser(requestBody);
        for (User user : requestBody) {
            user.setId(999L);
        }
        requestBody = userImpl.saveUser(requestBody);
        return requestBody;
    }

    @RequestMapping("/select")
    public List<User> selectUser(@RequestBody User param){
        return userImpl.selectUser(param);
    }
}
