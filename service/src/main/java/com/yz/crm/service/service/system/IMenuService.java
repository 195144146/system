package com.yz.crm.service.service.system;

import com.yz.crm.common.entity.user.Resources;

import java.util.List;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-05-17 16:06
 * @create:: 下午4:06
 * @description:
 **/
public interface IMenuService {

    /**
     * 查询资源树
     * @return
     */
    List<Resources> selectResourcesTree(Integer pid);

    /**
     * 新增资源
     * @param param
     */
    void insertResources(Resources param) throws Exception;

    /**
     * 通过id更新资源
     * @param param
     */
    void updateResourcesById(Resources param) throws Exception;

    /**
     * 通过id删除资源
     * @param param
     */
    void deleteResourcesById(Resources param);
}
