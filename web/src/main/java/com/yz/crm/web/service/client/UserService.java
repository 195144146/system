package com.yz.crm.web.service.client;

import com.yz.crm.common.entity.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("service")
@RequestMapping(value = "/user",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
public interface UserService {

    @RequestMapping(value = "/save")
    List<User> saveUser(@RequestBody List<User> requestBody);

    @RequestMapping(value = "/select")
    List<User> selectUser(@RequestBody User param);
}
