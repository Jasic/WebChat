package com.lemontree.daemon.dbmgr.model;

public class SubcEventPushMsg {
    private Integer pid;

    private Integer serviceinfoid;

    private String type;

    private Integer msgid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getServiceinfoid() {
        return serviceinfoid;
    }

    public void setServiceinfoid(Integer serviceinfoid) {
        this.serviceinfoid = serviceinfoid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getMsgid() {
        return msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }
}