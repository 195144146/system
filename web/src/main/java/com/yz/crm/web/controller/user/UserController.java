package com.yz.crm.web.controller.user;

import com.yz.crm.common.entity.system.SysUser;
import com.yz.crm.common.utils.RSAUtil;
import com.yz.crm.common.utils.ValiDataUtils;
import com.yz.crm.web.service.client.IUserService;
import com.yz.crm.web.utils.ReturnResponseEntityUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author: 虞嘉俊 195144146@qq.com
 * @create: 2018-04-11 16:36
 * @description: 用户Controller
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    private static final String S_TOKEN  = "yzSystem_token";
    private static final String PUBLICKEY = "yzSystem_PublicKey_";
    private static final String PRIVATEKEY = "yzSystem_privateKey_";

    @RequestMapping("/index")
    public String login(Map<String,Object> param){
        List list = new ArrayList();
        SysUser user = new SysUser();
        user.setPassWord("fdasfads");
        list.add(user);
        List<SysUser> rtl = userService.saveUser(list);
        return "index";
    }

    @RequestMapping("/select")
    public String selectUser(){
        List<SysUser> rtl = userService.selectUser(new SysUser());
        return "index";
    }

    /**
     * 获取公钥
     * @param param
     * @param header
     * @return
     */
    @RequestMapping(value = "/getKey", method = RequestMethod.POST, produces = "application/json;charset=UTF-8;")
    public ResponseEntity getKey(@RequestBody Map<String,Object> param , @RequestHeader Map<String,Object> header) {
        try {
            JSONObject jsonObject = new JSONObject();
            if (header.containsKey(S_TOKEN) && ValiDataUtils.isNotNull(header.get(S_TOKEN).toString())){
                String token = header.get(S_TOKEN).toString();//获取Token
                String publicKey = redisTemplate.opsForValue().get(PUBLICKEY+token);//从缓存中获取公钥
                if (publicKey == null){
                    String uuid = UUID.randomUUID().toString().replaceAll("-","");
                    Map<String,Object> rsaMap = RSAUtil.generateKeyPair();//创建RSA公钥和私钥
                    publicKey = RSAUtil.getPublicKey(rsaMap);//获取base64公钥
                    String privateKey = RSAUtil.getPrivateKey(rsaMap);//获取base64私钥
                    redisTemplate.opsForValue().set(PRIVATEKEY+uuid,privateKey,30, TimeUnit.MINUTES);//将私钥存入缓存
                    redisTemplate.opsForValue().set(PUBLICKEY+uuid,publicKey,30,TimeUnit.MINUTES);//将公钥存入缓存
                }
                jsonObject.put("publicKey",publicKey);
            }else {
                String uuid = UUID.randomUUID().toString().replaceAll("-","");
                Map<String,Object> rsaMap = RSAUtil.generateKeyPair();//创建RSA公钥和私钥
                String publicKey = RSAUtil.getPublicKey(rsaMap);//获取base64公钥
                String privateKey = RSAUtil.getPrivateKey(rsaMap);//获取base64私钥
                redisTemplate.opsForValue().set(PRIVATEKEY+uuid,privateKey,30,TimeUnit.MINUTES);//将私钥存入缓存
                redisTemplate.opsForValue().set(PUBLICKEY+uuid,publicKey,30,TimeUnit.MINUTES);//将公钥存入缓存
                jsonObject.put("publicKey",publicKey);
                jsonObject.put(S_TOKEN,uuid);
            }
            jsonObject.put("result", true);
            return ReturnResponseEntityUtil.success(jsonObject);
        }catch(Exception ex){
            return ReturnResponseEntityUtil.failure(ex);
        }
    }
}
