package com.lemontree.daemon.dbmgr.mapper.service;

import net.sf.cglib.proxy.Enhancer;

/**
 * 业务工厂类
 *
 * @author BrainstorM
 */
public class ServiceFactory {

    /**
     * 获取指定业务类
     *
     * @param <M>
     * @param clazz
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <M extends BaseManager> M getInstance(Class<M> clazz) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new TransactionInterceptor());

        M t = (M) enhancer.create();
        t.setInstanceFlag(true);

        return t;
    }
}
