package com.lemontree.daemon.dbmgr.model;

/**
 * User: Jasic
 * Date: 14-1-7
 */
public class EventPushMsg extends DBPojo {

    /**
     * 标识符id
     */
    private Integer PID;

    /**
     * 服务号表的ID
     */
    private Integer ServiceID;

    /**
     * 事件类型
     * E001：关注事件
     * E002：点击事件
     */
    private String Type;

    /**
     * 推送的内容
     */
    private String PushContent;

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public Integer getServiceID() {
        return ServiceID;
    }

    public void setServiceID(Integer serviceID) {
        ServiceID = serviceID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPushContent() {
        return PushContent;
    }

    public void setPushContent(String pushContent) {
        PushContent = pushContent;
    }
}
