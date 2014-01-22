package com.lemontree.daemon.dbmgr.model;

public class Article {
    private Integer pid;

    private Integer newsmsgid;

    private String title;

    private String description;

    private String picurl;

    private String url;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getNewsmsgid() {
        return newsmsgid;
    }

    public void setNewsmsgid(Integer newsmsgid) {
        this.newsmsgid = newsmsgid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}