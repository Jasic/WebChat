package com.lemontree.daemon.domm.cmd;

/**
 * Author Jasic
 * Date 13-12-15.
 * API 007 发送消息
 * 商户发送营销消息
 */
public class PushTemplateMsgCmd extends BaseCmd {

    /**
     * 是否发送给所有客户，如果为ture则其它两个字段为空
     */

    private boolean toAllUser;

    /**
     * 消息接受者
     */
    private String followerId;

    /**
     * 模版本信息
     */
    private String templateMsg;

    public boolean isToAllUser() {
        return toAllUser;
    }

    public void setToAllUser(boolean toAllUser) {
        this.toAllUser = toAllUser;
    }

    public String getFollowerId() {
        return followerId;
    }

    public void setFollowerId(String followerId) {
        this.followerId = followerId;
    }

    public String getTemplateMsg() {
        return templateMsg;
    }

    public void setTemplateMsg(String templateMsg) {
        this.templateMsg = templateMsg;
    }
}
