package com.lemontree.webchat.protocol.resp;

import com.lemontree.util.MessageUtil;
import com.lemontree.webchat.protocol.bean.Music;

/**
 * 音乐消息
 *
 * @author liufeng
 * @date 2013-05-19
 */
public class MusicRespMsg extends BaseRespMsg {

    public static final String _Music = "Music";
    // 音乐
    private Music Music;

    public MusicRespMsg() {
        super();
        super.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_MUSIC);
    }

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
