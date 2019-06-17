package com.yz.crm.common.utils;

import java.util.*;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-05-22 16:07
 * @create:: 下午4:07
 * @description:
 **/
public class ValiDataUtils {

    /**
     * 验证非空<br>
     * validIsEmpty(null)      = false<br>
     * validIsEmpty("")        = false<br>
     * validIsEmpty(" ")       = false<br>
     * validIsEmpty("bob")     = true<br>
     * validIsEmpty("  bob  ") = true<br>
     * @param value 需要验证的值
     * @return true 空 false 非空
     */
    public static boolean validNotEmpty(String value){
        if(value!=null)
            return !"".equals(value.trim());
        else
            return false;
    }

    /**
     * 验证非空；<br>
     * empty = false<br>
     * validIsEmpty(null)      = false<br>
     * validIsEmpty("")        = false<br>
     * validIsEmpty(" ")       = false<br>
     * validIsEmpty("bob")     = true<br>
     * validIsEmpty("  bob  ") = true<br>
     * empty = true<br>
     * validIsEmpty(null)      = false<br>
     * validIsEmpty("")        = false<br>
     * validIsEmpty(" ")       = true<br>
     * validIsEmpty("bob")     = true<br>
     * validIsEmpty("  bob  ") = true<br>
     * @param value 需要验证的值
     * @return true 空 false 非空
     */
    public static boolean validNotEmpty(String value,boolean isEmpty){
        if(isEmpty) return !"".equals(value.trim());
        else return validNotEmpty(value);
    }

    /**
     * 验证非空
     * @param value 需要验证的值
     * @return true 空 false 非空
     */
    public static boolean validNotEmpty(Double value){
        return value != null;
    }

    /**
     * 验证非空
     * @param value 需要验证的值
     * @return true 空 false 非空
     */
    public static boolean validNotEmpty(Float value){
        return value != null;
    }

    /**
     * 验证非空
     * @param value 需要验证的值
     * @return true 空 false 非空
     */
    public static boolean validNotEmpty(Long value){
        return value != null;
    }

    /**
     * 验证非空
     * @param value 需要验证的值
     * @return true 空 false 非空
     */
    public static boolean validNotEmpty(Integer value){
        return value != null;
    }

    /**
     * 验证是否大于最小长度
     * @param value 需要验证的值
     * @param length 长度
     * @param allowEmpty 允许为空
     * @return true 通过 false 不通过
     */
    public static boolean validMinLength(String value,int length,boolean allowEmpty){
        if (validNotEmpty(value)){
            if (value.length() < length) return false;
            else return true;
        } else {
            if (allowEmpty) return true;
            else return false;
        }
    }

    /**
     * 验证最小长度
     * @param value 需要验证的值
     * @param length 长度
     * @return true 通过 false 不通过
     */
    public static boolean validMinLength(String value,int length){
        return validMinLength(value,length,false);
    }

    /**
     * 验证最大长度
     * @param value 需要验证的值
     * @param length 长度
     * @param allowEmpty 允许为空
     * @return true 通过 false 不通过
     */
    public static boolean validMaxLength(String value, int length, boolean allowEmpty){
        if(validNotEmpty(value)){
            if(length >= value.length()) return true;
            else return false;
        }else{
            if (allowEmpty)return true;
            else return false;
        }
    }

    /**
     * 验证最大长度
     * @param value 需要验证的值
     * @param length 长度
     * @return true 通过 false 不通过
     */
    public static boolean validMaxLength(String value, int length){
        return validMaxLength(value,length,false);
    }

    /**
     * 验证字符串长度
     * @param value 需要验证的值
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @param allowEmpty 允许为空
     * @return true 通过 false 不通过
     */
    public static boolean validLength(String value, int minLength,int maxLength,boolean allowEmpty){
        if(validNotEmpty(value)){
            if (value.length()>maxLength||value.length()<minLength) return false;
            else return true;
        }else{
            if (allowEmpty) return true;
            else return false;
        }
    }

    /**
     * 验证字符串长度
     * @param value 需要验证的值
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @return true 通过 false 不通过
     */
    public static boolean validLength(String value, int minLength,int maxLength){
        return validLength(value,minLength,maxLength,false);
    }


//    /**
//     * 验证是否传入分页
//     * @param param
//     */
//    public static void validPage(LinkedHashMap<String, Object> param){
//        if (param.get(RequestConstantEnum.PAGE.getValue()) != null && param.get(RequestConstantEnum.PAGESIZE.getValue()) != null) {//判断是否有查询和pageSize
//            int pageNum = 0;
//            int pageSize = 0;
//            try {
//                pageNum = Integer.parseInt(param.get(RequestConstantEnum.PAGE.getValue()).toString());
//                pageSize = Integer.parseInt(param.get(RequestConstantEnum.PAGESIZE.getValue()).toString());
//                PageHelper.startPage(pageNum, pageSize);
//            } catch (Exception e) {
//                logger.error(e.getMessage(), e);
//            }
//        }
//    }j



    public final static boolean isNull(Map map){
        if(map==null||map.size()==0) return true;
        return false;
    }

    public final static boolean isNotNull(Map map){
        return !isNull(map);
    }

    public final static boolean isNull(Collection collection){
        if(collection==null||collection.size()==0) return true;
        return false;
    }

    public final static boolean isNotNull(Collection collection){
        return !isNull(collection);
    }

    public final static boolean isNull(String str){
        return str == null || "".equals(str.trim()) || "null".equals(str.toLowerCase());
    }

    public final static boolean isNotNull(String str){
        return !isNull(str);
    }

    public final static boolean isNotNull(Object obj){
        return !isNull(obj);
    }

    public final static boolean isNull(Object obj){
        if(obj==null||obj.equals("")) return true;
        return false;
    }

    public final static boolean isNull(Object[] objs){
        if(objs==null||objs.length==0) return true;
        return false;
    }

    public final static boolean isNotNull(Object[] objs){
        return !isNull(objs);
    }

    public final static boolean isNull(Integer integer){
        if(integer==null||integer==0) return true;
        return false;
    }

    public final static boolean isNull(Long longs){
        if(longs==null||longs==0) return true;
        return false;
    }

    public final static boolean isNull(Double dou){
        if(dou ==null|| dou==0) return true;
        return false;
    }

    public final static boolean isNotNull(Double dou){
        return !isNull(dou);
    }

    public final static boolean isNotNull(Long longs){
        return !isNull(longs);
    }

    public final static boolean isNotNull(Integer integer){
        return !isNull(integer);
    }

    public final static String numFormat(Integer integer){
        String str=null;
        if (integer%2 ==0 && integer%10==2){
            str=integer+"nd";
        }else
        if (integer%1==0 && integer%10==1){
            str=integer+"st";
        }else
        if ( integer%10==3){
            str=integer+"rd";
        }else {
            str=integer+"th";
        }
        return str;
    }

    /**
     * list去重复
     * @param list
     * @return
     */
    public static List removeDuplicate(List list){
        List listTemp = new ArrayList();
        for(int i=0;i<list.size();i++){
            if(!listTemp.contains(list.get(i))){
                listTemp.add(list.get(i));
            }
        }
        return listTemp;
    }

    public static Map<String,Object> symbolFormatting(Map<String,Object> map){
        if (isNotNull(map)){
            map.forEach((K,V) ->{
                if (isNotNull(V)){
                    if (V.toString().contains("&")) {
                        map.put(K, V.toString().replace("&", "&amp;"));
                    }
                    if (V.toString().contains("\"\t")) {
                        map.put(K, V.toString().replace("\"\t", "&quot;"));
                    }
                    if (V.toString().contains("<")) {
                        map.put(K, V.toString().replace("<", "&lt;"));
                    }
                    if (V.toString().contains(">")) {
                        map.put(K, V.toString().replace(">", "&gt;"));
                    }
                }
            });
        }
        return map;
    }
}
