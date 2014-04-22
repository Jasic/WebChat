package com.lemontree.webchat.process;

import com.lemontree.common.GlobalCaches;
import com.lemontree.daemon.dbmgr.model.*;
import com.lemontree.daemon.dbmgr.service.FansInfoService;
import com.lemontree.util.MessageUtil;
import com.lemontree.util.SpringContextUtil;
import com.lemontree.webchat.protocol.bean.Article;
import com.lemontree.webchat.protocol.bean.Event;
import com.lemontree.webchat.protocol.req.event.EventReqMsg;
import com.lemontree.webchat.protocol.req.event.ScanNotSubEventReqMsg;
import com.lemontree.webchat.protocol.req.event.SubEventReqMsg;
import com.lemontree.webchat.protocol.req.event.UnsubEventReqMsg;
import com.lemontree.webchat.protocol.resp.BaseRespMsg;
import com.lemontree.webchat.protocol.resp.NewsRespMsg;
import com.lemontree.webchat.protocol.resp.TextRespMsg;
import org.jasic.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: Jasic
 * Date: 13-12-28
 * 事件处理
 */
public class EventReqProcessor extends AProcessor<EventReqMsg> {

    private static final Logger logger = LoggerFactory.getLogger(EventReqProcessor.class);

    /**
     * 每个处理器，有且只有全局的一个排重的容器
     */
    private static final List<Object> EXCLUDE_DUPLICATE_LIST = new ArrayList<Object>();

    @Override
    protected List<Object> getExcludeDuplicate() {
        return EXCLUDE_DUPLICATE_LIST;
    }

    @Override
    protected BaseRespMsg doProcess(EventReqMsg msg) {

        BaseRespMsg respMsg = null;

        String content = "这个响应不存在";
        Event event = msg.getEvent();


        switch (event) {
            // 订阅
            case subscribe: {

                SubEventReqMsg subMsg = (SubEventReqMsg) msg;
                if (msg instanceof ScanNotSubEventReqMsg) {
                    // TODO 可获取二维码的ticket，可用来换取二维码图片
                }

                //保存关注用户记录
                ServiceInfo serviceInfo = saveSubscribeUser(subMsg);

                // 处理关注事件
                if (serviceInfo != null) respMsg = handleSubEvent(subMsg, serviceInfo);
                break;
            }
            //取消订阅
            case unsubscribe: {

                // 取消关注不需返回响应
                doUnsubscribe((UnsubEventReqMsg) msg);
                break;
            }

            // 已关注扫描
            case scan: {

                break;
            }

            // 上报地理位置
            case LOCATION: {

                break;
            }

            // 点击菜单
            case CLICK: {

                break;
            }
        }

        return respMsg;
    }


    /**
     * 处理用户关注的行为
     *
     * @param subMsg
     */
    private ServiceInfo saveSubscribeUser(SubEventReqMsg subMsg) {
        FansInfoService fansInfoService = SpringContextUtil.getBean(FansInfoService.class);
        Map<String, ServiceInfo> serviceInfoMap = GlobalCaches.DB_CACHE_SERVICE_INFO;
        String fromUserName = subMsg.getFromUserName().trim();
        String toUserName = subMsg.getToUserName().trim();
        Long createTime = subMsg.getCreateTime();
        String ev = subMsg.getEvent().name().trim();

        ServiceInfo serviceInfo = serviceInfoMap.get(toUserName);

        // 存在服务号码则保存关注用户
        if (serviceInfo != null) {
            FansInfo fan = new FansInfo();
            fan.setServiceinfoid(serviceInfo.getPid());
            fan.setWebchatid(fromUserName);

            try {
                FansInfo temp = fansInfoService.selectByWebChatID(fan.getWebchatid());
                if (temp == null) {
                    fansInfoService.insertSelective(fan);
                }
                return serviceInfo;
            } catch (Exception e) {
                logger.error("Save a focus fan fail! " + ExceptionUtil.getStackTrace(e));

                return null;
                // TODO 记录在失败文件中
            }
        } else {
            // TODO 服务号已不存在或者分店用户服务到期则不提供服务
            logger.error("服务号[" + toUserName + "]没有配置");
            return null;
        }
    }


    /**
     * 处理关注事件
     *
     * @param msg
     * @return
     */
    private BaseRespMsg handleSubEvent(SubEventReqMsg msg, ServiceInfo info) {

        // 用户关注了则同时向其推送重要广告
        Integer serviceInfoId = info.getPid();


        SubcEventPushMsg subcEventPushMsg = GlobalCaches.DB_CACHE_SUBC_EVENT_PUSH_MSG.get(info.getPid());

        String type = subcEventPushMsg.getType().toLowerCase().trim();
        Integer msgId = subcEventPushMsg.getMsgid();

        BaseRespMsg respMsg = null;

        /**
         * 图文
         */
        if (type.equals(MessageUtil.RESP_MESSAGE_TYPE_NEWS.toLowerCase().trim())) {

            NewsRespMsg newsRespMsg = new NewsRespMsg();
            newsRespMsg.setFromUserName(msg.getToUserName());
            newsRespMsg.setToUserName(msg.getFromUserName());
            newsRespMsg.setCreateTime(System.currentTimeMillis() / 1000);


            NewsMsg newsMsg = GlobalCaches.DB_CACHE_NEWS_MSG.get(msgId);
            List<com.lemontree.daemon.dbmgr.model.Article> articles = newsMsg.getArticles();

            List<Article> arts = new ArrayList<Article>();
            for (com.lemontree.daemon.dbmgr.model.Article article : articles) {
                Article a = new Article();
                a.setUrl(article.getUrl());
                a.setDescription(article.getDescription());
                a.setPicUrl(article.getPicurl());
                a.setTitle(article.getTitle());
                arts.add(a);
            }

            newsRespMsg.setArticles(arts);
            newsRespMsg.setArticleCount(arts.size());

            respMsg = newsRespMsg;
        }

        /**
         * 文字（在数据库配置默认的规则）
         */
        else if (type.equals(MessageUtil.RESP_MESSAGE_TYPE_TEXT.toLowerCase().trim())) {

            TextRespMsg textRespMsg = new TextRespMsg();
            textRespMsg.setFromUserName(msg.getToUserName());
            textRespMsg.setToUserName(msg.getFromUserName());
            textRespMsg.setCreateTime(System.currentTimeMillis() / 1000);
            Text text = GlobalCaches.DB_CACHE_TEXT_MSG.get(msgId);
            textRespMsg.setContent(text.getContent());
            respMsg = textRespMsg;
        }

        /**
         * 设置默认的
         */
        else {
            TextRespMsg textRespMsg = new TextRespMsg();
            textRespMsg.setFromUserName(msg.getToUserName());
            textRespMsg.setToUserName(msg.getFromUserName());
            textRespMsg.setCreateTime(System.currentTimeMillis() / 1000);
            textRespMsg.setContent("欢迎注注[" + info.getRestaurantInfo().getName() + "]");
            respMsg = textRespMsg;
        }

        if (respMsg == null) {
            TextRespMsg textRespMsg = new TextRespMsg();
            textRespMsg.setFromUserName(msg.getToUserName());
            textRespMsg.setToUserName(msg.getFromUserName());
            textRespMsg.setCreateTime(System.currentTimeMillis() / 1000);
            textRespMsg.setContent("没有配置[" + msg.getToUserName() + "]的关注回复信息");
            respMsg = textRespMsg;
        }

        return respMsg;
    }


    /**
     * 处理用户取消关注的行为
     *
     * @param unsubMsg
     */
    private void doUnsubscribe(UnsubEventReqMsg unsubMsg) {

        String fromUser = unsubMsg.getFromUserName();
        FansInfoService fansInfoService = SpringContextUtil.getBean(FansInfoService.class);

        fansInfoService.deleteByWebChatID(fromUser);
    }
}
