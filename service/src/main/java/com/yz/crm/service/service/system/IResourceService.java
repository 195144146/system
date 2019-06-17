package com.yz.crm.service.service.system;

import com.yz.crm.common.entity.system.SysResources;
import java.util.List;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-05-17 16:06
 * @create:: 下午4:06
 * @description:
 **/
public interface IResourceService {

    /**
     * 查询资源树
     * @return
     */
    List<SysResources> selectResourcesTree(Integer pid);

    /**
     * 新增资源
     * @param param
     */
    void insertResources(SysResources param) throws Exception;

    /**
     * 通过id更新资源
     * @param param
     */
    void updateResourcesById(SysResources param) throws Exception;

    /**
     * 通过id删除资源
     * @param param
     */
    void deleteResourcesById(SysResources param);

    /**
     * 获取公共接口列表
     * @return
     */
    List<String> getPublicInterface();
}
