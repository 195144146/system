package com.yz.crm.web.service.client.system;

import com.yz.crm.common.entity.user.Resources;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-05-08 10:54
 * @description: 菜单服务
 **/
@FeignClient("service")
@RequestMapping(value = "/menuService",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
public interface IMenuService {

    /**
     * 查询资源树
     * @return
     */
    @RequestMapping(value = "/selectResourcesTree")
    List<Resources> selectResourcesTree(Integer pid);

}
