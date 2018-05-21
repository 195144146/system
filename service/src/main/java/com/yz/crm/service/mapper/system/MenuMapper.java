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

}
