package com.lemontree.webchat.protocol.resp;

import com.lemontree.util.MessageUtil;
import com.lemontree.webchat.protocol.bean.Article;

import java.util.List;

/**
 * 回复图文消息
 *
 * @author liufeng
 * @date 2013-05-19
 */
public class NewsRespMsg extends BaseRespMsg {

    public static final String _ArticleCount = "ArticleCount";
    public static final String _Articles = "Article";


    // 图文消息个数，限制为10条以内
    private int ArticleCount;
    // 多条图文消息信息，默认第一个item为大图
    private List<Article> Articles;

    public NewsRespMsg() {
        super();
        super.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
    }

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }
}
