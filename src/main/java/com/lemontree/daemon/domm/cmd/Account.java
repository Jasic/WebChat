package com.lemontree.daemon.domm.cmd;

/**
 * Created by JasicMacBook on 13-12-15.
 * 后台命令的登录用户
 */
public class Account {

    /**
     * 商户id
     */
    private String ShopID;

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public String getShopID() {
        return ShopID;
    }

    public void setShopID(String shopID) {
        ShopID = shopID;
    }

    /**
     * 登录密码
     */
    private String Pwd;


}
