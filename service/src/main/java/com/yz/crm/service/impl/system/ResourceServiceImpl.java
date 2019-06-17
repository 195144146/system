package com.yz.crm.service.impl.system;

import com.yz.crm.common.component.Cache;
import com.yz.crm.common.entity.system.SysResources;
import com.yz.crm.common.utils.ValiDataUtils;
import com.yz.crm.service.mapper.system.ResourceMapper;
import com.yz.crm.service.service.system.IResourceService;
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
@Service("resourceServiceImpl")
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    ResourceMapper resourceMapper;

    /**
     * 查询资源树
     * @return
     */
    @Override
    @Transactional
    public List<SysResources> selectResourcesTree(Integer pid) {
        return resourceMapper.selectResourcesTree(pid);
    }

    /**
     * 新增资源
     * @param param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertResources(SysResources param) throws Exception {
        Integer count;
        if(ValiDataUtils.isNotNull(param.getPath())){
            count = resourceMapper.selectResourcesCountByPath(param);
        }else {
            count = 0;
        }
        if(count > 0){
            throw new Exception("资源已存在");
        }
        resourceMapper.insertResources(param);
    }

    /**
     * 通过id更新资源
     * @param param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateResourcesById(SysResources param) throws Exception {
        Integer count;
        if(ValiDataUtils.isNotNull(param.getPath())){
            count = resourceMapper.selectResourcesCountByPath(param);
        }else {
            count = 0;
        }
        if(count > 0){
            throw new Exception("资源已存在");
        }
        resourceMapper.updateResourcesById(param);
    }

    /**
     * 通过id删除资源
     * @param param
     */
    @Override
    public void deleteResourcesById(SysResources param) {
        resourceMapper.deleteResourcesById(param);
    }

    /**
     * 获取公共接口列表
     * @return
     */
    @Override
    @Cache(key = "publicInterface", permanent = true)
    public List<String> getPublicInterface() {
        return resourceMapper.getPublicInterface();
    }
}
