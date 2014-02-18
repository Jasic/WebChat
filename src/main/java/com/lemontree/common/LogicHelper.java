package com.lemontree.common;

import cn.tisson.framework.utils.JsonUtils;
import com.lemontree.daemon.dbmgr.model.RestaurantInfo;
import com.lemontree.webchat.entity.BaseRespond;
import com.lemontree.webchat.entity.ErrorRespond;
import com.lemontree.webchat.entity.TokenRespond;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jasic.util.ExceptionUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.Collection;

/**
 * User: Jasic
 * Date: 13-12-4
 */
public class LogicHelper {

    @Test
    public static boolean login() {
        try {
            String respStr = login(WEI_XIN_INTERFACE_APPID, WEI_XIN_INTERFACE_SECRET);
            BaseRespond resp = analyseRespCode(respStr);

            if (resp instanceof TokenRespond) {
                GlobalVariables.GLOBAL_TOKEN_RESPOND = (TokenRespond) resp;
                return true;
            } else if (resp instanceof ErrorRespond) {
                GlobalVariables.GLOBAL_TOKEN_RESPOND = null;
                return false;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static String WEI_XIN_INTERFACE_APPID = "wx39b31e79637b8e77";
    public static String WEI_XIN_INTERFACE_SECRET = "f4b1fab0c5653b2bd89b299f0446f79e";


    /**
     * 登录
     *
     * @param appid
     * @param secet
     * @return
     * @throws java.io.IOException
     */
    public static String login(String appid, String secet) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
        url = String.format(url, new Object[]{appid, secet});
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        HttpResponse response = client.execute(get);
        return EntityUtils.toString(response.getEntity());
    }

    /**
     * 将响应的json转化为实体
     *
     * @param entityStr
     * @return
     */
    public static BaseRespond analyseRespCode(String entityStr) {
        TokenRespond token = JsonUtils.parseToObject(entityStr, TokenRespond.class);
        System.out.println(LogicHelper.class + "----:" + entityStr);
        if (token.getAccess_token() != null && token.getExpires_in() != null) {
            return token;
        } else {
            ErrorRespond error = JsonUtils.parseToObject(entityStr, ErrorRespond.class);
            if (error.getErrcode() == null || error.getErrmsg() == null) {
                throw new RuntimeException("Can't analyse the respond's code[" + entityStr + "] to a token or a ErrorRespond");
            }
            return error;
        }
    }


    /**
     * 根据tooken拼接微信接入url
     *
     * @param token
     * @return
     */
    public static String getWebchatPath(String token) {

        return GlobalVariables.PATH_WEB_CHAT_TOKEN + "/" + token;
    }


    /**
     * @param detail
     * @param e
     * @return
     */
    public static String getTerminalProcessDetail(String detail, Exception e) {
        return detail + e == null ? "" : (!GlobalVariables.TERMIAL_EXEPTION_MSG_LOG_FLAG ? "" : ExceptionUtil.getStackTrace(e));
    }

    /**
     * 根据商店id位商店获得广告
     */
    public static RestaurantInfo findResturant(String shopId) {

        Collection<RestaurantInfo> rests = GlobalCaches.DB_CACHE_RESTAURANT_INFO.values();

        for (RestaurantInfo info : rests) {
            if (info.getShopid().trim().equalsIgnoreCase(shopId)) {
                return info;
            }
        }

        return null;
    }
}
