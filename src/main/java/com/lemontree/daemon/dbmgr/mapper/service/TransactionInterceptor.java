package com.lemontree.daemon.dbmgr.mapper.service;

import java.lang.reflect.Method;
import java.sql.Connection;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.tisson.framework.annotation.Transaction;
import cn.tisson.framework.dao.jdbc.ConnectionPool;
import cn.tisson.framework.exception.HandleException;

/**
 * 事务处理切面类
 *
 * @param <M>
 * @author BrainstorM
 */
public class TransactionInterceptor<M extends BaseManager> implements MethodInterceptor {

    // 日志处理
    private static final Logger logger = LoggerFactory.getLogger(TransactionInterceptor.class);

    /**
     * 注入函数
     *
     * @param obj
     * @param method
     * @param args
     * @param proxy
     * @return
     */
    @SuppressWarnings("unchecked")
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        boolean autoTransactionFlag = true;
        boolean readOnlyFlag = false;

        Transaction secured = method.getAnnotation(Transaction.class);

        if (secured != null && "none".equalsIgnoreCase(secured.value())) {
            autoTransactionFlag = false;
        }

        if (secured != null && "readOnly".equalsIgnoreCase(secured.value())) {
            readOnlyFlag = true;
        }

        Object result = null;

        if (autoTransactionFlag) {

            Connection con = ConnectionPool.getConnection();

            ((M) obj).setAutoTransactionConnection(con);

            try {
                result = proxy.invokeSuper(obj, args);
                if (!readOnlyFlag) {
                    con.commit();
                }
            } catch (Exception e) {
                // TODO: handle exception
                if (!readOnlyFlag) {
                    con.rollback();
                }

                if (!(e instanceof HandleException)) {
                    logger.info("Exception: ", e);
                }
                throw e;
            } finally {
                ConnectionPool.closeConnection(con);
            }

        } else {
            result = proxy.invokeSuper(obj, args);
        }

        return result;
    }

}
