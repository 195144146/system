package com.yz.crm.service.impl.system;

import com.yz.crm.common.entity.user.Resources;
import com.yz.crm.common.utils.ValiDataUtils;
import com.yz.crm.service.mapper.system.MenuMapper;
import com.yz.crm.service.service.system.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public List<Resources> selectResourcesTree(Integer pid) {
        return menuMapper.selectResourcesTree(pid);
    }

    /**
     * 新增资源
     * @param param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertResources(Resources param) throws Exception {
        Integer count;
        if(ValiDataUtils.isNotNull(param.getPath())){
            count = menuMapper.selectResourcesCountByPath(param);
        }else {
            count = 0;
        }
        if(count > 0){
            throw new Exception("资源已存在");
        }
        menuMapper.insertResources(param);
    }

    /**
     * 通过id更新资源
     * @param param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateResourcesById(Resources param) throws Exception {
        Integer count;
        if(ValiDataUtils.isNotNull(param.getPath())){
            count = menuMapper.selectResourcesCountByPath(param);
        }else {
            count = 0;
        }
        if(count > 0){
            throw new Exception("资源已存在");
        }
        menuMapper.updateResourcesById(param);
    }

    /**
     * 通过id删除资源
     * @param param
     */
    @Override
    public void deleteResourcesById(Resources param) {
        menuMapper.deleteResourcesById(param);
    }
}
