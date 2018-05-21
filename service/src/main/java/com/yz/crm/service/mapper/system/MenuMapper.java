package com.yz.crm.service.mapper.system;

import com.yz.crm.common.entity.user.Resources;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单相关Mapper
 */
@Mapper
public interface MenuMapper {

    /**
     * 查询资源树（包含按钮资源等数据）
     * @return
     */
    List<Resources> selectResourcesTree(@Param("id") Integer id);

    /**
     * 通过资源地址和id查询资源数
     * @param param
     * @return
     */
    Integer selectResourcesCountByPath(Resources param);

    /**
     * 新增资源
     * @param param
     */
    void insertResources(Resources param);

    /**
     * 通过id更新资源项
     * @param param
     */
    void updateResourcesById(Resources param);

    /**
     * 通过id删除资源
     * @param param
     */
    void deleteResourcesById(Resources param);
}
