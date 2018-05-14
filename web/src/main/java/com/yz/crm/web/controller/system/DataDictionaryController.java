package com.yz.crm.web.controller.system;

import com.yz.crm.common.entity.system.datadictionary.ItemCode;
import com.yz.crm.web.service.client.system.IDataDictionaryService;
import com.yz.crm.web.utils.ReturnResponseEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-05-04 14:51
 * @create:: 下午2:51
 * @description: 数据字典Controller
 **/
@RestController
@RequestMapping("/datadictionary")
public class DataDictionaryController {

    @Autowired
    IDataDictionaryService dataDictionaryService;

    /**
     * 查询数据字典列表
     * @param param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/getDataDictionaryList", produces = "application/json;charset=UTF-8;")
    public ResponseEntity selectDataDictionaryList(@RequestBody ItemCode param){
        try {
            List<ItemCode> itemCodeList = dataDictionaryService.selectDataDictionaryList(param);
            return ReturnResponseEntityUtil.success(itemCodeList);
        } catch (Exception e) {
            return ReturnResponseEntityUtil.failure(e);
        }
    }

    /**
     * 新增数据字典项
     * 该方法会先查询需要新增的项是否在数据库中已经存在如果存在则添加如果不存在则不添加并且抛出异常
     * @param param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/addDataDictionary", produces = "application/json;charset=UTF-8;")
    public ResponseEntity insertDataDictionary(@RequestBody ItemCode param){
        try {
            dataDictionaryService.insertDataDictionary(param);
            return ReturnResponseEntityUtil.success();
        } catch (Exception e) {
            return ReturnResponseEntityUtil.failure(e);
        }
    }

    /**
     * 通过id更新数据字典项
     * @param param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/alterDataDictionaryById", produces = "application/json;charset=UTF-8;")
    public ResponseEntity updateDataDictionaryById(@RequestBody ItemCode param){
        try {
            dataDictionaryService.updateDataDictionaryById(param);
            return ReturnResponseEntityUtil.success();
        } catch (Exception e) {
            return ReturnResponseEntityUtil.failure(e);
        }
    }

    /**
     * 通过id删除数据字典项
     * @param param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/removeDataDictionaryById", produces = "application/json;charset=UTF-8;")
    public ResponseEntity removeDataDictionaryById(@RequestBody ItemCode param){
        try {
            dataDictionaryService.deleteDataDictionaryById(param);
            return ReturnResponseEntityUtil.success();
        } catch (Exception e) {
            return ReturnResponseEntityUtil.failure(e);
        }
    }

}
