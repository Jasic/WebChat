package com.lemontree.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * User: Jasic
 * Date: 13-12-30
 * 验证的切入过程
 */
@Component("ValidateAdvise")
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
}
