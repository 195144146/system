package com.yz.crm.web.controller.system;

import com.yz.crm.common.entity.user.Resources;
import com.yz.crm.web.service.client.system.IMenuService;
import com.yz.crm.web.utils.ReturnResponseEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-05-17 15:17
 * @create:: 下午3:17
 * @description: 菜单Controller
 **/
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    IMenuService menuService;

    /**
     * 获取菜单树
     * @param param
     * @return
     */
//    @RequestMapping(method = RequestMethod.POST, value = "/getMenuTree", produces = "application/json;charset=UTF-8;")
//    public ResponseEntity getMenuList(@RequestBody ItemCode param){
//        try {
//            List<ItemCode> itemCodeList = dataDictionaryService.selectDataDictionaryList(param);
//            return ReturnResponseEntityUtil.success(itemCodeList);
//        } catch (Exception e) {
//            return ReturnResponseEntityUtil.failure(e);
//        }
//    }

    /**
     * 获取资源树
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/getResourcesTree", produces = "application/json;charset=UTF-8;")
    public ResponseEntity getResourcesTree(){
        try {
            List<Resources> itemCodeList = menuService.selectResourcesTree(0);
            return ReturnResponseEntityUtil.success(itemCodeList);
        } catch (Exception e) {
            return ReturnResponseEntityUtil.failure(e);
        }
    }
}
