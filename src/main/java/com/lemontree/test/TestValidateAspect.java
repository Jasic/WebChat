package com.lemontree.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * User: Jasic
 * Date: 13-12-30
 * 切面的所有验证类都集合于此
 */
@Component("TestValidateAspect")
@Aspect
public class TestValidateAspect {


    /**
     * 验证请求是否源码真正的微信的服务器
     */
    @Pointcut("execution(* com.lemontree.test.TestAop.*(..))")
    public void validateReqFromWebChat() {

        // Do nothing
    }


    @Before("com.lemontree.test.TestValidateAspect.validateReqFromWebChat() && args(..)")
    public void advise(JoinPoint jp) {
        Object[] os = jp.getArgs();
        System.out.println("切点-------");

    }

    @Before("com.lemontree.test.TestValidateAspect.validateReqFromWebChat() && args(javax.servlet.http.HttpServletRequest)")
    public void advise2(JoinPoint jp) {
        Object[] os = jp.getArgs();
        System.out.println("切点-------");

    }
}
