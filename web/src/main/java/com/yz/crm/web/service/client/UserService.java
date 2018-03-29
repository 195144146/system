package com.yz.crm.web.service.client;

import com.yz.crm.common.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("service")
public interface UserService {

    @RequestMapping(value = "/save",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    List<User> saveUser(@RequestBody List<User> requestBody);

    @RequestMapping(value = "/select",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    List<User> selectUser(@RequestBody User param);
}
