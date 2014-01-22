package com.lemontree.daemon.domm.cmd;

/**
 * Author Jasic
 * Date 13-12-17.
 * <p/>
 * 命令集合
 */
public enum Command {

    CXWMJL(1, "查询外卖记录"),
    BJWMJL(2, "标记外卖记录"),
    CXYDJL(3, "查询预订记录"),
    BJYDJL(4, "标记预订记录"),
    CXWXYHJL(5, "查询微信用户记录"),
    BJWXYHJL(6, "标记微信用户记录"),
    FSXX(7, "发送消息"),
    CXXXFSJL(8, "查询消息发送记录"),
    CXXXFS(9, "标记消息发送记录"),
    ZJWXSH(10, "增加微信商户");


    private Integer id;

    private String explain;

    Command(Integer id, String explain) {

        this.id = id;
        this.explain = explain;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    @Override
    public String toString() {
        return "API[" + id + "]->" + explain;
    }
}
