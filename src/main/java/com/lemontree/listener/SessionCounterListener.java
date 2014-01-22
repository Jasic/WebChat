package com.lemontree.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Map;

public class SessionCounterListener implements HttpSessionListener {


    public void sessionCreated(HttpSessionEvent sessionEven) {

    }

    /**
     * 监听session销毁时候，去除当前登录用户的登记
     */
    public void sessionDestroyed(HttpSessionEvent sessionEven) {
        // TODO Auto-generated method stub
        HttpSession session = sessionEven.getSession();
        ServletContext application = session.getServletContext();

        @SuppressWarnings("unchecked")
        Map<String, HttpSession> sessionContainer = (Map<String, HttpSession>) application.getAttribute("SESSION_CONTAINER");

        if (sessionContainer != null) {
            if (sessionContainer.containsKey(session.getId())) {
                sessionContainer.remove(session.getId());
            }
        }


    }

}
