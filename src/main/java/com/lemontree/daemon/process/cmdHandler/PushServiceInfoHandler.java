package com.lemontree.daemon.process.cmdHandler;

import cn.tisson.framework.utils.StringUtils;
import com.lemontree.common.GlobalCaches;
import com.lemontree.common.GlobalConstants;
import com.lemontree.common.LogicHelper;
import com.lemontree.daemon.dbmgr.model.RestaurantInfo;
import com.lemontree.daemon.dbmgr.model.ServiceInfo;
import com.lemontree.daemon.dbmgr.service.ServiceInfoService;
import com.lemontree.daemon.domm.cmd.PushServiceInfoCmd;
import com.lemontree.daemon.domm.reslt.BaseReslt;
import com.lemontree.daemon.domm.reslt.PushServiceInfoReslt;
import com.lemontree.daemon.process.Administrator;
import com.lemontree.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

import static com.lemontree.common.GlobalConstants.HANDLE_CMD_ERROR;
import static com.lemontree.common.GlobalConstants.HANDLE_CMD_NOT_COMPLETED;
import static com.lemontree.common.GlobalVariables.DAEMON_HANDLE_CMD_CODE_MAP;

/**
 * User: Jasic
 * Date: 14-1-3
 * 处理增加商户关联的微信消息
 */
@Repository

public class PushServiceInfoHandler extends AbstractHandler<PushServiceInfoCmd> {

    private static final Logger logger = LoggerFactory.getLogger(PushServiceInfoHandler.class);

    @Resource
    private ServiceInfoService serviceInfoServI;

    @Override
    protected BaseReslt doHandle(PushServiceInfoCmd cmd) {

        PushServiceInfoReslt reslt = new PushServiceInfoReslt();


        /**
         * 1、验证命令的完整性
         */
        String shopId = cmd.getAccount().getShopID();
        String webChatId = cmd.getWebChatID();
        PushServiceInfoCmd.PushServiceOper oper = cmd.getOper();

        if (StringUtils.isEmpty(webChatId)) {
            reslt.setCode(HANDLE_CMD_NOT_COMPLETED);
            reslt.setDetail("被绑定的微信ID不能为空");
            return reslt;
        }

        if (oper == null) {
            reslt.setCode(HANDLE_CMD_NOT_COMPLETED);
            reslt.setDetail(DAEMON_HANDLE_CMD_CODE_MAP.get(HANDLE_CMD_NOT_COMPLETED));
            return reslt;
        }


        /**
         * 2、验证操作是否对应
         */
        Administrator administrator = super.adminThreadLocal.get();
        RestaurantInfo restaurantInfo = administrator.getRestaurantInfo();
        if (!shopId.equals(restaurantInfo.getShopid())) {
            reslt.setCode(HANDLE_CMD_ERROR);
            reslt.setDetail("没有权限对商店编号为：[" + shopId + "]进行操作");
            return reslt;
        }

        /**
         * 3、处理操作
         */
        switch (oper) {

            /**
             * 绑定微信号
             */
            case BIND: {

                reslt = bindWebChat(restaurantInfo, webChatId);
                break;
            }

            /**
             * 解除绑定
             */
            case UNBIND: {

                reslt = unBindWebChat(restaurantInfo, webChatId);
                break;
            }
            default: {
                reslt = new PushServiceInfoReslt();
                reslt.setCode(HANDLE_CMD_NOT_COMPLETED);
                reslt.setDetail(DAEMON_HANDLE_CMD_CODE_MAP.get(HANDLE_CMD_NOT_COMPLETED));
            }
        }

        return reslt;
    }

    /**
     * 将商户与微信号进行绑定
     *
     * @param restaurantInfo
     * @param webChatId
     * @return
     */
    private PushServiceInfoReslt bindWebChat(RestaurantInfo restaurantInfo, String webChatId) {

        ServiceInfo service = null;
        String code;
        String detail;
        String status = null;

        try {

            List<ServiceInfo> serviceInfos = restaurantInfo.getServiceInfos();

            for (ServiceInfo serviceInfo : serviceInfos) {
                if (serviceInfo.getStatus().trim().equalsIgnoreCase(GlobalConstants.STATUS_EFFETIVE)) {
                    service = serviceInfo;
                }
            }

            if (service != null) {
                detail = "已有生效的微信号[" + service.getWebchatid() + "]绑定";
                code = HANDLE_CMD_ERROR;
                status = service.getStatus();

            } else {

                service = GlobalCaches.DB_CACHE_SERVICE_INFO.get(webChatId);
                // 插入
                if (service == null) {
                    service = new ServiceInfo();
                    service.setRestid(restaurantInfo.getPid());
                    service.setWebchatid(webChatId);
                    service.setToken(webChatId);
                    service.setStatus(GlobalConstants.STATUS_EFFETIVE);
                    service.setUrl(LogicHelper.getWebchatPath(service.getToken()));

                    serviceInfoServI.insertSelective(service);

                    code = GlobalConstants.HANDLE_CMD_SUCCESS;
                    detail = DAEMON_HANDLE_CMD_CODE_MAP.get(GlobalConstants.HANDLE_CMD_SUCCESS);
                    status = service.getStatus();
                }
//            //  已绑定但生效效状态则提示操作错误
//            else if (service.getStatus().equalsIgnoreCase(STATUS_EFFETIVE)) {
//                code = HANDLE_CMD_ERROR;
//                detail = "商户编号[" + restaurantInfo.getShopID() + "]与微信号[" + webChatId + "]已被绑定";
//                status = service.getStatus();
//            }
                // 已绑定但失效状态则更新
                else {
                    service.setStatus(GlobalConstants.STATUS_EFFETIVE);
                    serviceInfoServI.updateByPrimaryKey(service);
                    code = GlobalConstants.HANDLE_CMD_SUCCESS;
                    detail = DAEMON_HANDLE_CMD_CODE_MAP.get(GlobalConstants.HANDLE_CMD_SUCCESS);
                    status = service.getStatus();
                }
            }
        } catch (Exception e) {
            code = HANDLE_CMD_ERROR;
            detail = "绑定商户编号[" + restaurantInfo.getShopid() + "]与微信号[" + webChatId + "]失败";
            if (e instanceof SQLException) {
                detail += "，原因：更改ServiceInfo信息时，数据库出错";
            }
            detail = LogicHelper.getTerminalProcessDetail(detail, e);
            logger.error(ExceptionUtil.getStackTrace(e));
        }

        PushServiceInfoReslt reslt = new PushServiceInfoReslt();
        reslt.setDetail(detail);
        reslt.setCode(code);
        reslt.setStatus(status);

        return reslt;
    }

    /**
     * 将商户与微信号解除绑定
     *
     * @param restaurantInfo
     * @param webChatId
     * @return
     */
    private PushServiceInfoReslt unBindWebChat(RestaurantInfo restaurantInfo, String webChatId) {
        ServiceInfo service;

        String code;
        String detail = "";
        String status = null;

        try {

            service = GlobalCaches.DB_CACHE_SERVICE_INFO.get(webChatId);
            if (service != null && !service.getRestid().equals(restaurantInfo.getPid())) {
                // 没找到匹配的服务号
                service = null;

            }

            // 插入
            if (service == null) {
                code = HANDLE_CMD_ERROR;
                detail = "找不到与商户编号[" + restaurantInfo.getShopid() + "]相关联的微信号[" + webChatId + "]";
            } else {
                int count = 1;
                if (service.getStatus().equals(GlobalConstants.STATUS_EFFETIVE)) {
                    service.setStatus(GlobalConstants.STATUS_NO_EFFETIVE);
                    serviceInfoServI.updateByPrimaryKey(service);
                }
                code = GlobalConstants.HANDLE_CMD_SUCCESS;
                detail = "商户编号[" + restaurantInfo.getShopid() + "]相关联的微信号[" + webChatId + "]已成功解除绑定，数量为[" + count + "]";
                status = service.getStatus();
            }

        } catch (Exception e) {
            code = HANDLE_CMD_ERROR;
            if (e instanceof SQLException) {
                detail = "访问ServiceInfo信息时，数据库出错";
            }
            detail = LogicHelper.getTerminalProcessDetail(detail, e);
            logger.error(ExceptionUtil.getStackTrace(e));
        }

        PushServiceInfoReslt reslt = new PushServiceInfoReslt();
        reslt.setCode(code);
        reslt.setDetail(detail);
        reslt.setStatus(status);

        return reslt;
    }
}