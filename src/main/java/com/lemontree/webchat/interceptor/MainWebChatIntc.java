package com.lemontree.webchat.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: Jasic
 * Date: 13-12-25
 */
public class MainWebChatIntc extends HandlerInterceptorAdapter {

    /**
     * 拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {



        return true;
    }



}
