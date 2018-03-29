package com.yz.crm.web.controller.user;

import com.netflix.discovery.converters.Auto;
import com.yz.crm.common.entity.User;
import com.yz.crm.web.service.client.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String login(Map<String,Object> param){
        List list = new ArrayList();
        User user = new User();
        list.add(user);
        List<User> rtl = userService.saveUser(list);
        return "index";
    }

}
