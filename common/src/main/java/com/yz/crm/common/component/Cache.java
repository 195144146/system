package com.yz.crm.common.component;

import org.springframework.core.annotation.AliasFor;
import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 缓存注解
 * 用于方法上，添加和删除缓存
 * Created By 虞嘉俊 195144146@qq.com on 2019/6/4
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Cache {

    /**
     * 方法涉及的表名称
     * @return
     */
    @AliasFor("value")
    String[] tableName() default {};

    /**
     * 方法涉及的表名称
     * @return
     */
    @AliasFor("tableName")
    String[] value() default {};

    /**
     * 自定义键名称
     * @return
     */
    String key();

    /**
     * 缓存过期时间 默认：30
     */
    int timeOut() default 30;

    /**
     * 缓存过期单位 默认：分钟
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.MINUTES;

    /**
     * 持久化
     */
    boolean permanent() default false;

    /**
     * 清除缓存标签 否
     * @return
     */
    boolean Clear() default false;
}
