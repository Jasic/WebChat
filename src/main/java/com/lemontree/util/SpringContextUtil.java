package com.lemontree.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 加载Spring配置文件时，如果Spring配置文件中所定义的Bean类实现了ApplicationContextAware 接口，那么在加载Spring配置文件时，会自动调用ApplicationContextAware 接口中的
 * public void setApplicationContext(ApplicationContext context) throws BeansException
 * 方法，获得ApplicationContext 对象。
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext; // Spring应用上下文环境

    /*
     * 实现了ApplicationContextAware 接口，必须实现该方法；
     *通过传递applicationContext参数初始化成员变量applicationContext
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) applicationContext.getBean(name);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }


}