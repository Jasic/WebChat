package com.lemontree.common;


import com.lemontree.daemon.dbmgr.model.*;
import com.lemontree.daemon.dbmgr.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * User: Jasic
 * Date: 13-12-27
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RefreshHelper {
    private static Logger logger = LoggerFactory.getLogger(RefreshHelper.class);

    @Resource
    RestaurantGroupService restaurantGroupServI;

    @Resource
    ServiceInfoService serviceInfoServI;

    @Resource
    RestaurantInfoService restaurantInfoServI;

    @Resource
    DaemonAdminInfoService daemonAdminInfoServI;

    @Resource
    SubcEventPushMsgService subcEventPushMsgServI;

    @Resource
    NewsMsgService newsMsgServI;

    @Resource
    AdvertisedScheduleService advertisedScheduleService;

    public void refresh() throws Exception {


        refreshRestaurantGroup();
        refreshServiceInfo();
        refreshRestaurantInfo();
        refreshDaemonAdminInfo();
        refreshSubcEventPushMsg();
        refreshNewsMsg();

    }

    /**
     * 刷新餐厅组信息(FansInfo)
     *
     * @throws Exception
     */
    public void refreshRestaurantGroup() throws Exception {

        List<RestaurantGroup> list = restaurantGroupServI.getAll();
        synchronized (GlobalCaches.DB_CACHE_RESTAURANT_GROUP_INFO) {
            GlobalCaches.DB_CACHE_RESTAURANT_GROUP_INFO = new HashMap<Integer, RestaurantGroup>();
            for (RestaurantGroup group : list) {
                GlobalCaches.DB_CACHE_RESTAURANT_GROUP_INFO.put(group.getPid(), group);
            }
        }
        logger.info("--刷新餐厅组数量:" + list.size());

    }

    /**
     * 刷新服务号、订阅号
     *
     * @throws Exception
     */
    public void refreshServiceInfo() throws Exception {
        List<ServiceInfo> list = serviceInfoServI.getAll();
        synchronized (GlobalCaches.DB_CACHE_SERVICE_INFO) {
            GlobalCaches.DB_CACHE_SERVICE_INFO = new HashMap<String, ServiceInfo>();
            for (ServiceInfo info : list) {
                GlobalCaches.DB_CACHE_SERVICE_INFO.put(info.getWebchatid(), info);
            }
        }
        logger.info("--刷新服务号数量:" + list.size());
    }

    /**
     * 刷新餐厅基本信息
     *
     * @throws Exception
     */
    public void refreshRestaurantInfo() throws Exception {

        // 刷新广告
        refreshAdvertisedSchedule();
        List<RestaurantInfo> list = restaurantInfoServI.getAll();
        synchronized (GlobalCaches.DB_CACHE_RESTAURANT_INFO) {
            GlobalCaches.DB_CACHE_RESTAURANT_INFO = new HashMap<Integer, RestaurantInfo>();
            for (RestaurantInfo info : list) {
                GlobalCaches.DB_CACHE_RESTAURANT_INFO.put(info.getPid(), info);
                info.setAdvertisedSchedules(GlobalCaches.DB_CACHE_DAEMON_ADVERTISE_SCHEDULE.get(info.getShopid()));
            }
        }
        logger.info("--刷新餐厅数量:" + list.size());
    }

    /**
     * 刷新后台管理员信息(DaemonAdminInfo)
     *
     * @throws Exception
     */
    public void refreshDaemonAdminInfo() throws Exception {

        List<DaemonAdminInfo> list = daemonAdminInfoServI.getAll();
        synchronized (GlobalCaches.DB_CACHE_DAEMON_ADMIN_INFO) {
            GlobalCaches.DB_CACHE_DAEMON_ADMIN_INFO = new HashMap<Integer, List<DaemonAdminInfo>>();
            for (DaemonAdminInfo info : list) {

                Integer restId = info.getRestid();
                List<DaemonAdminInfo> l = GlobalCaches.DB_CACHE_DAEMON_ADMIN_INFO.get(restId);
                if (l == null) {
                    l = new ArrayList<DaemonAdminInfo>();
                    GlobalCaches.DB_CACHE_DAEMON_ADMIN_INFO.put(restId, l);
                }
                l.add(info);
            }
        }
        logger.info("--刷新后台管理员:" + list.size());
    }

    /**
     * 刷新广告计划
     */
    public void refreshAdvertisedSchedule() {

        List<AdvertisedSchedule> list = advertisedScheduleService.getAllEffect();
        AdComparator comparator = new AdComparator();
        synchronized (GlobalCaches.DB_CACHE_DAEMON_ADVERTISE_SCHEDULE) {
            GlobalCaches.DB_CACHE_DAEMON_ADVERTISE_SCHEDULE = new HashMap<String, List<AdvertisedSchedule>>();
            for (AdvertisedSchedule as : list) {
                List<AdvertisedSchedule> ases = GlobalCaches.DB_CACHE_DAEMON_ADVERTISE_SCHEDULE.get(as.getShopid());

                if (ases == null) {
                    ases = new ArrayList<AdvertisedSchedule>();
                    GlobalCaches.DB_CACHE_DAEMON_ADVERTISE_SCHEDULE.put(as.getShopid(), ases);
                }
                ases.add(as);
            }

            for (Collection<AdvertisedSchedule> asl : GlobalCaches.DB_CACHE_DAEMON_ADVERTISE_SCHEDULE.values()) {
                Collections.sort(new ArrayList<AdvertisedSchedule>(asl), comparator);
            }
        }
        logger.info("--刷新广告计划:" + list.size());
    }


    /**
     * 关注事件推送消息表(SubcEventPushMsg)
     */
    public void refreshSubcEventPushMsg() throws Exception {

        List<SubcEventPushMsg> list = subcEventPushMsgServI.getAll();
        synchronized (GlobalCaches.DB_CACHE_DAEMON_ADMIN_INFO) {
            GlobalCaches.DB_CACHE_SUBC_EVENT_PUSH_MSG = new HashMap<Integer, SubcEventPushMsg>();
            for (SubcEventPushMsg info : list) {
                GlobalCaches.DB_CACHE_SUBC_EVENT_PUSH_MSG.put(info.getServiceinfoid(), info);
            }
        }
        logger.info("--关注事件推送消息数量:" + list.size());
    }

    /**
     * 图文推送消息表(NewsMsg)
     */
    public void refreshNewsMsg() throws Exception {

        List<NewsMsg> list = newsMsgServI.getAll();
        synchronized (GlobalCaches.DB_CACHE_NEWS_MSG) {
            GlobalCaches.DB_CACHE_NEWS_MSG = new HashMap<Integer, NewsMsg>();

            for (NewsMsg info : list) {
                GlobalCaches.DB_CACHE_NEWS_MSG.put(info.getPid(), info);
            }
        }
        logger.info("--图文推送消息表数量:" + list.size());
    }


    static class AdComparator implements Comparator<AdvertisedSchedule> {


        @Override
        public int compare(AdvertisedSchedule advertisedSchedule, AdvertisedSchedule advertisedSchedule2) {
            return advertisedSchedule.getPriority() - advertisedSchedule.getPriority();
        }
    }
}
