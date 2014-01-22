package com.lemontree.webchat.protocol.resp;

import com.lemontree.util.MessageUtil;
import com.lemontree.webchat.protocol.bean.Image;

/**
 * User: Jasic
 * Date: 13-12-29
 * 回复图片消息
 */
public class ImageRespMsg extends BaseRespMsg {

    public static final String _Image = "Image";

    private Image Image;

    public ImageRespMsg() {
        super();
        super.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_IMAGE);
    }

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        this.Image = image;
    }
}
