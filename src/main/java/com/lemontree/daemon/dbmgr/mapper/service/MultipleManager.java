package com.lemontree.daemon.dbmgr.mapper.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.tisson.framework.annotation.Resource;

/**
 * 复杂业务基类
 *
 * @author BrainstorM
 */
public class MultipleManager extends BaseManager {

    // 日志处理
    private static final Logger logger = LoggerFactory.getLogger(MultipleManager.class);

    /**
     * 构造函数,初始化
     */
    protected MultipleManager() {
        Class<?> clazz = this.getClass().getSuperclass();

        if (clazz.getName().equals(MultipleManager.class.getName())) {
            clazz = this.getClass();
        }

        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            Annotation annotation = field.getAnnotation(Resource.class);

            if (annotation != null) {
                try {
                    field.setAccessible(true);
                    field.set(this, field.getType().newInstance());
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    logger.info("MultipleManager初始化失败: ", e);
                }
            }
        }
    }

}
