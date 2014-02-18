package com.lemontree.bean;

import com.lemontree.daemon.dbmgr.model.ClientInfo;
import com.lemontree.daemon.dbmgr.model.FansInfo;

/**
 * 登录用户的内存信息
 */
public class User {

    private Long createTime;
    private Long lastSessionTime;
    private Long validTimeStamp;
    private ClientInfo clientInfo;
    private FansInfo fansInfo;

    public FansInfo getFansInfo() {
        return fansInfo;
    }

    public void setFansInfo(FansInfo fansInfo) {
        this.fansInfo = fansInfo;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getLastSessionTime() {
        return lastSessionTime;
    }

    public void setLastSessionTime(Long lastSessionTime) {
        this.lastSessionTime = lastSessionTime;
    }

    public Long getValidTimeStamp() {
        return validTimeStamp;
    }

    public void setValidTimeStamp(Long validTimeStamp) {
        this.validTimeStamp = validTimeStamp;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }
}
