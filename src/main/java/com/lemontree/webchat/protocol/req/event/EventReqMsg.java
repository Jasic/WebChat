package com.lemontree.webchat.protocol.req.event;

import com.lemontree.util.MessageUtil;
import com.lemontree.webchat.protocol.bean.Event;
import com.lemontree.webchat.protocol.req.BaseReqMsg;

/**
 * User: Jasic
 * Date: 13-12-28
 * 事件消息
 */
public abstract class EventReqMsg extends BaseReqMsg {

    public static final String _Event = "Event";


    /**
     * 推送的事件类型
     */
    private Event Event;

    protected EventReqMsg() {
        super();
        super.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_EVENT);
    }

    public Event getEvent() {
        return Event;
    }

    public void setEvent(Event event) {
        this.Event = event;
    }

}
