package com.yz.crm.web.service.client.system;

import com.yz.crm.common.entity.system.datadictionary.ItemCode;
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
@RequestMapping(value = "/datadictionary",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
public interface IDataDictionaryService {

    /**
     * 查询数据字典列表
     * @param param
     * @return
     */
    @RequestMapping(value = "/selectDataDictionaryList")
    List<ItemCode> selectDataDictionaryList(@RequestBody ItemCode param);

    /**
     * 新增数据字典项
     * @param param
     */
    @RequestMapping(value = "/insertDataDictionary")
    void insertDataDictionary(@RequestBody ItemCode param);

    /**
     * 通过id更新数据字典项
     * @param param
     */
    @RequestMapping(value = "/updateDataDictionaryById")
    void updateDataDictionaryById(@RequestBody ItemCode param);

    /**
     * 通过id删除数据字典项
     * @param param
     */
    @RequestMapping(value = "/deleteDataDictionaryById")
    void deleteDataDictionaryById(@RequestBody ItemCode param);

}
