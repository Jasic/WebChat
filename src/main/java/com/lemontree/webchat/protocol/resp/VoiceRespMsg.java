package com.lemontree.webchat.protocol.resp;

import com.lemontree.util.MessageUtil;
import com.lemontree.webchat.protocol.bean.Voice;

/**
 * User: Jasic
 * Date: 13-12-29
 * 回复语音消息
 */
public class VoiceRespMsg extends BaseRespMsg {

    public static final String _Voice = "Voice";
    private Voice Voice;

    public VoiceRespMsg() {
        super();
        super.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_VOICE);
    }

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}
