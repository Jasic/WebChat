package com.lemontree.daemon.domm.reslt;

/**
 * Author Jasic
 * Date 13-12-15.
 * 执行命令响应的基础结果
 */
public class BaseReslt {

    /**
     * 执行命令结果代码
     */
    private String Code;

    /**
     * 失败原因
     */
    private String Detail;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }
}
