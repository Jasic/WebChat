package com.lemontree.webchat.protocol.resp;

import com.lemontree.util.MessageUtil;
import com.lemontree.webchat.protocol.bean.Video;

/**
 * User: Jasic
 * Date: 13-12-29
 * 回复视频消息
 */
public class VideoRespMsg extends BaseRespMsg {

    public static final String _Video = "Video";
    private Video Video;

    public VideoRespMsg() {
        super();
        super.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_VIDEO);
    }

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }
}
