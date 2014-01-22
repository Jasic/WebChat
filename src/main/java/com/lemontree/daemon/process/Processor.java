package com.lemontree.daemon.process;

import cn.tisson.framework.utils.JsonUtils;
import com.lemontree.common.GlobalConstants;
import com.lemontree.common.GlobalVariables;
import com.lemontree.daemon.domm.cmd.*;
import com.lemontree.daemon.domm.reslt.BaseReslt;
import com.lemontree.daemon.process.cmdHandler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Author Jasic
 * Date 13-12-17.
 */
@Service
@Lazy
public class Processor {

    /**
     * 1、提取外卖
     * 2、标记外卖
     */
    @Autowired
    private PullTakeOutListHandler pullTakeOutListHandler;
    @Autowired
    private PushTakeOutListHandler pushTakeOutListHandler;

    /**
     * 1、提取订单
     * 2、标记订单
     */
    @Autowired
    private PullBookListHandler pullBookListHandler;
    @Autowired
    private PushBookListtHandler pushBookListHandler;

    /**
     * 1、提取关注用户
     * 2、标志已关注用户
     */
    @Autowired
    private PullFollowersHandler pullFollowersHandler;
    @Autowired
    private PushFollowersHandler pushFollowersHandler;

    /**
     * 1、推送模版短信
     * 2、查询模版短信
     * 3、标志模版短信
     */
    @Autowired
    private PushTemplateMsgHandler pushTemplateMsgHandler;
    @Autowired
    private QuerySentMsgHandler querySentMsgCmddHandler;
    @Autowired
    private PullTemplateMsgHandler pullTemplateMsgHandler;

    /**
     * 1、推送与餐厅关联的微信号信息
     */
    @Autowired
    private PushServiceInfoHandler pushServiceInfoHandler;


    public BaseReslt process(BaseCmd cmd) {

        switch (cmd.getCmd()) {

            // 查询外卖记录
            case CXWMJL: {

                return pullTakeOutListHandler.handle(JsonUtils.parseToObject(cmd.getJsonStr(), PullTakeOutListCmd.class));
            }

            // 标记外卖记录
            case BJWMJL: {

                return pushTakeOutListHandler.handle(JsonUtils.parseToObject(cmd.getJsonStr(), PushTakeOutListCmd.class));
            }

            // 查询预订记录
            case CXYDJL: {

                return pullBookListHandler.handle(JsonUtils.parseToObject(cmd.getJsonStr(), PullBookListCmd.class));
            }

            // 标记预订记录
            case BJYDJL: {

                return pushBookListHandler.handle(JsonUtils.parseToObject(cmd.getJsonStr(), PushBookListCmd.class));
            }

            // 查询微信用户记录
            case CXWXYHJL: {

                return pullFollowersHandler.handle(JsonUtils.parseToObject(cmd.getJsonStr(), PullFollowersCmd.class));
            }

            // 标记微信用户记录
            case BJWXYHJL: {

                return pushFollowersHandler.handle(JsonUtils.parseToObject(cmd.getJsonStr(), PushFollowersCmd.class));
            }

            // 发送消息
            case FSXX: {

                return pushTemplateMsgHandler.handle(JsonUtils.parseToObject(cmd.getJsonStr(), PushTemplateMsgCmd.class));
            }

            // 查询消息发送记录
            case CXXXFSJL: {

                return querySentMsgCmddHandler.handle(JsonUtils.parseToObject(cmd.getJsonStr(), QuerySentMsgCmd.class));
            }

            // 标记消息发送记录
            case CXXXFS: {

                return pullTemplateMsgHandler.handle(JsonUtils.parseToObject(cmd.getJsonStr(), PullTemplateMsgCmd.class));
            }

            // 增加微信商户
            case ZJWXSH: {

                return pushServiceInfoHandler.handle(JsonUtils.parseToObject(cmd.getJsonStr(), PushServiceInfoCmd.class));
            }

            default: {
                BaseReslt reslt = new BaseReslt();
                reslt.setCode(GlobalConstants.HANDLE_CMD_NOT_EXIST);
                reslt.setDetail(GlobalVariables.DAEMON_HANDLE_CMD_CODE_MAP.get(GlobalConstants.HANDLE_CMD_NOT_EXIST));
                return reslt;
            }
        }

    }

    public void setPullTakeOutListHandler(PullTakeOutListHandler pullTakeOutListHandler) {
        this.pullTakeOutListHandler = pullTakeOutListHandler;
    }

    public void setPushTakeOutListHandler(PushTakeOutListHandler pushTakeOutListHandler) {
        this.pushTakeOutListHandler = pushTakeOutListHandler;
    }

    public void setPullBookListHandler(PullBookListHandler pullBookListHandler) {
        this.pullBookListHandler = pullBookListHandler;
    }

    public void setPushBookListHandler(PushBookListtHandler pushBookListHandler) {
        this.pushBookListHandler = pushBookListHandler;
    }

    public void setPullFollowersHandler(PullFollowersHandler pullFollowersHandler) {
        this.pullFollowersHandler = pullFollowersHandler;
    }

    public void setPushFollowersHandler(PushFollowersHandler pushFollowersHandler) {
        this.pushFollowersHandler = pushFollowersHandler;
    }

    public void setPushTemplateMsgHandler(PushTemplateMsgHandler pushTemplateMsgHandler) {
        this.pushTemplateMsgHandler = pushTemplateMsgHandler;
    }

    public void setQuerySentMsgCmddHandler(QuerySentMsgHandler querySentMsgCmddHandler) {
        this.querySentMsgCmddHandler = querySentMsgCmddHandler;
    }

    public void setPullTemplateMsgHandler(PullTemplateMsgHandler pullTemplateMsgHandler) {
        this.pullTemplateMsgHandler = pullTemplateMsgHandler;
    }

    public void setPushServiceInfoHandler(PushServiceInfoHandler pushServiceInfoHandler) {
        this.pushServiceInfoHandler = pushServiceInfoHandler;
    }
}
