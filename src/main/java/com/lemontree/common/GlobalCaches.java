package com.lemontree.common;

import com.lemontree.daemon.dbmgr.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Jasic
 * Date: 13-12-27
 */
public class GlobalCaches {


    // 用户类型信息(ID|实体）
    public static List<ClientType> DB_CACHE_CLIENT_TYPE = new ArrayList<ClientType>();

    // 微信服务号（订阅号）信息（ServiceInfo）(微信号|实体）
    public static Map<String, ServiceInfo> DB_CACHE_SERVICE_INFO = new HashMap<String, ServiceInfo>();

    // 粉丝信息(FansInfo)(PID|实体)
    public static Map<Integer, FansInfo> DB_CACHE_FANS_INFO = new HashMap<Integer, FansInfo>();
    // 餐饮组信息(FansInfo)
    public static Map<Integer, RestaurantGroup> DB_CACHE_RESTAURANT_GROUP_INFO = new HashMap<Integer, RestaurantGroup>();
    // 餐饮信息(FansInfo)(PID/ENTITY)
    public static Map<Integer, RestaurantInfo> DB_CACHE_RESTAURANT_INFO = new HashMap<Integer, RestaurantInfo>();
    // 后台用户信息(DaemonAdminInfo)
    public static Map<Integer, List<DaemonAdminInfo>> DB_CACHE_DAEMON_ADMIN_INFO = new HashMap<Integer, List<DaemonAdminInfo>>();
    // 广告计划（ShopId/Entity)
    public static Map<String, List<AdvertisedSchedule>> DB_CACHE_DAEMON_ADVERTISE_SCHEDULE = new HashMap<String, List<AdvertisedSchedule>>();

    // 关注事件推送消息表(SubcEventPushMsg)(ServiceInfoID/Bean)
    public static Map<Integer, SubcEventPushMsg> DB_CACHE_SUBC_EVENT_PUSH_MSG = new HashMap<Integer, SubcEventPushMsg>();
    // 图文消息表(NewsMsg)(PID/BEAN)
    public static Map<Integer, NewsMsg> DB_CACHE_NEWS_MSG = new HashMap<Integer, NewsMsg>();

    public static StringBuilder SB = new StringBuilder();

    // 用于装载餐馆相对应的sqlite数据库
//    public static Map<String, Map<String, List<SqlitePojo>>> DB_CACHE_RESTAURANT_SQLITE_DATA;
    // 菜品小类
    public static Map<String, List<CaiPingXiaoLei>> CAIPINGXIAOLEI_SQLITE_DATA;
}
