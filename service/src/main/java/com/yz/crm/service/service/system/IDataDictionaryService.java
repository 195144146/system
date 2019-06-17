package com.yz.crm.service.service.system;

import com.yz.crm.common.entity.system.SysDataDictionary;
import java.util.List;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-05-08 11:09
 * @create:: 上午11:09
 * @description: 数据字典服务接口
 **/
public interface IDataDictionaryService {

    /**
     * 查询数据字典列表
     * @param param
     * @return
     */
    List<SysDataDictionary> selectDataDictionaryList(SysDataDictionary param);

    /**
     * 新增数据字典项
     */
    void insertDataDictionary(SysDataDictionary param) throws Exception;

    /**
     * 更新数据字典项
     * @param param
     */
    void updateDataDictionaryById(SysDataDictionary param) throws Exception;

    /**
     * 删除数据字典项
     * @param param
     */
    void deleteDataDictionaryById(SysDataDictionary param) throws Exception;

}
