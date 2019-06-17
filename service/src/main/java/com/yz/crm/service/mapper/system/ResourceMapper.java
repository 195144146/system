package com.yz.crm.service.mapper.system;

import com.yz.crm.common.entity.system.SysResources;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单相关Mapper
 */
@Mapper
public interface ResourceMapper {

    /**
     * 查询资源树（包含按钮资源等数据）
     * @return
     */
    List<SysResources> selectResourcesTree(@Param("id") Integer id);

    /**
     * 通过资源地址和id查询资源数
     * @param param
     * @return
     */
    Integer selectResourcesCountByPath(SysResources param);

    /**
     * 新增资源
     * @param param
     */
    void insertResources(SysResources param);

    /**
     * 通过id更新资源项
     * @param param
     */
    void updateResourcesById(SysResources param);

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
