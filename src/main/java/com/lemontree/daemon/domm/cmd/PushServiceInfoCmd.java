package com.lemontree.daemon.domm.cmd;

/**
 * User: Jasic
 * Date: 14-1-2
 * 增加微信商户基础数据命令
 */
public class PushServiceInfoCmd extends BaseCmd {

    /**
     * 微信号
     */
    private String WebChatID;

    /**
     * 操作
     */
    private PushServiceOper Oper;

    public PushServiceOper getOper() {
        return Oper;
    }

    public void setOper(PushServiceOper oper) {
        Oper = oper;
    }

    public String getWebChatID() {
        return WebChatID;
    }

    public void setWebChatID(String webChatID) {
        WebChatID = webChatID;
    }

    public enum PushServiceOper {
        BIND, UNBIND;
    }
}
