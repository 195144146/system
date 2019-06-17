package com.yz.crm.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring ApplicationContext帮助类
 * Created By 虞嘉俊 195144146@qq.com on 2019/5/21
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 获取SpringContext
     * @return applicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过bean名称获取Bean
     * @param beanName bean名称
     * @return Bean
     * @throws BeansException
     */
    public static Object getBean(String beanName) throws BeansException {
        return applicationContext.getBean(beanName);
    }
}
