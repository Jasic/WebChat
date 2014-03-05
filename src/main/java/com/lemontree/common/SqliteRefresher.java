package com.lemontree.common;

import cn.tisson.framework.thread.BaseThread;
import com.lemontree.daemon.dbmgr.mapper.CaiPingXiaoLeiMapper;
import com.lemontree.daemon.dbmgr.model.CaiPingXiaoLei;
import com.lemontree.daemon.dbmgr.model.RestaurantInfo;
import com.lemontree.daemon.dbmgr.mybatis.SqliteClient;
import com.lemontree.util.LogUtil;
import org.jasic.util.Asserter;
import org.jasic.util.ExceptionUtil;
import org.jasic.util.TimeUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.lemontree.common.GlobalCaches.CAIPINGXIAOLEI_SQLITE_DATA;
import static com.lemontree.common.GlobalCaches.DB_CACHE_RESTAURANT_INFO;
import static com.lemontree.common.GlobalConstants.*;
import static com.lemontree.common.GlobalVariables.DB_SQLITE_REFRESH_INTERVAL;
import static com.lemontree.common.GlobalVariables.MYBATIS_SQLITE_CONFIG_PATH;

/**
 * 对sqlite数据刷新
 */
public class SqliteRefresher extends BaseThread {

    /**
     * sqlite客户端
     */
    private static final Map<String, SqliteClient> CLIENT_MAP;

    static {
        CLIENT_MAP = new ConcurrentHashMap<String, SqliteClient>();
    }

    public SqliteRefresher() {
        super.setName("[sqlite刷新线程]");

    }

    @Override
    public void run() {

        while (!Thread.interrupted()) {
            try {
                Collection<RestaurantInfo> restaurantInfos = DB_CACHE_RESTAURANT_INFO.values();
                Map<String, List<CaiPingXiaoLei>> caiPingXiaoLeitemp = new HashMap<String, List<CaiPingXiaoLei>>();
                for (RestaurantInfo info : restaurantInfos) {
                    String shopId = info.getShopid();
                    SqliteClient client = getSqliteClient(shopId);
                    CaiPingXiaoLeiMapper caiPingXiaoLeiMapper = client.getSession().getMapper(CaiPingXiaoLeiMapper.class);
                    List<CaiPingXiaoLei> caiPingXiaoLeis = getAllCaiPingXiaoLei(caiPingXiaoLeiMapper);
                    caiPingXiaoLeitemp.put(shopId, caiPingXiaoLeis);
                }
                CAIPINGXIAOLEI_SQLITE_DATA = caiPingXiaoLeitemp;
            } catch (Exception e) {

                LogUtil.getLogger(getClass()).error(ExceptionUtil.getStackTrace(e));
            }
            TimeUtil.sleep(DB_SQLITE_REFRESH_INTERVAL);

        }
    }

    /**
     * 刷新菜品小类
     *
     * @param mapper
     */
    private List<CaiPingXiaoLei> getAllCaiPingXiaoLei(CaiPingXiaoLeiMapper mapper) {

        List<CaiPingXiaoLei> list = mapper.getAll();
        return list;
    }

    /**
     * 根据shopid获取相对应的sqlite数据库client
     *
     * @param shopId
     * @return
     */
    private static SqliteClient getSqliteClient(String shopId) {

        Asserter.notNull("shopId不能为null");
        SqliteClient client = CLIENT_MAP.get(shopId);

        if (null == client) {
            String baseDir = RESTAURANT_BASE_DIR;
            baseDir += "/" + shopId;
            String dbDir = baseDir + "/" + RESTAURANT_SOURCE_TYPE_DB + "/" + RESTAURANT_SOURCE_DB_NAME;
            client = new SqliteClient(MYBATIS_SQLITE_CONFIG_PATH, "jdbc:sqlite:" + dbDir);

            CLIENT_MAP.put(shopId, client);
        }

        return client;
    }
}
