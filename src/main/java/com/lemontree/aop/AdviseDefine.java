package com.lemontree.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * User: Jasic
 * Date: 13-12-30
 * 验证的切入过程
 */
@Aspect
public class AdviseDefine {


    /**
     * 验证微信服务器的正确性
     *
     * @param jp
     */
    public void validateReqFromWebChat(JoinPoint jp) {

        Object[] args = jp.getArgs();

        for (Object o : args) {
            if (o instanceof HttpServletRequest) {

                //
            }
        }
    }


    public void handleCmd() {
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

    @Before("validateShopIdExist()")
    public void validateShopIdExist(JoinPoint jp) {
        Object[] args = jp.getArgs();

        for (Object o : args) {
            if (o instanceof HttpServletRequest) {

                System.out.println(o);
            }
        }
    }
}
