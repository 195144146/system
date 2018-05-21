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
}
