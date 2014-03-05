package com.lemontree.test;

import com.alibaba.druid.support.json.JSONUtils;
import com.lemontree.daemon.dbmgr.mapper.CaiPingMapper;
import com.lemontree.daemon.dbmgr.model.CaiPing;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

/**
 * Author Jasic
 * Date 14-2-22.
 */
public class TestSqlMybatis {

    public static void main(String[] args) throws IOException {
        String resource = "config/mybatis-sqlite.xml";
        Reader reader = Resources.getResourceAsReader(resource);

        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer sb = new StringBuffer();

        String line = bufferedReader.readLine();
        while (line != null) {
            sb.append(line);
            line = bufferedReader.readLine();
        }

        String config = sb.toString().replace("{url}", "jdbc:sqlite:/opt/wspace/employ/WebChat/doc/lemontree.db");
        reader = new StringReader(config);

        System.out.println(config);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);

        SqlSession session = factory.openSession();
        CaiPingMapper caiPingMapper = session.getMapper(CaiPingMapper.class);

        Integer count = caiPingMapper.countAll();
        System.out.println(count);


        List<CaiPing> caiPings =caiPingMapper.getAll();
//        caiPings = session.selectList("com.lemontree.daemon.dbmgr.mapper.CaiPingMapper.getAll");
        System.out.println((caiPings));
        session.commit();
        session.close();


    }


//
//    <select id="getAll" resultMap="BaseResultMap" resultType="list">
//    select
//            <include refid="Base_Column_List" />
//            from CaiPing
//            </select>
//    <select id="countAll" resultType="java.lang.Integer">
//    select count(*) from CaiPing
//    </select>
}
