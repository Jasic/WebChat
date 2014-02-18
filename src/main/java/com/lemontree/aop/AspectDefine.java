package com.lemontree.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * User: Jasic
 * Date: 13-12-30
 * 切面的所有验证类都集合于此
 */
@Aspect
public class AspectDefine {

    /**
     * 验证请求是否源码真正的微信的服务器
     * 1、拦截验证
     * 2、拦截消息推送
     */
    @Pointcut("execution(* com.lemontree.controller.ReqFromWebChat._*(..)) && args(javax.servlet.http.HttpServletRequest)")
    public void validateReqFromWebChat() {
        // Doing Nothing
    }

    /**
     * 验证请求是否源码真正的微信的服务器
     * 1、拦截验证
     * 2、拦截消息推送
     */
    @Pointcut("execution(* com.lemontree.controller.ReqFromTerminal._handleCmd(..)))")
    public void handleCmd() {
        // Doing Nothing
    }

    /**
     * 验证请求的URL中的shopId是否存在
     * 1、拦截验证
     * 2、拦截消息推送
     */
    @Pointcut("execution(* com.lemontree.controller.WapMainController.*(..)))")
    public void validateShopIdExist() {
        // Doing Nothing
    }
}
