package com.yz.crm.common.utils;

import com.yz.crm.common.entity.login.LoginUser;
import net.sf.json.JSONObject;
import java.io.Serializable;

/**
 * Created By 虞嘉俊 195144146@qq.com on 2018/12/21
 */
public class UserContent implements Serializable {

    private static final long serialVersionUID = 2052429389754248307L;

    private static ThreadLocal<Object> loginUserThreadLocal = new ThreadLocal<>();

    /**
     * 获取用户信息
     * @return
     */
    public static Object getUserInfo(){
        return loginUserThreadLocal.get();
    }

    public static void setUserInfo(Object userInfo){
        loginUserThreadLocal.set(userInfo);
    }

    public static void removeUserInfo(){
        loginUserThreadLocal.remove();
    }

    /**
     * 获取用户对象
     * @return
     */
    public static LoginUser getLoginUser(){
        LoginUser loginUser = (LoginUser) JSONObject.toBean(JSONObject.fromObject(loginUserThreadLocal.get()),LoginUser.class);
        return loginUser;
    }

}
