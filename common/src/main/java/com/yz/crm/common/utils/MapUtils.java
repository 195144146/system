package com.yz.crm.common.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map帮助类
 * Created by 虞嘉俊 195144146@qq.com on 2017/7/29.
 */
public class MapUtils {

    /**
     * 获取该前缀的所有字段
     * @param map
     * @param keyPrefix
     * @return
     */
    public static Map<String,Object> getKeyPrefixInfo(Map map, String keyPrefix){
        Map<String,Object> rtnHashMap = new HashMap<>();
        map.forEach((K,V) ->{
            if(K.toString().startsWith(keyPrefix)){
                rtnHashMap.put(K.toString().replace(keyPrefix,""),V);
            }
        });
        return rtnHashMap;
    }

    /**
     * 获取返回成功
     * @return
     */
    public static Map<String,Object> getReturnSuccessMap() {
        Map<String,Object> rtl = new HashMap<>();
        rtl.put("result", true);
        return rtl;
    }

    /**
     * 获取返回成功List
     * @return
     */
    public static Map<String,Object> getReturnSuccessMap(List list) {
        Map<String,Object> rtl = getReturnSuccessMap();
        rtl.put("type","list");
        rtl.put("info",list);
        return rtl;
    }

    /**
     * 获取返回成功object
     * @param o
     * @return
     */
    public static Map<String,Object> getReturnSuccessMap(Object o) {
        Map<String,Object> rtl =  getReturnSuccessMap();
        rtl.put("type","object");
        rtl.put("info",o);
        return rtl;
    }

    /**
     * 获取返回成功自定义Map
     * @return
     */
    public static Map<String,Object> getReturnSuccessCustomizeMap(Object o) {
        Map<String,Object> rtl = getReturnSuccessMap();
        rtl.put("type","object");
        rtl.put("info",o);
        return rtl;
    }

    /**
     * 获取返回失败
     * @return
     */
    public static Map<String,Object> getReturnFailureMap() {
        Map<String,Object> rtl = new HashMap<String, Object>();
        rtl.put("result", false);
        return rtl;
    }

    /**
     * 获取返回失败
     * @return
     */
    public static Map<String,Object> getReturnFailureMap(String failure) {
        Map<String,Object> rtl = getReturnFailureMap();
        rtl.put("errorMessage",failure);
        return rtl;

    }

    /**
     * 获取连连支付成功信息
     * @return
     */
    public static Map<String,Object> getLianlianPaySuccessInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("ret_code","0000");
        map.put("ret_mes","交易成功");
        return map;
    }
}
