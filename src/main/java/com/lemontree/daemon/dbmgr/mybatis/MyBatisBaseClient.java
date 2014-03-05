package com.lemontree.daemon.dbmgr.mybatis;

import com.lemontree.util.LogUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasic.util.Asserter;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.Reader;

/**
 * Author Jasic
 * MyBatis 基础Client
 */
public abstract class MyBatisBaseClient {

    private static Logger logger = LogUtil.getLogger(MyBatisBaseClient.class);

    protected SqlSessionFactory factory;

    private SqlSession session;

    MyBatisBaseClient() {

    }

    /**
     * 根据指定的配置文件路径初始化
     *
     * @param resource
     * @throws IOException
     */
    public MyBatisBaseClient(String resource) throws IOException {
        this(Resources.getResourceAsReader(resource));
    }

    /**
     * 根据Reader初始化
     *
     * @param reader
     */
    public MyBatisBaseClient(Reader reader) {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        this.factory = builder.build(reader);
    }

    /**
     * 获取session
     *
     * @return
     */
    public SqlSession getSession() {
        Asserter.notNull(factory, "请使用带有参数的MyBatisBaseClient构造函数初始化...");
        return session == null ? (session = new SqlSessionTemplate(factory)) : session;
//        return session == null ? (session = new SqlSessionWrapped(factory)) : session;
    }


}
