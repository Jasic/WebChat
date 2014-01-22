package com.lemontree.daemon.process;

import com.lemontree.daemon.dbmgr.model.DaemonAdminInfo;
import com.lemontree.daemon.dbmgr.model.RestaurantInfo;


/**
 * Author Jasic
 * Date 14-1-4.
 * 后台登录用户
 */
public class Administrator {

    private DaemonAdminInfo adminInfo;

    private RestaurantInfo restaurantInfo;

    public DaemonAdminInfo getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(DaemonAdminInfo adminInfo) {
        this.adminInfo = adminInfo;
    }

    public RestaurantInfo getRestaurantInfo() {
        return restaurantInfo;
    }

    public void setRestaurantInfo(RestaurantInfo restaurantInfo) {
        this.restaurantInfo = restaurantInfo;
    }
}
