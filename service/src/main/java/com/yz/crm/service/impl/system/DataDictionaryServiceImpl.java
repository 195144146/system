package com.yz.crm.service.impl.system;

import com.yz.crm.common.entity.system.SysDataDictionary;
import com.yz.crm.service.mapper.system.DataDictionaryMapper;
import com.yz.crm.service.service.system.IDataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-05-08 11:11
 * @create:: 上午11:11
 * @description: 数据字典服务实现类
 **/
@Service("dataDictionaryServiceImpl")
public class DataDictionaryServiceImpl implements IDataDictionaryService {

    @Autowired
    DataDictionaryMapper dataDictionaryMapper;

    /**
     * 查询数据字典列表
     * @param param
     * @return
     */
    @Override
    public List<SysDataDictionary> selectDataDictionaryList(SysDataDictionary param) {
        return dataDictionaryMapper.selectDataDictionaryList(param);
    }

    /**
     * 新增数据字典项
     * @param param
     */
    @Override
    public void insertDataDictionary(SysDataDictionary param) throws Exception {
        Integer count = dataDictionaryMapper.selectDataDictionaryCount(param);
        if (!count.equals(0)){
            throw new Exception("该项目已存在");
        }
        dataDictionaryMapper.insertDataDictionary(param);
    }

    /**
     * 通过id更新数据字典
     * @param param
     */
    @Override
    public void updateDataDictionaryById(SysDataDictionary param) throws Exception {
        if(param.getId() == null){
            throw new Exception("请选择更改项");
        }
        dataDictionaryMapper.updateDataDictionaryById(param);
    }

    /**
     * 通过id删除数据字典项
     * @param param
     */
    @Override
    public void deleteDataDictionaryById(SysDataDictionary param) throws Exception {
        if(param.getId() == null){
            throw new Exception("请选择删除项");
        }
        dataDictionaryMapper.deleteDataDictionaryById(param);
    }
}
