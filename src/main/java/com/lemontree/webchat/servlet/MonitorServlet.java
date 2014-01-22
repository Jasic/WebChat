package com.lemontree.webchat.servlet;

import com.lemontree.common.GlobalCaches;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: Jasic
 * Date: 13-12-5
 */
public class MonitorServlet extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

//        if (GlobalVariables.GLOBAL_TOKEN_RESPOND == null) {
//            LogicHelper.login();
//        }
//
//        writer.write(StringUtil.entityToString(GlobalVariables.GLOBAL_TOKEN_RESPOND));
//        writer.write(StringUtil.entityToString(GlobalVariables.GLOBAL_SIGNATURE));
//        writer.write(StringUtil.mapToString(GlobalVariables.GLOBAL_ACCESS_MAP));

        writer.write(GlobalCaches.SB.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPut(req, resp);
    }
}
