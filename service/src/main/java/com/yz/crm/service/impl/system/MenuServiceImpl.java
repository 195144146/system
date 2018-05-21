package com.yz.crm.service.impl.system;

import com.yz.crm.common.entity.user.Resources;
import com.yz.crm.service.mapper.system.MenuMapper;
import com.yz.crm.service.service.system.IMenuService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-05-17 16:17
 * @create:: 下午4:17
 * @description:
 **/
@Service("menuServiceImpl")
public class MenuServiceImpl implements IMenuService {

    @Autowired
    MenuMapper menuMapper;

    /**
     * 查询资源树
     * @return
     */
    @Override
    public List<Resources> selectResourcesTree(Integer pid) {
        return menuMapper.selectResourcesTree(pid);
    }
}
