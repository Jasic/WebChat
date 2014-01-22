package com.lemontree.daemon.dbmgr.model;

import cn.tisson.framework.annotation.Id;

/**
 * Author Jasic
 * Date 13-12-18.
 * 20
 */
public class ZuoTaiQuYu extends SqlitePojo {

    @Id

    private Integer PID;
    private String ZuoTaiQuYuID;
    private String ZuoTaiQuYuName;
    private String ZuoTaiQuYuName2;
    private String ZuoTaiQuYuName3;
    private Integer ShowOrder;

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public String getZuoTaiQuYuID() {
        return ZuoTaiQuYuID;
    }

    public void setZuoTaiQuYuID(String zuoTaiQuYuID) {
        ZuoTaiQuYuID = zuoTaiQuYuID;
    }

    public String getZuoTaiQuYuName() {
        return ZuoTaiQuYuName;
    }

    public void setZuoTaiQuYuName(String zuoTaiQuYuName) {
        ZuoTaiQuYuName = zuoTaiQuYuName;
    }

    public String getZuoTaiQuYuName2() {
        return ZuoTaiQuYuName2;
    }

    public void setZuoTaiQuYuName2(String zuoTaiQuYuName2) {
        ZuoTaiQuYuName2 = zuoTaiQuYuName2;
    }

    public String getZuoTaiQuYuName3() {
        return ZuoTaiQuYuName3;
    }

    public void setZuoTaiQuYuName3(String zuoTaiQuYuName3) {
        ZuoTaiQuYuName3 = zuoTaiQuYuName3;
    }

    public Integer getShowOrder() {
        return ShowOrder;
    }

    public void setShowOrder(Integer showOrder) {
        ShowOrder = showOrder;
    }
}
