package com.yz.crm.service.mapper.system;

import com.yz.crm.common.entity.system.SysDataDictionary;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 数据字典相关Mapper
 */
@Mapper
public interface DataDictionaryMapper {

    /**
     * 查询数据字典列表
     * @param param
     * @return
     */
    List<SysDataDictionary> selectDataDictionaryList(SysDataDictionary param);

    /**
     * 新增数据字典项
     */
    void insertDataDictionary(SysDataDictionary param);

    /**
     * 通过id更新数据字典项
     * @param param
     */
    void updateDataDictionaryById(SysDataDictionary param);

    /**
     * 通过id删除数据字典项
     * @param param
     */
    void deleteDataDictionaryById(SysDataDictionary param);

    /**
     * 通过条件查询数据字典条数
     * @param param
     * @return
     */
    Integer selectDataDictionaryCount(SysDataDictionary param);
}
