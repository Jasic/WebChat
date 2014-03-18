package com.lemontree.controller;

import cn.tisson.framework.utils.MD5Utils;
import cn.tisson.framework.utils.StringUtils;
import com.lemontree.bean.User;
import com.lemontree.common.LogicHelper;
import com.lemontree.daemon.dbmgr.model.*;
import com.lemontree.daemon.dbmgr.service.ClientInfoService;
import com.lemontree.daemon.dbmgr.service.FansInfoService;
import com.lemontree.daemon.dbmgr.service.TakeOutAddressService;
import com.lemontree.exception.BusinessException;
import org.jasic.util.Asserter;
import org.jasic.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.lemontree.common.GlobalCaches.*;
import static com.lemontree.common.GlobalConstants.*;

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
    public String MainFrame(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

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

        if (LogicHelper.getUser(request.getSession()) == null) {
            // 获取粉丝信息
            FansInfo fansInfo = null;
            String fanInfoId = request.getParameter(SESSION_FANSINFOID_KEY);
            if (StringUtils.isNumeric(fanInfoId)) {
                fansInfo = DB_CACHE_FANS_INFO.get(Integer.valueOf(fanInfoId));
            }

            // 获取平台信息
            ClientInfo clientInfo = null;
            if (fansInfo != null) {
                Integer fid = fansInfo.getPid();
                clientInfo = clientInfoService.selectByFanInfoId(fid);
            }

            LogicHelper.saveSessionUser(request.getSession(), clientInfo, fansInfo);

            if (clientInfo != null) {
                // 自动登录模式
                if (LOGIN_MODE_AUTO.equalsIgnoreCase(clientInfo.getLoginmode())) {
                    LogicHelper.getUser(request.getSession()).setHasLogin(true);
                }

                // 手动登录
                else {
                    LogicHelper.getUser(request.getSession()).setHasLogin(false);
                }
            }
        }
        return "wapindex";
    }

    /**
     * 访问订单页面
     * 访问customer.jsp
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/customer", method = {RequestMethod.GET, RequestMethod.POST})
    public String CustomerFrame(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        String path = request.getContextPath();
        String baPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        RestaurantInfo restInfo = LogicHelper.findResturant(shopId);
        model.put("shopId", shopId);

        if (restInfo == null) {
            // TODO 没找到相关餐馆
            return null;
        }

        Object o = request.getSession().getAttribute(SESSION_USER_KEY);
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
     * 访问菜单页面
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/orderDishes", method = {RequestMethod.GET, RequestMethod.POST})
    public String orderDishesFrame(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        String path = request.getContextPath();
        String baPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        RestaurantInfo restInfo = LogicHelper.findResturant(shopId);
        model.put("shopId", shopId);

        if (restInfo == null) {
            // TODO 没找到相关餐馆
            return null;
        }

        String shopName = restInfo.getName();
        model.put("shopName", shopName == null ? shopId : shopName);
        model.put("shopId", shopId);

        List<CaiPingXiaoLei> caiPingXiaoLeis = CAIPINGXIAOLEI_SQLITE_DATA.get(shopId);
        model.put("caiPingXiaoLeis", caiPingXiaoLeis);

        return "orderDishes";
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

        List clientTypes = new ArrayList(DB_CACHE_CLIENT_TYPE);

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
    public String addressFrame(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        User user = LogicHelper.getUser(request.getSession());
        if (user == null) return null;
        String memNo = user.getClientInfo().getMemberno();
        List<TakeOutAddress> addresses = takeOutAddressService.getListByMemNo(memNo);
        model.put("addresses", addresses);
        return "address";
    }

    /**
     * 访问地址页面
     * , params = {"type", "redirectUrl"}
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/successRedirect", method = {RequestMethod.GET, RequestMethod.POST})
    public String successRedirectFrame(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        String path = request.getContextPath();
        String baPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        RestaurantInfo restInfo = LogicHelper.findResturant(shopId);

        if (restInfo == null) {
            // TODO 没找到相关餐馆
            return null;
        }

        model.put("type", request.getParameter("type"));
        model.put("redirectUrl", request.getParameter("redirectUrl"));
        model.put("seconds", 3);
        return "successRedirect";
    }

    /**
     * 访问订单页面
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/editAddress", method = {RequestMethod.GET, RequestMethod.POST})
    public String editAddressFrame(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        String path = request.getContextPath();
        String baPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        RestaurantInfo restInfo = LogicHelper.findResturant(shopId);

        if (restInfo == null) {
            // TODO 没找到相关餐馆
            return null;
        }

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String type = request.getParameter(EDIT_ADDRESS_TYPE);
        if (type.equalsIgnoreCase(ADDRESS_UPDATE)) {
            model.put(EDIT_ADDRESS_TYPE, type);
            model.put("pid", request.getParameter("pid"));
        } else {
            model.put(EDIT_ADDRESS_TYPE, ADDRESS_ADD);
        }
        model.put("name", name);
        model.put("phone", phone);
        model.put("address", address);

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
     * 订单记录页面
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/record", method = {RequestMethod.GET, RequestMethod.POST})
    public String orderFrame(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {

        String path = request.getContextPath();
        String baPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        RestaurantInfo restInfo = LogicHelper.findResturant(shopId);

        if (restInfo == null) {
            // TODO 没找到相关餐馆
            return null;
        }

        return "record";
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
    public
    @ResponseBody
    String loginAction(ModelMap model, HttpServletRequest request, @PathVariable("shopId") final String shopId) {
        model.put("shopId", shopId);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String keepLogin = request.getParameter("keepLogin");

        if (LOGIN_MODE_AUTO.equalsIgnoreCase(keepLogin)) {
            keepLogin = LOGIN_MODE_AUTO;
        } else {
            keepLogin = LOGIN_MODE_MANUAL;
        }

        User user = LogicHelper.getUser(request.getSession());

        ClientInfo clientInfo = (user == null) ? null : user.getClientInfo();

        // 使用手机号码作为会员码
        if (!clientInfo.getMemberno().equals(username)) {
            clientInfo = null;
        }

        clientInfo = (clientInfo != null) ? clientInfo : clientInfoService.selectByMemNo(username);

        if (clientInfo == null) {
            return "用户绑定手机号码[" + username + "]不在存";
        }

        if (StringUtils.isEmpty(password)) {
            return "密码不能为空";
        }
//        if (!clientInfo.getPassword().equals(MD5Utils.getMD5(password))) {
//            return "密码不正确";
//        }

        // 设置登录模块并更新
        if (keepLogin != null && !clientInfo.getLoginmode().equalsIgnoreCase(keepLogin)) {
            clientInfo.setLoginmode(keepLogin);
            clientInfoService.updateByPrimaryKeySelective(clientInfo);
        }

        LogicHelper.getUser(request.getSession()).setHasLogin(true);
        return "success";
    }

    /**
     * 登出动作处理
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/logoutAction", method = {RequestMethod.GET, RequestMethod.POST})
    public String logoutAction(ModelMap model, RedirectAttributes attr, HttpServletRequest request, HttpServletResponse response, @PathVariable("shopId") final String shopId) throws IOException {

        HttpSession session = request.getSession();
        User user = LogicHelper.getUser(session);
        attr.addAttribute(SESSION_FANSINFOID_KEY, user.getFansInfo().getPid());
        model.addAttribute(attr);
        user.setHasLogin(false);

        ClientInfo clientInfo = user.getClientInfo();
        clientInfo.setLoginmode(LOGIN_MODE_MANUAL);
        clientInfoService.updateByPrimaryKeySelective(clientInfo);
        return "redirect:/wap/" + shopId;
    }

    /**
     * 注册动作处理
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/registerAction", params = {SESSION_FANSINFOID_KEY}, method = {RequestMethod.GET, RequestMethod.POST})
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
            String fanInfoIdStr = request.getParameter(SESSION_FANSINFOID_KEY);
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
            String clientName = request.getParameter("clientName").trim();
            String address = request.getParameter("address").trim();
            String identityStr = request.getParameter("identity").trim();
            Integer identity = null;

            ClientInfo clientInfo = clientInfoService.selectByMemNo(phone);
            if (clientInfo != null) {
                return "已存在注册用户[" + phone + "]";
            }

            clientInfo = clientInfoService.selectByFanInfoId(fanInfoId);
            if (clientInfo != null) {
                return "已经绑定手机号码[" + clientInfo.getMemberno() + "]";
            }

//            if (!StringUtil.isMatch(PHONE_REGEX_STR, phone)) {
//                return "不是完整的11位手机号或者正确的手机号前七位";
//            }
//
//            if (StringUtils.isEmpty(password)) {
//                return "密码不能为空!";
//            }
//            if (password.length()<=4) {
//                return "密码长度必大于等于4!";
//            }

            if (StringUtils.isNumeric(identityStr)) {
                identity = Integer.valueOf(identityStr);
            }

            clientInfo = new ClientInfo();
            clientInfo.setAddress(address);
            clientInfo.setClientname(clientName);
            clientInfo.setFaninfoid(fansInfo.getPid());
            clientInfo.setEmail(email);
            clientInfo.setMemberno(phone);
            clientInfo.setPassword(MD5Utils.getMD5(password));
            clientInfo.setClienttypeid(identity);

            int success = clientInfoService.insertSelective(clientInfo);
            clientInfo = clientInfoService.selectByMemNo(clientInfo.getMemberno());

            if (success <= 0) throw new BusinessException("插入微餐厅注册用户信息失败～");

            // 刚注册用户将信息保持在session中以保持登录
            User user = new User();
            user.setClientInfo(clientInfo);
            user.setFansInfo(fansInfo);
            request.getSession().setAttribute(SESSION_USER_KEY, user);

            return "success";
        } catch (Exception e) {
            logger.error(ExceptionUtil.getExceptionStackTrace(e));
            return "微餐厅注册用户信息失败，!请联系管理员～";
        }
    }

    /**
     * 对外卖地址的增、删、改
     *
     * @return
     */
    @RequestMapping(value = "/{shopId:[\\S]{1,30}}/addressAction", params = {EDIT_ADDRESS_TYPE}, method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String addressAction(ModelMap model, RedirectAttributes attr, HttpServletRequest request, HttpServletResponse response, @PathVariable("shopId") final String shopId) throws IOException {

//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute(SESSION_USER_KEY);
//        attr.addAttribute(SESSION_FANSINFOID_KEY, user.getFansInfo().getPid());
//        model.addAttribute(attr);
//        session.removeAttribute(SESSION_USER_KEY);

        User user = LogicHelper.getUser(request.getSession());

        Asserter.notNull(user);
        Asserter.notNull(user.getClientInfo());

        String type = request.getParameter("type");
        Asserter.notNull(type);

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String pidStr = request.getParameter("pid");
        Integer pid = null;
        if (StringUtils.isNumeric(pidStr)) {
            pid = Integer.valueOf(pidStr);
        }

        // 增加
        // 更改
        if (type.equalsIgnoreCase(ADDRESS_ADD) || type.equalsIgnoreCase(ADDRESS_UPDATE)) {
            if (StringUtils.hasEmpty(name)) {
                return "联系人不能为空";
            }
            if (StringUtils.hasEmpty(phone)) {
                return "联系电话不能为空";
            }
            if (StringUtils.hasEmpty(address)) {
                return "外卖地址不能为空";
            }

            TakeOutAddress takeOutAddress = new TakeOutAddress();
            takeOutAddress.setAddress(address);
            takeOutAddress.setPhone(phone);
            takeOutAddress.setClientname(name);
            takeOutAddress.setMemberno(user.getClientInfo().getMemberno());
            if (pid == null) {
                takeOutAddressService.insertSelective(takeOutAddress);
            } else {
                takeOutAddress.setPid(pid);
                takeOutAddressService.updateByPrimaryKeySelective(takeOutAddress);
            }
        }

        // 删除
        else if (type.equalsIgnoreCase(ADDRESS_DELETE)) {
            if (pid != null) {
                int count = takeOutAddressService.deleteByPrimaryKey(pid);
                TakeOutAddress addr = takeOutAddressService.selectByPrimaryKey(pid);
                if (addr != null) {
                    logger.info("删除[" + addr.getPhone() + "]的外卖地址数量为" + count);
                }
            }
        } else {
            return "系统错误，没指定操作类型!";
        }

        return "success";
    }


    @Resource
    private ClientInfoService clientInfoService;

    @Resource
    private FansInfoService fansInfoService;

    @Resource
    private TakeOutAddressService takeOutAddressService;
}
