package com.lemontree.daemon.dbmgr.model;

import java.util.Date;
import java.util.List;

public class ServiceInfo {

    // 一对多
    private List<FansInfo> fansInfoList;

    public List<FansInfo> getFansInfoList() {
        return fansInfoList;
    }

    public void setFansInfoList(List<FansInfo> fansInfoList) {
        this.fansInfoList = fansInfoList;
    }

    // one 2 one
    private RestaurantInfo restaurantInfo;

    public RestaurantInfo getRestaurantInfo() {
        return restaurantInfo;
    }

    public void setRestaurantInfo(RestaurantInfo restaurantInfo) {
        this.restaurantInfo = restaurantInfo;
    }

    private Integer pid;

    private Integer restid;

    private String webchatid;

    private String url;

    private String token;

    private Date bounddate;

    private String status;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getRestid() {
        return restid;
    }

    public void setRestid(Integer restid) {
        this.restid = restid;
    }

    public String getWebchatid() {
        return webchatid;
    }

    public void setWebchatid(String webchatid) {
        this.webchatid = webchatid == null ? null : webchatid.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getBounddate() {
        return bounddate;
    }

    public void setBounddate(Date bounddate) {
        this.bounddate = bounddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();


    }


}
