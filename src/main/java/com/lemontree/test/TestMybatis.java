package com.lemontree.test;

import cn.tisson.framework.config.ConfigHandler;
import com.alibaba.fastjson.JSON;
import com.lemontree.daemon.dbmgr.model.NewsMsg;
import com.lemontree.daemon.dbmgr.model.RestaurantInfo;
import com.lemontree.daemon.dbmgr.model.ServiceInfo;
import com.lemontree.daemon.dbmgr.model.SubcEventPushMsg;
import com.lemontree.daemon.dbmgr.service.NewsMsgService;
import com.lemontree.daemon.dbmgr.service.RestaurantInfoService;
import com.lemontree.daemon.dbmgr.service.ServiceInfoService;
import com.lemontree.daemon.dbmgr.service.SubcEventPushMsgService;
import com.lemontree.main.AppContextConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author Jasic
 * Date 14-1-17.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = AppContextConfig.class)
public class TestMybatis {

    @Resource
    private ServiceInfoService serviceInfoServ;

    public ServiceInfoService getServiceInfoServ() {
        return serviceInfoServ;
    }

    public void setServiceInfoServ(ServiceInfoService serviceInfoServ) {
        this.serviceInfoServ = serviceInfoServ;
    }

    ApplicationContext context;

    @Before
    public void before() {
        ConfigHandler.loadConfigWithoutDB(TestMybatis.class);
        context = new AnnotationConfigApplicationContext(AppContextConfig.class);


    }

    @Test
    public void testServiceInfo() {

        ConfigHandler.loadConfigWithoutDB(TestMybatis.class);

        ApplicationContext context = new AnnotationConfigApplicationContext(AppContextConfig.class);

        serviceInfoServ = context.getBean(ServiceInfoService.class);
        System.out.println(serviceInfoServ);
        ServiceInfo serviceInfo = serviceInfoServ.selectByPrimaryKey(0);
        System.out.println(JSON.toJSON(serviceInfo));

        List<ServiceInfo> list = serviceInfoServ.getAll();
        System.out.println(JSON.toJSON(list));
    }


    @Test
    public void testRestInfo() {

        RestaurantInfoService restaurantInfoServI = (RestaurantInfoService) context.getBean("RestaurantInfoServImpl");
        List<RestaurantInfo> infos = restaurantInfoServI.getAll();
        System.out.println(JSON.toJSON(infos));
    }

    @Test
    public void testSubcEventPushMsg() {

        SubcEventPushMsgService subcEventPushMsgServI = (SubcEventPushMsgService) context.getBean("subcEventPushMsgServImpl");
        List<SubcEventPushMsg> infos = subcEventPushMsgServI.getAll();
        System.out.println(JSON.toJSON(infos));
    }

    @Test
    public void testNewsMsg() {

        NewsMsgService newsMsgServI = (NewsMsgService) context.getBean("newsMsgServImpl");
        List<NewsMsg> infos = newsMsgServI.getAll();
        System.out.println(JSON.toJSON(infos));
    }
}
