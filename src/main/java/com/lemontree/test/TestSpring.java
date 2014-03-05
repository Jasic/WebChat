package com.lemontree.test;

import cn.tisson.framework.config.ConfigHandler;
import com.lemontree.common.GlobalVariables;
import com.lemontree.main.AppContextConfig;
import com.lemontree.service.ReqFromWebChatService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * User: Jasic
 * Date: 13-12-26
 */
public class TestSpring {

    public static void main(String[] args) {
        ConfigHandler.loadConfigWithoutDB(GlobalVariables.class);

        testAop();
//        testRegister();
        ;
    }


    public static void testRegister() {
        /**
         * 注册方法1、
         */
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppContextConfig.class);
        ReqFromWebChatService reqFromWebChat = ctx.getBean(ReqFromWebChatService.class);
        System.out.println(reqFromWebChat);


        /**
         * 注册方法2、
         */
        AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext();
        ctx2.register(AppContextConfig.class);
    }


    @Test
    public static void testAop() {
        AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(AppContextConfig.class);

//        TestValidateAspect aspect = ctx2.getBean(TestValidateAspect.class);
//        System.out.println(aspect);
//
//        aspect.validateReqFromWebChat();

        TestAop aop = ctx2.getBean(TestAop.class);
        System.out.println(aop);
        System.out.println(aop.getClass());
        aop.doActual("你姨", 10);
    }
}
