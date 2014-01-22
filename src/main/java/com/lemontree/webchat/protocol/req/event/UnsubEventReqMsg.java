package com.lemontree.webchat.protocol.req.event;

/**
 * User: Jasic
 * Date: 13-12-28
 * unsubscribe(取消订阅)
 */
public class UnsubEventReqMsg extends EventReqMsg {
    public UnsubEventReqMsg() {
        super();
        super.setEvent(com.lemontree.webchat.protocol.bean.Event.unsubscribe);
    }
}
