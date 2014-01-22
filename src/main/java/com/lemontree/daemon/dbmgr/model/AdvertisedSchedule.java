package com.lemontree.daemon.dbmgr.model;

import java.util.Date;

public class AdvertisedSchedule {

    private AdvertisementInfo advertisementInfo;


    public AdvertisementInfo getAdvertisementInfo() {
        return advertisementInfo;
    }

    public void setAdvertisementInfo(AdvertisementInfo advertisementInfo) {
        this.advertisementInfo = advertisementInfo;
    }


    private Integer pid;

    private String shopid;

    private Integer adverid;

    private Integer priority;

    private Date begintime;

    private Date endtime;

    private String status;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid == null ? null : shopid.trim();
    }

    public Integer getAdverid() {
        return adverid;
    }

    public void setAdverid(Integer adverid) {
        this.adverid = adverid;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}