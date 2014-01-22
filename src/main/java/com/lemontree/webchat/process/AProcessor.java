package com.lemontree.webchat.process;

import com.lemontree.common.GlobalVariables;
import com.lemontree.webchat.protocol.req.BaseReqMsg;
import com.lemontree.webchat.protocol.req.event.EventReqMsg;
import com.lemontree.webchat.protocol.resp.BaseRespMsg;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * User: Jasic
 * Date: 13-12-28
 * <p/>
 * 事件处理器
 * 由于微信的请求与对应的响应并不一定要一致的，所以只返回基础的响应消息
 * （例如：TextReqMsg请求的响应并不确定，有可能是MusicRespMsg也有可能是NewsRespMsg）
 */
public abstract class AProcessor<E extends BaseReqMsg> {

    protected abstract BaseRespMsg doProcess(E msg);

    protected abstract List<Object> getExcludeDuplicate();

    private Timer timer;

    public AProcessor() {

        timer = new Timer("微信消息排重");
    }

    /**
     * 做过滤工作
     *
     * @return
     */
    protected boolean beforeProcess(E msg) {

        /**
         * 第一步
         */
        boolean step1;
        Object key = null;
        // 微信服务器在五秒内收不到响应会断掉连接，并且重新发起请求，总共重试三次，
        // 关于重试的消息排重，有msgid的消息推荐使用msgid排重。事件类型消息推荐使用FromUserName + CreateTime 排重。

        if (msg instanceof EventReqMsg) {
            key = msg.getFromUserName() + "_" + msg.getToUserName();
        } else {
            key = msg.getMsgId() + "";
        }
        step1 = !getExcludeDuplicate().contains(key);
        if (step1 && key != null) getExcludeDuplicate().add(key);

        /**
         * 第二步
         */
        boolean step2 = true;
        System.out.println("step1:" + step1);

        return step1 && step2;
    }


    /**
     * 做收尾工作
     *
     * @return
     */
    protected void afterProcess(E msg) {
        Object key;
        if (msg instanceof EventReqMsg) {
            key = msg.getFromUserName() + "_" + msg.getToUserName();
        } else {
            key = msg.getMsgId() + "";
        }

        List<Object> keys = getExcludeDuplicate();
        if (key != null) {
            TimerTask task = new RemoveTask(keys, key);
            timer.schedule(task, GlobalVariables.WEB_CHAT_EXCLUDE_DUPLICATE_DELAY * 1000);
        }

    }

    /**
     * 供外部调用
     *
     * @param msg
     */
    public BaseRespMsg process(E msg) {
        BaseRespMsg respMsg = null;
        if (beforeProcess(msg)) {
            respMsg = doProcess(msg);
        }

        afterProcess(msg);

        return respMsg;
    }

    /**
     * 删除排重键
     */
    private class RemoveTask extends TimerTask {
        Object key;
        List<Object> keys;

        private RemoveTask(List<Object> keys, Object key) {
            this.key = key;
            this.keys = keys;
        }

        @Override
        public void run() {
            keys.remove(key);
        }
    }

}
