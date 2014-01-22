package com.lemontree.controller;

import com.lemontree.common.LogicHelper;
import com.lemontree.daemon.dbmgr.model.AdvertisedSchedule;
import com.lemontree.daemon.dbmgr.model.RestaurantInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * User: Jasic
 * Date: 14-1-6
 * <p/>
 * 拦截请求浏览总入口
 */
@Controller("WapMainController")
@RequestMapping(value = "/wap")
public class WapMainController {

    /**
     * 访问主页面
     *
     * @return
     */
    @RequestMapping(value = "/main/{shopId:[\\S]{1,30}}", method = {RequestMethod.GET, RequestMethod.POST})
    public String AccessMainFrame(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        String path = request.getContextPath();
        String baPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;


        RestaurantInfo restInfo = LogicHelper.findResturant(shopId);

        List<AdvertisedSchedule> ases = restInfo.getAdvertisedSchedules();

        model.put("ases", ases);


        return "mainFrame";
    }

}
