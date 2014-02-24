package com.lemontree.listener;


import cn.tisson.framework.config.ConfigHandler;
import cn.tisson.framework.global.AppVariables;
import com.lemontree.common.GlobalVariables;
import com.lemontree.common.RefreshHelper;
import com.lemontree.common.SqliteRefresher;
import com.lemontree.common.SystemInit;
import com.lemontree.main.SystemRefresher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;

public class MainListener extends org.springframework.web.context.ContextLoaderListener {

    private static final Logger logger = LoggerFactory.getLogger(MainListener.class);

    public void contextDestroyed(ServletContextEvent event) {
        try {
            super.contextDestroyed(event);

            AppVariables.APP_RUNNING_FLAG = false;

            logger.info("[程序管理]: 程序关闭完成");

        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    public void contextInitialized(ServletContextEvent event) {

        try {
            if (!ConfigHandler.loadConfigWithoutDB(GlobalVariables.class)) {
                return;
            }
//            if (!ConfigHandler.loadConfigWithoutDB(GlobalVariables.class) && SystemInit.init()) {
//                return;
//            }
            logger.info("[配置管理]: 读取所有配置文件完成");

            if (!SystemInit.init()) {
                return;
            }

            super.contextInitialized(event);

            ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
            RefreshHelper refreshHelper = applicationContext.getBean(RefreshHelper.class);

            // 先刷新一次基础数据
            refreshHelper.refresh();

            GlobalVariables.REFRESH_HELPER = refreshHelper;

            SqliteRefresher sqliteRefresher = new SqliteRefresher();
            sqliteRefresher.start();

//            testInit();
            //刷新系统缓存
            SystemRefresher systemRefresher = new SystemRefresher();
            systemRefresher.start();

            // 接入微信服务
//            new LoginThread().start();

            AppVariables.APP_SQL_LOG = false;
            AppVariables.APP_SOCKET_CLIENT_LOG = false;
            AppVariables.APP_SOCKET_SERVER_LOG = false;

            logger.info("[缓存管理]: 初始化缓存成功");
        } catch (Exception e) {
            logger.info("Exception: ", e);
        }
    }

}
