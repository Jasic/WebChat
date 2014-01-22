package com.lemontree.test;

import com.lemontree.webchat.protocol.bean.*;
import com.lemontree.webchat.protocol.resp.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.lemontree.util.MessageUtil.*;

/**
 * User: Jasic
 * Date: 13-12-29
 */
public class TestMessageUtil {

    /**
     * <xml>
     * <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime>
     * <MsgType><![CDATA[text]]></MsgType>
     * <Content><![CDATA[你好]]></Content>
     * </xml>
     */
    @Test
    public void testText2Xml() {
        TextRespMsg textRespMsg = new TextRespMsg();
        textRespMsg.setToUserName("toUser");
        textRespMsg.setFromUserName("fromUser");
        textRespMsg.setCreateTime(12345678);
        textRespMsg.setMsgType("text");
        textRespMsg.setContent("你好");

        System.out.println(textMessageToXml(textRespMsg));
    }


    @Test
    public void testImage2Xml() {
        ImageRespMsg imageRespMsg = new ImageRespMsg();
        imageRespMsg.setToUserName("toUser");
        imageRespMsg.setFromUserName("fromUser");
        imageRespMsg.setCreateTime(12345678);

        Image image1 = new Image();
        image1.setMediaId("1");

        imageRespMsg.setImage(image1);

        System.out.println(imageMessageToXml(imageRespMsg));
    }

    @Test
    public void testVoice2Xml() {
        VoiceRespMsg voiceRespMsg = new VoiceRespMsg();
        voiceRespMsg.setToUserName("toUser");
        voiceRespMsg.setFromUserName("fromUser");
        voiceRespMsg.setCreateTime(12345678);

        Voice voice = new Voice();
        voice.setMediaId("m");

        voiceRespMsg.setVoice(voice);

        System.out.println(voiceMessageToXml(voiceRespMsg));
    }


    @Test
    public void testVideo2Xml() {

        VideoRespMsg videoRespMsg = new VideoRespMsg();
        videoRespMsg.setToUserName("toUser");
        videoRespMsg.setFromUserName("fromUser");
        videoRespMsg.setCreateTime(12345678);

        Video video = new Video();
        video.setMediaId("MediaID");
        video.setDescription("这是一个描述");
        video.setTitle("视频的标题");

        videoRespMsg.setVideo(video);
        System.out.println(videoMessageToXml(videoRespMsg));
    }

    @Test
    public void testMusic2Xml() {
        MusicRespMsg musicRespMsg = new MusicRespMsg();
        musicRespMsg.setToUserName("toUser");
        musicRespMsg.setFromUserName("fromUser");
        musicRespMsg.setCreateTime(12345678);

        Music music = new Music();
        music.setDescription("音乐描述");
        music.setTitle("音乐标题");
        music.setHQMusicUrl("高清音乐地址");
        music.setMusicUrl("普通音乐地址");
        music.setThumbMediaId("音乐缩略图");

        musicRespMsg.setMusic(music);

        System.out.println(musicMessageToXml(musicRespMsg));
    }

    @Test
    public void testNews2Xml() {
        NewsRespMsg newsRespMsg = new NewsRespMsg();
        newsRespMsg.setToUserName("toUser");
        newsRespMsg.setFromUserName("fromUser");
        newsRespMsg.setCreateTime(12345678);

        List<Article> articles = new ArrayList<Article>();
        Article a1 = new Article();
        a1.setTitle("图文件1的标题");
        a1.setDescription("图文1的描述");
        a1.setPicUrl("图文1的图片url");
        a1.setUrl("图文1的url");

        Article a2 = new Article();
        a2.setTitle("图文件2的标题");
        a2.setDescription("图文2的描述");
        a2.setPicUrl("图文2的图片url");
        a2.setUrl("图文2的url");

        articles.add(a1);
        articles.add(a2);

        newsRespMsg.setArticleCount(articles.size());
        newsRespMsg.setArticles(articles);

        System.out.println(newsMessageToXml(newsRespMsg));
    }
}
