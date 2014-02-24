package com.lemontree.common;

/**
 * Author Jasic
 * Date 13-12-15.
 */
public class GlobalConstants {

    public static final String PHONE_REGEX_STR = "^(?:13\\d|15[89])-?\\d{5}(\\d{3}|\\*{3})$";

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

    // ---------------------------------- 与wap网站相关 ------------------------------------
    public static final String SESSION_USER_KEY = "LOGIN_USER_KEY";
    public static final String SESSION_FANSINFOID_KEY = "fansInfoId";
    public static final String SESSION_CLIENTINFO_KEY = "clientInfo";
    public static final String ADDRESS_ADD = "add";
    public static final String ADDRESS_DELETE = "delete";
    public static final String ADDRESS_UPDATE = "update";
    public static final String EDIT_ADDRESS_TYPE = "type";

    // ---------------------------------- 客户端文件目录 ------------------------------------
    // 客户端基础目录
    public static final String RESTAURANT_BASE_DIR = "/opt/wspace/employ/WebChat/src/main/webapp/resource/restaurant";

    public static final String RESTAURANT_SOURCE_TYPE_IMG = "img";
    public static final String RESTAURANT_SOURCE_TYPE_DB = "db";
}
