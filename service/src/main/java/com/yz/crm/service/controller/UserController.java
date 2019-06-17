package com.yz.crm.service.controller;

import com.yz.crm.common.entity.system.SysUser;
import com.yz.crm.service.service.user.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/user",method = RequestMethod.POST)
public class UserController {

    @Autowired
    IUser userImpl;

    @RequestMapping("/save")
    public List<SysUser> saveUser(@RequestBody List<SysUser> requestBody){
//        List<User> rtl = userImpl.saveUser(requestBody);
        for (SysUser user : requestBody) {
            user.setId(999L);
        }
        requestBody = userImpl.saveUser(requestBody);
        return requestBody;
    }

    @RequestMapping("/select")
    public List<SysUser> selectUser(@RequestBody SysUser param){
        return userImpl.selectUser(param);
    }


}
