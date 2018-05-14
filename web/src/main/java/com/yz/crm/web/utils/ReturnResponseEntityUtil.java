package com.yz.crm.web.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-05-04 15:18
 * @create:: 下午3:18
 * @description: 返回ResponseEntity帮助类
 **/
public class ReturnResponseEntityUtil {

    public static ResponseEntity success(){
        return new ResponseEntity<Map<String,Object>>(MapUtils.getReturnSuccessMap(), HttpStatus.OK);
    }

    public static ResponseEntity success(Object o){
        return new ResponseEntity<Map<String,Object>>(MapUtils.getReturnSuccessMap(o), HttpStatus.OK);
    }

    public static ResponseEntity success(List list){
        return new ResponseEntity<Map<String,Object>>(MapUtils.getReturnSuccessMap(list), HttpStatus.OK);
    }

    public static ResponseEntity failure(){
        return new ResponseEntity<Map<String,Object>>(MapUtils.getReturnFailureMap(), HttpStatus.FAILED_DEPENDENCY);
    }

    public static ResponseEntity failure(Exception e){
        return new ResponseEntity<Map<String,Object>>(MapUtils.getReturnFailureMap(e.getMessage()), HttpStatus.FAILED_DEPENDENCY);
    }
}
