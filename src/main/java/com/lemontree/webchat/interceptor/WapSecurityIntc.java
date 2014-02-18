package com.lemontree.webchat.interceptor;

import com.lemontree.common.GlobalConstants;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Author Jasic
 * 对Wap网站是否登录的验证
 */
public class WapSecurityIntc extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession(true);
        // 从session 里面获取用户名的信息
        Object obj = session.getAttribute(GlobalConstants.SESSION_USER_KEY);
        // 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆
        if (obj == null || "".equals(obj.toString())) {
            ModelAndView view = new ModelAndView("login");
            throw new ModelAndViewDefiningException(view);
        }
        return true;
    }
}
