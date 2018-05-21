package com.yz.crm.service.controller.system;

import com.yz.crm.common.entity.system.datadictionary.ItemCode;
import com.yz.crm.common.entity.user.Resources;
import com.yz.crm.service.service.system.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-05-17 16:04
 * @create:: 下午4:04
 * @description:
 **/
@RestController
@RequestMapping(value = "/menuService",method = RequestMethod.POST)
public class MenuController {

    @Autowired
    IMenuService menuServiceImpl;

    /**
     * 查询资源树
     * @param pid
     * @return
     */
    @RequestMapping(value = "/selectResourcesTree")
    public List<Resources> selectResourcesTree(@RequestBody Integer pid){
        return menuServiceImpl.selectResourcesTree(pid);
    }
}
