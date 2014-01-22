package com.lemontree.service;

import cn.tisson.framework.utils.StringUtils;
import com.lemontree.common.GlobalCaches;
import com.lemontree.daemon.dbmgr.model.DaemonAdminInfo;
import com.lemontree.daemon.dbmgr.model.RestaurantInfo;
import com.lemontree.daemon.domm.cmd.Account;
import com.lemontree.daemon.domm.reslt.Status;
import com.lemontree.daemon.process.Administrator;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Author Jasic
 * Date 14-1-4.
 * 检查服务
 */
@Service("CheckAuthService")
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CheckAuthService {

    /**
     * 后端?用户鉴权
     *
     * @param account
     * @return
     */
    public Status.ProcessStatus checkAuth(Account account, ThreadLocal<Administrator> adminThreadLocal) {

        Status.ProcessStatus ps = new Status.ProcessStatus();
        Administrator administrator = new Administrator();

        String shopId = account.getShopID();
        String pwd = account.getPwd();

        if (StringUtils.isEmpty(shopId)) {
            ps.setStatus(Status.EXECUTE_CMD_FAIL_CODE);
            ps.setReason("Shop id is null or ''");
            return ps;
        }

        if (StringUtils.isEmpty(pwd)) {
            ps.setStatus(Status.EXECUTE_CMD_FAIL_CODE);
            ps.setReason("Password of shop[" + shopId + "] is null or ''");
            return ps;
        }

        // TODO 实现用户鉴权
        // 1、去缓存查
        // 2、去数据库查

        Collection<RestaurantInfo> restaurantInfoList = GlobalCaches.DB_CACHE_RESTAURANT_INFO.values();
        RestaurantInfo info = null;
        for (RestaurantInfo temp : restaurantInfoList) {
            if (shopId.equals(temp.getShopid())) {
                info = temp;
                break;
            }
        }

        // 不存在此餐馆
        if (info == null || info.getPid() == null) {
            ps.setStatus(Status.EXECUTE_CMD_FAIL_CODE);
            ps.setReason("Not exist shopID：[" + shopId + "]");
            return ps;
        }

        // 存在餐馆
        Integer restId = info.getPid();
        List<DaemonAdminInfo> admins = GlobalCaches.DB_CACHE_DAEMON_ADMIN_INFO.get(restId);


        DaemonAdminInfo admin = null;
        if (admins != null && admins.size() != 0) {
            for (DaemonAdminInfo temp : admins) {
                if (restId.equals(temp.getRestid())) {
                    admin = temp;
                    break;
                }
            }
        }

        if (admin == null) {
            ps.setStatus(Status.EXECUTE_CMD_FAIL_CODE);
            ps.setReason("Can't find admin for shopID[" + info.getShopid() + "]");
            return ps;
        } else if (pwd.equals(admin.getPasswd())) {

        } else {
            ps.setStatus(Status.EXECUTE_CMD_FAIL_CODE);
            ps.setReason("Password of admin for shopID[" + info.getShopid() + "] is wrong!");
            return ps;
        }
        ps.setStatus(Status.EXECUTE_CMD_SUCCESS_CODE);

        administrator.setAdminInfo(admin);
        administrator.setRestaurantInfo(info);

        adminThreadLocal.remove();
        adminThreadLocal.set(administrator);

        return ps;
    }
}
