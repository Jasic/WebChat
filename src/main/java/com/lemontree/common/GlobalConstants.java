package com.lemontree.common;

/**
 * Author Jasic
 * Date 13-12-15.
 */
public class GlobalConstants {


    //---------------------------------------- 与后端交互 ----------------------------------
    // 命令处理成功
    //---------------------------------------- 与后端交互 ----------------------------------
    public static final String HANDLE_CMD_SUCCESS = "0";
    // 命令格式不正确
    public static final String HANDLE_CMD_HTTP_REQUEST_ERROR = "10";
    //命令不存在
    public static final String HANDLE_CMD_NOT_EXIST = "11";
    //命令不完整
    public static final String HANDLE_CMD_NOT_COMPLETED = "12";
    //商户Id不存在
    public static final String HANDLE_CMD_SHOPID_NOT_EXIST = "13";
    //商户登录失败
    public static final String HANDLE_CMD_LOGIN_ERROR = "14";
    //请求处理失败
    public static final String HANDLE_CMD_ERROR = "15";

    // --------------------------------- 状态代码 ------------------------------------


    public static final String WEB_CHAT_VALIATETOKEN_URL = "";


    // ---------------------------------- 数据库状态码 ------------------------------------
    // 生效
    public static final String STATUS_EFFETIVE = "A001";
    // 失效
    public static final String STATUS_NO_EFFETIVE = "A010";
    // 待验证状态
    public static final String STATUS_WAITING_VERIFY = "A011";


}
