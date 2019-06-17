package com.yz.crm.service.controller.system;

import com.yz.crm.common.entity.system.SysResources;
import com.yz.crm.service.service.system.IResourceService;
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
@RequestMapping(value = "/resourceService",method = RequestMethod.POST)
public class ResourceController {

    @Autowired
    IResourceService resourceServiceImpl;

    /**
     * 查询资源树
     * @param pid
     * @return
     */
    @RequestMapping(value = "/selectResourcesTree")
    public List<SysResources> selectResourcesTree(@RequestBody Integer pid){
        return resourceServiceImpl.selectResourcesTree(pid);
    }

    /**
     * 新增资源
     * @param param
     */
    @RequestMapping(value = "/insertResources")
    public void insertResources(@RequestBody SysResources param) throws Exception {
        resourceServiceImpl.insertResources(param);
    }

    /**
     * 通过id更新资源
     * @param param
     */
    @RequestMapping(value = "/updateResourcesById")
    public void updateResourcesById(@RequestBody SysResources param) throws Exception {
        resourceServiceImpl.updateResourcesById(param);
    }

    /**
     * 通过id删除资源
     * @param param
     */
    @RequestMapping(value = "/deleteResourcesById")
    public void deleteResourcesById(@RequestBody SysResources param){
        resourceServiceImpl.deleteResourcesById(param);
    }

    /**
     * 获取公共接口
     * @return
     */
    @RequestMapping(value = "/getPublicInterface")
    public List<String> getPublicInterface(){
        return resourceServiceImpl.getPublicInterface();
    }
}
