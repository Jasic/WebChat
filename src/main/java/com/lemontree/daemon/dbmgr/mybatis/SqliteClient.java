package com.lemontree.daemon.dbmgr.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * Author Jasic
 * 使用SqlSessionTemplate自动打开和关闭session
 */
public class SqliteClient extends MyBatisBaseClient {

    /**
     * sqlite数据库文件位置
     */
    private String dbUrl;

    /**
     * 与sqlite相关的mybatis配置文件路径
     */
    private String resource;


    /**
     * 创建sqlite端
     *
     * @param resource 指定mybatis对sqlite的配置文件
     * @param dbUrl    sqlite的数据库文件
     * @throws IOException
     */
    public SqliteClient(String resource, String dbUrl) {
        super();
        this.dbUrl = dbUrl;
        this.resource = resource;
        Reader reader = getReader(resource, dbUrl);
        super.factory = new SqlSessionFactoryBuilder().build(reader);
    }


    public Reader getReader(String path, String dbUrl) {

        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuffer sb = new StringBuffer();

            String line = bufferedReader.readLine();
            while (line != null) {
                sb.append(line);
                line = bufferedReader.readLine();
            }
            String config = sb.toString().replace("{url}", dbUrl);
            reader = new StringReader(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reader;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getResource() {
        return resource;
    }
}
