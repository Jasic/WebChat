package com.lemontree.daemon.dbmgr.model;

import java.util.Date;

public class FansInfo {

    private ServiceInfo serviceInfo;

    public ServiceInfo getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(ServiceInfo serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    private Integer pid;

    private String webchatid;

    private Integer serviceinfoid;

    private String fanname;

    private String address;

    private String sex;

    private Date focustime;

    private Integer focustype;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getWebchatid() {
        return webchatid;
    }

    public void setWebchatid(String webchatid) {
        this.webchatid = webchatid == null ? null : webchatid.trim();
    }

    public Integer getServiceinfoid() {
        return serviceinfoid;
    }

    public void setServiceinfoid(Integer serviceinfoid) {
        this.serviceinfoid = serviceinfoid;
    }

    public String getFanname() {
        return fanname;
    }

    public void setFanname(String fanname) {
        this.fanname = fanname == null ? null : fanname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getFocustime() {
        return focustime;
    }

    public void setFocustime(Date focustime) {
        this.focustime = focustime;
    }

    public Integer getFocustype() {
        return focustype;
    }

    public void setFocustype(Integer focustype) {
        this.focustype = focustype;
    }
}