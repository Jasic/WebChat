package com.lemontree.daemon.dbmgr.mapper.service;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 业务层操作基类
 *
 * @author BrainstorM
 */
public class BaseManager {

    // 实例标志
    private boolean instanceFlag;

    // 连接,保存在线程中
    private final ThreadLocal<Connection> localConnection = new ThreadLocal<Connection>();

    /**
     * 获取实例标志
     *
     * @return
     */
    protected final boolean getInstanceFlag() {
        return this.instanceFlag;
    }

    /**
     * 设置实例标志
     *
     * @param instanceFlag
     */
    protected final void setInstanceFlag(boolean instanceFlag) {
        this.instanceFlag = instanceFlag;
    }

    /**
     * 获取自动事务管理的数据库连接
     *
     * @return
     * @throws java.sql.SQLException
     */
    protected final Connection getAutoTransactionConnection() throws SQLException {
        Connection con = this.localConnection.get();

        if (!getInstanceFlag()) {
            throw new SQLException("错误请求, 请使用ServiceFactory.getInstance(Class clazz)获取业务逻辑实例");
        }

        if (con == null) {
            throw new SQLException("获取数据库连接失败");
        }

        return con;
    }

    /**
     * 设置自动事务管理的数据库连接
     *
     * @param con
     */
    protected final void setAutoTransactionConnection(Connection con) {
        this.localConnection.set(con);
    }

}
