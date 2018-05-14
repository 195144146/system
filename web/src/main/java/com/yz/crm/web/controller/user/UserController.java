package com.yz.crm.web.controller.user;

import com.yz.crm.common.entity.user.User;
import com.yz.crm.web.service.client.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-04-11 16:36
 * @description: 用户Controller
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String login(Map<String,Object> param){
        List list = new ArrayList();
        User user = new User();
        user.setPassWord("fdasfads");
        list.add(user);
        List<User> rtl = userService.saveUser(list);
        return "index";
    }

    @RequestMapping("/select")
    public String selectUser(){
        List<User> rtl = userService.selectUser(new User());
        return "index";
    }

}
