package com.yz.crm.web;

import com.yz.crm.common.utils.MapUtils;
import com.yz.crm.common.utils.UserContent;
import com.yz.crm.web.service.client.system.IResourceService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * 拦截器
 * Created By 虞嘉俊 195144146@qq.com on 2018/12/13
 */
@Configuration
public class Interceptor implements HandlerInterceptor {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    IResourceService resourceService;

//    private TransportClient client = (TransportClient) SpringCurrentContext.getBean("client");

    private static final String BTOKENKEY = "yzSystem_btoken_";
    private static final String CTOKENKEY = "yzSystem_ctoken_";
    private static final String S_PUBLICINTERFACE  = "yzSystem_publicInterface";

    /**
     * 通过token获取接口列表，并且重置token过期时间
     * @param prefix 前缀
     * @param token
     * @return
     */
    private String getInterfaceS(String prefix, String token){
        String interfaceS = stringRedisTemplate.opsForValue().get(prefix+token);
        if (interfaceS != null && !"".equals(interfaceS)){
            stringRedisTemplate.expire(prefix+token,30, TimeUnit.MINUTES);
        }
        return interfaceS;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (true)
        return true;
        if(httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name()))
            return true;
        String url = httpServletRequest.getRequestURI(); //请求路径
        String token = httpServletRequest.getHeader("token"); //请求携带token
        String interfaceS = ""; //授权接口
        if(httpServletRequest.getHeader("source") != null && "web".equals(httpServletRequest.getHeader("source").trim())){
            interfaceS = getInterfaceS(BTOKENKEY,token);
        }
        boolean isTokenExpired = false; //token过期标志
        if(interfaceS != null && !"".equals(interfaceS)){
            JSONObject jsonObject = JSONObject.fromObject(interfaceS);
            UserContent.setUserInfo(jsonObject);
            JSONArray interfaceArray = (JSONArray) jsonObject.get("resourceCode");
            for (int i = 0; i < interfaceArray.size(); i++){
                if(((JSONObject) interfaceArray.get(i)).get("path").equals(url))
                    return true;
            }
        } else {
            isTokenExpired = true;
        }
        //所有权限都开放的接口
        List<String> interfaceList = resourceService.getPublicInterface();
        if(interfaceList.contains(url)) {
            return true;
        }
        returnFailure(httpServletResponse,httpServletRequest.getHeader("Origin"),isTokenExpired);
        return false;
    }

    /**
     * 返回错误信息
     * @param response
     * @param location
     * @param isTokenExpired
     */
    private void returnFailure(HttpServletResponse response, String location, boolean isTokenExpired){
        JSONObject jsonObject = JSONObject.fromObject(MapUtils.getReturnFailureMap(isTokenExpired?"登陆超时,请重新登陆!":"权限不足,请与管理员联系!"));
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Origin",location);
        response.setHeader("Vary","origin");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(jsonObject.toString());
            out.flush();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            if(out != null){
                out.close();
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
