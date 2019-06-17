package com.yz.crm.common.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 缓存切面实现
 * Created By 虞嘉俊 195144146@qq.com on 2019/6/4
 */
@Aspect
@Component
public class CacheAOP {

    @Autowired
    RedisTemplate redisTemplate;

    @Pointcut("@annotation(com.yz.crm.common.component.Cache)")
    public void cacheAnnotation() {
    }

    @Around("cacheAnnotation() && @annotation(cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint, Cache cache) {
        String className = proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName(); //类名
        System.out.println("类名："+className);
        String method = proceedingJoinPoint.getSignature().getName(); //获取方法名称
        System.out.println("方法名："+method);
        String[] key = cache.value();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
