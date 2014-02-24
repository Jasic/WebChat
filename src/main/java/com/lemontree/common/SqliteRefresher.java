package com.lemontree.common;

import cn.tisson.framework.thread.BaseThread;
import cn.tisson.framework.utils.StringUtils;
import com.lemontree.daemon.dbmgr.model.CaiPing;
import com.lemontree.daemon.dbmgr.model.CaiPingXiaoLei;
import com.lemontree.daemon.dbmgr.model.RestaurantInfo;
import com.lemontree.daemon.dbmgr.model.SqlitePojo;
import com.lemontree.daemon.service.SqliteDbLoader;
import org.jasic.util.TimeUtil;

import java.util.*;

/**
 * 对sqlite数据刷新
 */
public class SqliteRefresher extends BaseThread {

    public SqliteRefresher() {

    }

    @Override
    public void run() {

        try {
            Collection<RestaurantInfo> restaurantInfos = GlobalCaches.DB_CACHE_RESTAURANT_INFO.values();
            String baseDir = GlobalConstants.RESTAURANT_BASE_DIR;
            Map<String, Map<String, List<SqlitePojo>>> temp = new HashMap<String, Map<String, List<SqlitePojo>>>();
            for (RestaurantInfo info : restaurantInfos) {
                String shopId = info.getShopid();
                baseDir += "/" + shopId;
                String dbDir = baseDir + "/" + GlobalConstants.RESTAURANT_SOURCE_TYPE_DB;
                Map<String, List<SqlitePojo>> dataMap = SqliteDbLoader.getDataByDbDir(dbDir);
                logicSet(dataMap);

                temp.put(shopId, dataMap);

            }
            GlobalCaches.DB_CACHE_RESTAURANT_SQLITE_DATA = temp;
            TimeUtil.sleep(GlobalVariables.DB_SQLITE_REFRESH_INTERVAL);
        } catch (Exception e) {

        }
    }

    /**
     * 设置数据库逻辑关联总入口
     *
     * @param cache
     */
    private void logicSet(Map<String, List<SqlitePojo>> cache) {
        logicSetCaiPing(cache);
    }

    /**
     * 设置菜品关联
     *
     * @param cache
     */
    private void logicSetCaiPing(Map<String, List<SqlitePojo>> cache) {
        List<SqlitePojo> CaiPings = cache.get(CaiPing.class.getSimpleName());
        List<SqlitePojo> CaiPingXiaoLeis = cache.get(CaiPingXiaoLei.class.getSimpleName());

        Map<Integer, CaiPingXiaoLei> caiPingXiaoLeiMap = new HashMap<Integer, CaiPingXiaoLei>();
        for (SqlitePojo sqlitePojo : CaiPingXiaoLeis) {
            CaiPingXiaoLei caiPingXiaoLei = (CaiPingXiaoLei) sqlitePojo;
            caiPingXiaoLeiMap.put(caiPingXiaoLei.getPID(), caiPingXiaoLei);
        }

        for (SqlitePojo sqlitePojo : CaiPings) {
            CaiPing caiPing = (CaiPing) sqlitePojo;

            Integer caipingXiaoLeiId = (StringUtils.isNumeric(caiPing.getXiaoLei()) ? Integer.valueOf(caiPing.getXiaoLei()) : null);
            CaiPingXiaoLei caiPingXiaoLei = caiPingXiaoLeiMap.get(caipingXiaoLeiId);
            if (caiPingXiaoLei != null) {
                List<CaiPing> caiPings = caiPingXiaoLei.getCaiPings();
                if (caiPings == null) {
                    caiPings = new ArrayList<CaiPing>();
                    caiPingXiaoLei.setCaiPings(caiPings);
                }
                caiPings.add(caiPing);
            }
        }
    }
}
