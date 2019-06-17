package com.yz.crm.web.service.client.system;

import com.yz.crm.common.entity.system.SysResources;
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
public interface IResourceService {

    /**
     * 查询资源树
     * @return
     */
    @RequestMapping(value = "/resourceService/selectResourcesTree", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    List<SysResources> selectResourcesTree(Integer pid);

    /**
     * 新增资源
     * @param param
     */
    @RequestMapping(value = "/resourceService/insertResources", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    void insertResources(SysResources param);

    /**
     * 通过id更新资源
     * @param param
     */
    @RequestMapping(value = "/resourceService/updateResourcesById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    void updateResourcesById(SysResources param);

    /**
     * 通过id删除资源
     * @param param
     */
    @RequestMapping(value = "/resourceService/deleteResourcesById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    void deleteResourcesById(SysResources param);

    /**
     * 获取公共接口列表
     * @return
     */
    @RequestMapping(value = "/resourceService/getPublicInterface", method = RequestMethod.POST)
    List<String> getPublicInterface();
}
