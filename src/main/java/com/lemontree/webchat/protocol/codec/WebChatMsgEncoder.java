package com.lemontree.webchat.protocol.codec;

import com.lemontree.util.MessageUtil;
import com.lemontree.webchat.protocol.resp.*;
import org.jasic.util.Asserter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

/**
 * User: Jasic
 * Date: 13-12-28
 */
@Component("WebChatMsgEncoder")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.DEFAULT)
public class WebChatMsgEncoder<M extends BaseRespMsg> {

    private Charset charset;

    public WebChatMsgEncoder() {

        this(Charset.defaultCharset());
    }

    public WebChatMsgEncoder(Charset charset) {
        Asserter.notNull(charset);
        this.charset = charset;
    }

    /**
     * 将实体转换xml
     *
     * @param msg
     * @return
     */
    public String encode(M msg) {
        String msgType = msg.getMsgType();

        String resp = "";

        /**
         * 回复文本消息
         */
        if (msgType.equals(MessageUtil.RESP_MESSAGE_TYPE_TEXT)) {
            resp = MessageUtil.textMessageToXml((TextRespMsg) msg);
        }

        /**
         * 回复图片消息
         */
        else if (msgType.equals(MessageUtil.RESP_MESSAGE_TYPE_IMAGE)) {
            resp = MessageUtil.imageMessageToXml((ImageRespMsg) msg);
        }

        /**
         * 回复语音消息
         */
        else if (msgType.equals(MessageUtil.RESP_MESSAGE_TYPE_VOICE)) {
            resp = MessageUtil.voiceMessageToXml((VoiceRespMsg) msg);
        }

        /**
         * 回复视频消息
         */
        else if (msgType.equals(MessageUtil.RESP_MESSAGE_TYPE_VIDEO)) {
            resp = MessageUtil.videoMessageToXml((VideoRespMsg) msg);
        }
        /**
         * 回复音乐消息
         */
        else if (msgType.equals(MessageUtil.RESP_MESSAGE_TYPE_MUSIC)) {
            resp = MessageUtil.musicMessageToXml((MusicRespMsg) msg);
        }

        /**
         * 回复图文消息
         */
        else if (msgType.equals(MessageUtil.RESP_MESSAGE_TYPE_NEWS)) {
            resp = MessageUtil.newsMessageToXml((NewsRespMsg) msg);
        }
        return resp;
    }
}
