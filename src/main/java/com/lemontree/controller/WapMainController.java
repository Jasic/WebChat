package com.lemontree.controller;

import cn.tisson.framework.utils.MD5Utils;
import cn.tisson.framework.utils.StringUtils;
import com.lemontree.bean.User;
import com.lemontree.common.GlobalCaches;
import com.lemontree.common.GlobalConstants;
import com.lemontree.common.LogicHelper;
import com.lemontree.daemon.dbmgr.model.*;
import com.lemontree.daemon.dbmgr.service.ClientInfoService;
import com.lemontree.daemon.dbmgr.service.FansInfoService;
import com.lemontree.exception.BusinessException;
import org.jasic.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    private static final Logger logger = LoggerFactory.getLogger(WapMainController.class);

    /**
     * 访问主页面
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}", method = {RequestMethod.GET, RequestMethod.POST})
    public String AccessMainFrame(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        String path = request.getContextPath();
        String baPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        RestaurantInfo restInfo = LogicHelper.findResturant(shopId);

        if (restInfo == null) {
            // TODO 没找到相关餐馆
            return null;
        }

        // 获取广告
        List<AdvertisedSchedule> ases = restInfo.getAdvertisedSchedules();
        model.put("ases", ases);
        model.put("shopId", shopId);
        String fanInfoId = request.getParameter("fanInfoId");
        request.getSession().setAttribute("fanInfoId", fanInfoId);

        String userName = null;

        Object obj = request.getSession().getAttribute(GlobalConstants.SESSION_USER_KEY);
        // 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆
        if (obj instanceof User) {
            userName = ((User) obj).getClientInfo().getMemberno();
        }

        model.put("userName", userName);

        return "wapindex";
    }

    /**
     * 访问订单页面
     * 访问customer.jsp
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/customer", method = {RequestMethod.GET, RequestMethod.POST})
    public String AccessCustomerFrame(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        String path = request.getContextPath();
        String baPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        RestaurantInfo restInfo = LogicHelper.findResturant(shopId);
        model.put("shopId", shopId);

        if (restInfo == null) {
            // TODO 没找到相关餐馆
            return null;
        }

        Object o = request.getSession().getAttribute(GlobalConstants.SESSION_USER_KEY);
        if (o == null) {

            model.put("user", null);
        } else if (o instanceof User) {
            User user = (User) o;
            model.put("user", user);
        }

        return "customer";
    }

    /**
     * 访问登录页面
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginFrame(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        String path = request.getContextPath();
        String baPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        RestaurantInfo restInfo = LogicHelper.findResturant(shopId);
        model.put("shopId", shopId);

        if (restInfo == null) {
            // TODO 没找到相关餐馆
            return null;
        }

        return "login";
    }

    /**
     * 访问注册页面
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/register", method = {RequestMethod.GET, RequestMethod.POST})
    public String registerFrame(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        String path = request.getContextPath();
        String baPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        RestaurantInfo restInfo = LogicHelper.findResturant(shopId);
        model.put("shopId", shopId);


        if (restInfo == null) {
            // TODO 没找到相关餐馆
            return null;
        }

        List clientTypes = new ArrayList(GlobalCaches.DB_CACHE_CLIENT_TYPE);

        // Add default
        {
            ClientType clientType = new ClientType();
            clientType.setDescription("保密");
            clientType.setType("保密");
            clientType.setPid(-1);
            clientTypes.add(clientType);
        }
        model.put("clientTypes", clientTypes);
        return "register";
    }

    /**
     * 访问地址页面
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/address", method = {RequestMethod.GET, RequestMethod.POST})
    public String AccessaddressFrame(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        String path = request.getContextPath();
        String baPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        RestaurantInfo restInfo = LogicHelper.findResturant(shopId);

        if (restInfo == null) {
            // TODO 没找到相关餐馆
            return null;
        }

        return "address";
    }

    /**
     * 访问地址页面
     * , params = {"type", "redirectUrl"}
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/successRedirect", method = {RequestMethod.GET, RequestMethod.POST})
    public String AccesssuccessRedirectFrame(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        String path = request.getContextPath();
        String baPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        RestaurantInfo restInfo = LogicHelper.findResturant(shopId);

        if (restInfo == null) {
            // TODO 没找到相关餐馆
            return null;
        }

        model.put("type", request.getParameter("type"));
        model.put("redirectUrl", request.getParameter("redirectUrl"));
        return "successRedirect";
    }

    /**
     * 访问订单页面
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/editAddress", method = {RequestMethod.GET, RequestMethod.POST})
    public String AccessEditAddressFrame(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        String path = request.getContextPath();
        String baPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        RestaurantInfo restInfo = LogicHelper.findResturant(shopId);

        if (restInfo == null) {
            // TODO 没找到相关餐馆
            return null;
        }

        return "editAddress";
    }

    /**
     * 验证是否已登录
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/validateHasLogin", method = {RequestMethod.GET, RequestMethod.POST})
    public String validateHasLogin(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        String path = request.getContextPath();
        String baPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        RestaurantInfo restInfo = LogicHelper.findResturant(shopId);

        if (restInfo == null) {
            // TODO 没找到相关餐馆
            return null;
        }


        return "editAddress";
    }


    /**
     * -------------------------------------- Action 处理 ------------------------------------------
     */
    /**
     * 登录动作处理
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/loginAction", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginAction(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        String path = request.getContextPath();
        String baPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        RestaurantInfo restInfo = LogicHelper.findResturant(shopId);
        model.put("shopId", shopId);

        if (restInfo == null) {
            // TODO 没找到相关餐馆
            return null;
        }


        return "login";
    }

    /**
     * 注册动作处理
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/registerAction", params = {"fanInfoId"}, method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String registerAction(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        try {

            String path = request.getContextPath();
            String baPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

            RestaurantInfo restInfo = LogicHelper.findResturant(shopId);
            model.put("shopId", shopId);

            if (restInfo == null) {
                // TODO 没找到相关餐馆
                return null;
            }

            String fanInfoIdStr = request.getParameter("fanInfoId");

            if (!StringUtils.isNumeric(fanInfoIdStr)) {
                return "系统参数错误！";
            }

            Integer fanInfoId = Integer.valueOf(fanInfoIdStr);

            FansInfo fansInfo = fansInfoService.selectByPrimaryKey(fanInfoId);

            if (fansInfo == null) {
                return "您未关注本商户[" + shopId + "],请先关注再注册！";
            }

            String phone = request.getParameter("phone").trim();
            String password = request.getParameter("password").trim();
            String email = request.getParameter("email").trim();
            String clietName = request.getParameter("clietName").trim();
            String address = request.getParameter("address").trim();
            String identityStr = request.getParameter("indetity").trim();
            Integer identity = null;


            ClientInfo clientInfo = clientInfoService.selectByMemNo(phone);
            if (clientInfo != null) {
                return "已存在注册用户[" + phone + "]";
            }

//            if (!StringUtil.isMatch(GlobalConstants.PHONE_REGEX_STR, phone)) {
//                return "不是完整的11位手机号或者正确的手机号前七位";
//            }
//
//            if (StringUtils.isEmpty(password)) {
//                return "密码不能为空!";
//            }
//            if (password.length()<=4) {
//                return "密码长度必大于等于4!";
//            }

            clientInfo = new ClientInfo();
            clientInfo.setAddress(address);
            clientInfo.setClientname(clietName);
            clientInfo.setFaninfoid(fansInfo.getPid());
            clientInfo.setEmail(email);
            clientInfo.setMemberno(phone);
            clientInfo.setPassword(MD5Utils.getMD5(password));
            clientInfo.setClienttypeid(identity);

            int success = clientInfoService.insertSelective(clientInfo);

            if (success <= 0) throw new BusinessException("插入微餐厅注册用户信息失败～");

            // 刚注册用户将信息保持在session中以保持登录
            User user = new User();
            user.setClientInfo(clientInfo);
            request.getSession().setAttribute(GlobalConstants.SESSION_USER_KEY, user);

            return "success";
        } catch (Exception e) {
            logger.error(ExceptionUtil.getExceptionStackTrace(e));
            return "微餐厅注册用户信息失败，!请联系管理员～";
        }
    }


    @Resource
    private ClientInfoService clientInfoService;

    @Resource
    private FansInfoService fansInfoService;
}
