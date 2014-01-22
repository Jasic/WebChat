package com.lemontree.daemon.dbmgr.model;

import java.util.List;

public class RestaurantInfo {

    private RestaurantGroup group;

    public RestaurantGroup getGroup() {
        return group;
    }

    public void setGroup(RestaurantGroup group) {
        this.group = group;
    }

    // one 2 many
    private List<ServiceInfo> serviceInfos;

    public List<ServiceInfo> getServiceInfos() {
        return serviceInfos;
    }

    public void setServiceInfos(List<ServiceInfo> serviceInfos) {
        this.serviceInfos = serviceInfos;
    }

    // one 2 many
    private List<AdvertisedSchedule> advertisedSchedules;

    public List<AdvertisedSchedule> getAdvertisedSchedules() {
        return advertisedSchedules;
    }

    public void setAdvertisedSchedules(List<AdvertisedSchedule> advertisedSchedules) {
        this.advertisedSchedules = advertisedSchedules;
    }

    private Integer pid;

    private Integer groupid;

    private String shopid;

    private String name;

    private String address;

    private String phone;

    private String position;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid == null ? null : shopid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }
}