package com.lemontree.daemon.domm.cmd;

/**
 * Created by JasicMacBook on 13-12-15.
 * 基础实体
 */
public class BaseCmd {

    /**
     * 命令
     */
    private Command cmd;

    /**
     * 执行命令的用户
     */
    private Account account;

    /**
     * Json字符串
     */
    private String jsonStr;

    public Command getCmd() {
        return cmd;
    }

    public void setCmd(Command cmd) {
        this.cmd = cmd;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }
}
