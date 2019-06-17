package com.yz.crm.web.service.client;

import com.yz.crm.common.entity.system.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("service")
public interface IUserService {

    @RequestMapping(value = "/user/save",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    List<SysUser> saveUser(@RequestBody List<SysUser> requestBody);

    @RequestMapping(value = "/user/select",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    List<SysUser> selectUser(@RequestBody SysUser param);
}
