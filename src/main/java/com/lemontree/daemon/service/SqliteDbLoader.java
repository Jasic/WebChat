package com.lemontree.daemon.service;

import cn.tisson.framework.config.ConfigHandler;
import cn.tisson.framework.dao.jdbc.MappingConvertor;
import cn.tisson.framework.exception.MappingHandleException;
import com.lemontree.common.GlobalVariables;
import com.lemontree.daemon.dbmgr.model.SqlitePojo;
import org.apache.ibatis.session.SqlSession;
import org.jasic.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * 无线数据生成器
 */
public class SqliteDbLoader {

    private static final Logger logger = LoggerFactory.getLogger(SqliteDbLoader.class);

    private Connection conn;

    private String inDir;

    // 需要导出的表结构，KEY为表名、VALUE为自动名称
    private Map<String, List<String>> tblInfos = new LinkedHashMap<String, List<String>>();

    public String getInDir() {
        return inDir;
    }

    public void setInDir(String inDir) {
        this.inDir = inDir;
    }

    private SqliteDbLoader() {
        // 全局参数表
        List<String> attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("ID");
        attrs.add("Name");
        attrs.add("StrVal");
        attrs.add("StrVal2");
        attrs.add("StrVal3");
        attrs.add("IntVal");
        attrs.add("BoolVal");
        attrs.add("DoubleVal");
        attrs.add("DateVal");
        tblInfos.put("QuanJuCanShu", attrs);

        // 员工信息
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("StaffID");
        attrs.add("StaffName");
        tblInfos.put("XiTongYongHu", attrs);

        // 台区
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("ZuoTaiQuYuID");
        attrs.add("ZuoTaiQuYuName");
        attrs.add("ZuoTaiQuYuName2");
        attrs.add("ZuoTaiQuYuName3");
        attrs.add("ShowOrder");
        tblInfos.put("ZuoTaiQuYu", attrs);
        // 桌台
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("ZuoTaiID");
        attrs.add("ZuoTaiName");
        attrs.add("ZuoTaiName2");
        attrs.add("ZuoTaiName3");
        attrs.add("TaiQu");
        tblInfos.put("ZuoTai", attrs);
        // 菜品大类
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("CaiPingDaiLeiID");
        attrs.add("CaiPingDaiLeiName");
        attrs.add("CaiPingDaiLeiName2");
        attrs.add("CaiPingDaiLeiName3");
        attrs.add("ShowOrder");
        attrs.add("Hide");
        attrs.add("HideInPad");
        attrs.add("BuJiChengTYZF");
        attrs.add("NoShowZuoFa");
        tblInfos.put("CaiPingDaiLei", attrs);
        // 菜品小类
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("CaiPingXiaoLeiID");
        attrs.add("CaiPingXiaoLeiName");
        attrs.add("CaiPingXiaoLeiName2");
        attrs.add("CaiPingXiaoLeiName3");
        attrs.add("ShowOrder");
        attrs.add("Hide");
        attrs.add("DaiLei");
        attrs.add("HideInPad");
        attrs.add("BuJiChengTYZF");
        attrs.add("BuJiChengDLZF");
        attrs.add("NoShowZuoFa");
        tblInfos.put("CaiPingXiaoLei", attrs);
        // 菜品
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("CaiPingID");
        attrs.add("CaiPingName");
        attrs.add("CaiPingName2");
        attrs.add("CaiPingName3");
        attrs.add("JiaGe");
        attrs.add("MoRenDanWei");
        attrs.add("MoRenDanWei2");
        attrs.add("MoRenDanWei3");
        attrs.add("ShowOrder");
        attrs.add("YinCan");
        attrs.add("JianJie");
        attrs.add("JianJie2");
        attrs.add("JianJie3");
        attrs.add("XiaoLei");
        attrs.add("YinCanInPad");
        attrs.add("FuZhuID");
        attrs.add("PingYing");
        attrs.add("BuJiChengTYZF");
        attrs.add("BuJiChengDLZF");
        attrs.add("BuJiChengXLZF");
        attrs.add("NoShowZuoFa");
        attrs.add("ShiJia");
        attrs.add("CanModName");
        tblInfos.put("CaiPing", attrs);

        // 菜品会员价格
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("ID");
        attrs.add("Name");
        attrs.add("Cai");
        attrs.add("MemberType");
        attrs.add("Price");
        attrs.add("Unit");
        tblInfos.put("MN_CaiPinAndMember", attrs);
        // 菜品套餐
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("ID");
        attrs.add("Name");
        attrs.add("MainCai");
        attrs.add("SubCai");
        attrs.add("Unit");
        attrs.add("Amount");
        attrs.add("MaxAmount");
        attrs.add("Price");
        tblInfos.put("MN_CaiAndSubCai", attrs);
        // 菜品多单位
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("ID");
        attrs.add("DanWeiMing");
        attrs.add("BiLv");
        attrs.add("JiaGe");
        attrs.add("ChengBenJiaGe");
        attrs.add("XiaoShouTiCheng");
        attrs.add("NoBilling");
        attrs.add("Def");
        attrs.add("DanWeiMing2");
        attrs.add("DanWeiMing3");
        attrs.add("CaiP");
        tblInfos.put("CPDanWeiJiaGe", attrs);
        // 做法类别
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("ID");
        attrs.add("Name");
        tblInfos.put("ZuoFaLeiBie", attrs);
        // 菜品做法
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("CaiPingZuoFaID");
        attrs.add("CaiPingZuoFaName");
        attrs.add("CaiPingZuoFaName2");
        attrs.add("CaiPingZuoFaName3");
        attrs.add("LeiBie");
        attrs.add("CaiDaLei");
        attrs.add("CaiLei");
        attrs.add("CaiP");
        attrs.add("PingYing");
        attrs.add("JiaGe");
        attrs.add("ChengBenJiaGe");
        attrs.add("ShiFuoChenYuShuLiang");
        attrs.add("MulSelfAmount");
        tblInfos.put("CaiPingZuoFa", attrs);

        // 退菜原因
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("TuiCaiYanYingID");
        attrs.add("TuiCaiYanYingName");
        attrs.add("TuiCaiYanYingName2");
        attrs.add("TuiCaiYanYingName3");
        tblInfos.put("TuiCaiYanYing", attrs);

        // 客户评价
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("ID");
        attrs.add("Name");
        attrs.add("Name2");
        attrs.add("Name3");
        tblInfos.put("WL_Appraise", attrs);

        // 客户评价项
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("ID");
        attrs.add("Name");
        attrs.add("Name2");
        attrs.add("Name3");
        attrs.add("Appraise");
        tblInfos.put("WL_AppraiseItem", attrs);

        // 字典
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("ID");
        attrs.add("Type");
        attrs.add("StrKey");
        attrs.add("Lan1");
        attrs.add("Lan2");
        attrs.add("Lan3");
        attrs.add("Remark");
        tblInfos.put("WL_StrResource", attrs);

        // 电子菜谱一级目录
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("ID");
        attrs.add("Name");
        attrs.add("Name2");
        attrs.add("Name3");
        attrs.add("Hide");
        attrs.add("ShowOrder");
        tblInfos.put("WL_FoodSuperType", attrs);
        // 电子菜谱二级目录
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("ID");
        attrs.add("Name");
        attrs.add("Name2");
        attrs.add("Name3");
        attrs.add("Hide");
        attrs.add("ShowOrder");
        attrs.add("FoodSuperType");
        tblInfos.put("WL_FoodType", attrs);
        // 电子菜谱页面
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("ID");
        attrs.add("Name");
        attrs.add("Hide");
        attrs.add("ShowOrder");
        attrs.add("FoodType");
        attrs.add("PageType");
        tblInfos.put("WL_FoodPage", attrs);
        // 电子菜谱页面中的菜品
        attrs = new Vector<String>();
        attrs.add("PID");
        attrs.add("ID");
        attrs.add("Name");
        attrs.add("Hide");
        attrs.add("ShowOrder");
        attrs.add("FoodPage");
        attrs.add("CaiP");
        tblInfos.put("WL_Food", attrs);
    }


    /**
     * 重建数据库sqlite数据库
     *
     * @return
     */
    private Boolean crtDb() {
        if (inDir == null) {
            logger.error("please set outDir");
            return false;
        }
        File dir = new File(inDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File dbFile = new File(String.format("%s/lemontree.db", inDir));
        System.out.println(dbFile);
        if (!dbFile.exists()) {
            return false;
        }
        try {
            Class.forName("org.sqlite.JDBC");
            String url = String.format("jdbc:sqlite:%s/lemontree.db", inDir);
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
        } catch (Exception e) {
            logger.error(ExceptionUtil.getStackTrace(e));
            return false;
        }
        return true;
    }

    /**
     * 获取所有表名
     *
     * @return
     */
    private List<String> getTables() {

        String sql = "SELECT name FROM sqlite_master WHERE type='table' ORDER BY name";
        List<String> list = new ArrayList<String>();

        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("name");
                list.add(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<SqlitePojo> exTblData(String tblName, List<String> attrs) {
        String attrSql = "";
        for (String attrName : attrs) {
            if (attrSql.equals("")) {
                attrSql = String.format("%s", attrName);
            } else {
                attrSql = String.format("%s, %s", attrSql, attrName);
            }
        }

        String selectSql = String.format("SELECT %s\n", attrSql);
        selectSql += String.format("FROM %s", tblName);


        List<SqlitePojo> tblDataList = null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(selectSql);

            tblDataList = convertToEitity(rs, "com.lemontree.daemon.dbmgr.model." + tblName);
        } catch (Exception e) {
            logger.error(ExceptionUtil.getStackTrace(e) + " tableName=" + tblName);

        }
        return tblDataList;
    }

    /**
     * 导出插入数据的sql语句
     *
     * @param tblName
     * @param attrs
     */
    private List<String> exportInsertTbl(String tblName, List<String> attrs)
            throws Exception {

        List<String> sqls = new ArrayList<String>();
        int columnCount = 0;
        String attrSql = "";
        for (String attrName : attrs) {
            if (attrSql.equals("")) {
                attrSql = String.format("%s", attrName);
            } else {
                attrSql = String.format("%s, %s", attrSql, attrName);
            }
            columnCount++;
        }

        String selectSql = String.format("SELECT %s\n", attrSql);
        selectSql += String.format("FROM %s", tblName);

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(selectSql);


        List<Object[]> data = new ArrayList<Object[]>();
        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int index = 0; index < columnCount; index++) {
                row[index] = rs.getObject(index + 1);
                data.add(row);
            }
        }
        for (Object[] v : data) {
            String insertSql = String.format("INSERT INTO %s(%s) ", tblName, attrSql);
            insertSql += String.format("VALUES(%s);\n", getValueStr(v));
            sqls.add(insertSql);
        }

        return sqls;
    }


    /**
     * 右边数据转换成实体列表
     *
     * @param rs
     * @return
     * @throws SQLException
     * @throws cn.tisson.framework.exception.MappingHandleException
     */
    private final List<SqlitePojo> convertToEitity(ResultSet rs, String className) throws SQLException, MappingHandleException, ClassNotFoundException {
        ResultSetMetaData rsm = rs.getMetaData();

        List<SqlitePojo> resultList = new ArrayList<SqlitePojo>();

        SqlitePojo vo = null;

        Class entityClass = Class.forName(className);

        if (!entityClass.getSuperclass().equals(SqlitePojo.class)) {
            throw new ClassCastException(className + " is not son class of SqlitePojo");
        }
        try {
            int ii = 0;

            while (rs.next()) {
                System.out.println("----------" + ii++);
                vo = (SqlitePojo) entityClass.newInstance();
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    String variableName = MappingConvertor.toVariableName(rsm.getColumnName(i));
                    Object variableValue = getFieldValue(rs, entityClass, i, variableName);
                    System.out.println("variableName:--" + variableName + "\nvariableValue---" + variableValue);
                    String methodName = MappingConvertor.toSetMethodName(variableName);
                    Method method = entityClass.getMethod(methodName, new Class[]{entityClass.getDeclaredField(variableName).getType()});
                    method.invoke(vo, new Object[]{variableValue});
                }

                resultList.add(vo);
            }

        } catch (Exception e) {
            throw new MappingHandleException("-110001", "数据实体转换异常\n" + ExceptionUtil.getStackTrace(e));
        }

        return resultList;
    }


    /**
     * 从游标中获取数据
     *
     * @param rs
     * @param clazz
     * @param count
     * @param variableName
     * @return
     * @throws SQLException
     * @throws Exception
     */
    private final Object getFieldValue(ResultSet rs, Class<?> clazz, int count, String variableName) throws SQLException, Exception {

        if (rs == null || variableName == null || variableName.length() <= 0 || clazz == null)
            return null;

        Object fieldValue = null;

        if (variableName != null) {
            if ("rownum".equals(variableName)) {
                fieldValue = new Long(rs.getLong(count));
            } else if ("rownum_".equals(variableName)) {
                fieldValue = new Long(rs.getLong(count));
            } else if ("count_".equals(variableName)) {
                fieldValue = new Long(rs.getLong(count));
            } else {
                String classType = clazz.getDeclaredField(variableName).getType().getSimpleName();

                if (classType.equals("byte[]")) {
                    fieldValue = rs.getBytes(count);
                } else if (classType.equals("Integer")) {
                    fieldValue = new Integer(rs.getInt(count));
                } else if (classType.equals("Long")) {
                    fieldValue = new Long(rs.getLong(count));
                } else if (classType.equals("Float")) {
                    fieldValue = rs.getFloat(count);
                } else if (classType.equals("Double")) {
                    fieldValue = rs.getDouble(count);
                } else if (classType.equals("BigDecimal")) {
                    fieldValue = rs.getBigDecimal(count);
                } else if (classType.equals("String")) {
                    fieldValue = rs.getString(count);
                } else if (classType.equals("Date")) {
                    java.sql.Timestamp timestamp = rs.getTimestamp(count);
                    if (timestamp != null) {
                        fieldValue = new java.util.Date(timestamp.getTime());
                    }
                } else {
                    fieldValue = rs.getString(count);
                }
            }
        }

        return fieldValue;
    }


    /**
     * 获取表示字段值的sql
     *
     * @param fields
     * @return
     */
    private String getValueStr(Object[] fields) {
        if (fields == null || fields.length == 0) {
            return null;
        }
        String valueDscrip = "";
        for (Object v : fields) {
            if (v == null) {
                v = "null";
            } else if (v instanceof Boolean) {
                Boolean b = (Boolean) v;
                if (b) {
                    v = "1";
                } else {
                    v = "0";
                }
            } else if (v instanceof String || v instanceof Date
                    || v instanceof Enum) {
                v = String.format("'%s'", String.valueOf(v).replace("'", "''"));
            } else {
                v = String.valueOf(v).replace("'", "''");
            }
            valueDscrip += String.format(", %s", v);
        }
        valueDscrip = valueDscrip.substring(1, valueDscrip.length());
        return valueDscrip;
    }


    /**
     * 根据目录的数据库文件获取数据（默认为lemontree.db）
     *
     * @param dbDir
     * @return
     */
    public static Map<String, List<SqlitePojo>> getDataByDbDir(String dbDir) {
        SqliteDbLoader sync = new SqliteDbLoader();
        sync.setInDir(dbDir);

        boolean status = sync.crtDb();
        logger.info("连接sqlite数据库" + (status ? "成功" : "失败"));
        Map<String, List<SqlitePojo>> sqlMap = new HashMap<String, List<SqlitePojo>>();
        if (status) {
            List<String> tableNames = sync.getTables();

            for (String tableName : tableNames) {
                List<String> fields = sync.tblInfos.get(tableName);
                List<SqlitePojo> sqlitePojos = sync.exTblData(tableName, fields);
                sqlMap.put(tableName, sqlitePojos);
            }
        }
        return sqlMap;
    }


    public static void main(String[] args) throws Exception {
        ConfigHandler.loadConfigWithoutDB(GlobalVariables.class);

        SqliteDbLoader sync = new SqliteDbLoader();
        sync.setInDir("/opt/wspace/employ/WebChat/doc");

        System.out.println("连接sqlite数据库" + (sync.crtDb() ? "成功" : "失败"));
        List<String> tableNames = sync.getTables();


        SqlSession sqlSession;
        for (String tableName : tableNames) {
            List<String> fields = sync.tblInfos.get(tableName);

//            if (tableName.equals("QuanJuCanShu"))
            {
//                System.out.println(sync.exportInsertTbl(tableName, fields));
                List<SqlitePojo> sqlitePojos = sync.exTblData(tableName, fields);
                System.out.println(sqlitePojos + "\n");
            }
        }
    }
}
