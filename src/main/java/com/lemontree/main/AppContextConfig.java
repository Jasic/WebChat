package com.lemontree.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration("AppContextConfig") //1、使用@Configuration注解配置类
@ImportResource(value = {"classpath:config/spring-mybatis.xml", "classpath:config/spring-common.xml"})
//在基于Java方式的配置类中引入基于XML方式的配置文件
/**
 * 此问题搞死我了，参考http://bbs.csdn.net/topics/390534816?page=1#post-395188504
 */
@MapperScan(basePackages = {"com.lemontree.daemon.dbmgr.mapper"})
// ，发现如果使用了JavaConfig的方式启动Spring，那么即使是ImportResource了XML文件也是无法让MapperScannerConfigurer扫描到的，必须改为同样的JavaConfig方式。
public class AppContextConfig {

//    /**
//     * initMethod:初始化时执行自已的方法
//     * destroyMethod:结束时执行自己的方法
//     *
//     * @return
//     */
//    @Bean(name = "reqFromWebChatService")
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    public ReqFromWebChatService reqFromWebChatService() {
//        ReqFromWebChatService manager = new ReqFromWebChatService();
//        return manager;
//    }
}
