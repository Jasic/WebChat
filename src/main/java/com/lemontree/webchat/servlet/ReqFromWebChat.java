package com.lemontree.webchat.servlet;

import com.lemontree.common.GlobalCaches;
import com.lemontree.service.ReqFromWebChatService;
import com.lemontree.util.MessageUtil;
import org.jasic.util.ExceptionUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: Jasic
 * Date: 14-1-10
 */
public class ReqFromWebChat extends HttpServlet {

    private ReqFromWebChatService service;

    {
        service = new ReqFromWebChatService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getOutputStream().print(req.getParameter("echostr"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String body = MessageUtil.getRequestBody(req);

        System.out.println(body);
        String respText = null;
        try {
            respText = service.handle(body);
        } catch (Exception e) {
            System.out.println(ExceptionUtil.getStackTrace(e));
        }
        GlobalCaches.SB.append("Response:" + resp + "\n");

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(respText);
    }

    public void setService(ReqFromWebChatService service) {
        this.service = service;
    }
}
