package com.yz.crm.web.service.client.system;

import com.yz.crm.common.entity.system.SysDataDictionary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-05-08 10:54
 * @description: 数据字典服务
 **/
@FeignClient("service")
public interface IDataDictionaryService {

    /**
     * 查询数据字典列表
     * @param param
     * @return
     */
    @RequestMapping(value = "/datadictionary/selectDataDictionaryList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    List<SysDataDictionary> selectDataDictionaryList(@RequestBody SysDataDictionary param);

    /**
     * 新增数据字典项
     * @param param
     */
    @RequestMapping(value = "/datadictionary/insertDataDictionary", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    void insertDataDictionary(@RequestBody SysDataDictionary param);

    /**
     * 通过id更新数据字典项
     * @param param
     */
    @RequestMapping(value = "/datadictionary/updateDataDictionaryById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    void updateDataDictionaryById(@RequestBody SysDataDictionary param);

    /**
     * 通过id删除数据字典项
     * @param param
     */
    @RequestMapping(value = "/datadictionary/deleteDataDictionaryById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    void deleteDataDictionaryById(@RequestBody SysDataDictionary param);

}
