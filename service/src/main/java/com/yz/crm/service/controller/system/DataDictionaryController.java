package com.yz.crm.service.controller.system;

import com.yz.crm.common.entity.system.datadictionary.ItemCode;
import com.yz.crm.service.service.system.IDataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-05-08 10:55
 * @create:: 上午10:55
 * @description: 数据字典Action
 **/
@RestController
@RequestMapping(value = "/datadictionary",method = RequestMethod.POST)
public class DataDictionaryController {

    @Autowired
    IDataDictionaryService dataDictionaryServiceImpl;

    /**
     * 查询数据字典列表
     * @param param
     * @return
     */
    @RequestMapping("/selectDataDictionaryList")
    public List<ItemCode> selectDataDictionaryList(@RequestBody ItemCode param){
        return dataDictionaryServiceImpl.selectDataDictionaryList(param);
    }

    /**
     * 新增数据字典项
     * 该方法会先查询需要新增的项是否在数据库中已经存在如果存在则添加如果不存在则不添加并且抛出异常
     */
    @RequestMapping("/insertDataDictionary")
    public void insertDataDictionary(@RequestBody ItemCode param) throws Exception {
        dataDictionaryServiceImpl.insertDataDictionary(param);
    }

    /**
     * 通过id更新数据字典项
     * @param param
     * @throws Exception
     */
    @RequestMapping("/updateDataDictionaryById")
    public void updateDataDictionaryById(@RequestBody ItemCode param) throws Exception {
        dataDictionaryServiceImpl.updateDataDictionaryById(param);
    }

    /**
     * 通过id删除数据字典项
     * @param param
     * @throws Exception
     */
    @RequestMapping("/deleteDataDictionaryById")
    public void deleteDataDictionaryById(@RequestBody ItemCode param) throws Exception {
        dataDictionaryServiceImpl.deleteDataDictionaryById(param);
    }


}
