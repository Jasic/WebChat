package com.lemontree.daemon.dbmgr.model;

public class AdvertisementInfo {
    private Integer pid;

    private String imgurl;

    private String forwardurl;

    private String description;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public String getForwardurl() {
        return forwardurl;
    }

    public void setForwardurl(String forwardurl) {
        this.forwardurl = forwardurl == null ? null : forwardurl.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}