package com.lemontree.daemon.dbmgr.model;

import cn.tisson.framework.annotation.Id;

/**
 * Author Jasic
 * Date 13-12-18.
 * <p/>
 * 19
 */
public class ZuoTai extends SqlitePojo {

    @Id

    private Integer PID;
    private String ZuoTaiID;
    private String ZuoTaiName;
    private String ZuoTaiName2;
    private String ZuoTaiName3;
    private String TaiQu;

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public String getZuoTaiID() {
        return ZuoTaiID;
    }

    public void setZuoTaiID(String zuoTaiID) {
        ZuoTaiID = zuoTaiID;
    }

    public String getZuoTaiName() {
        return ZuoTaiName;
    }

    public void setZuoTaiName(String zuoTaiName) {
        ZuoTaiName = zuoTaiName;
    }

    public String getZuoTaiName2() {
        return ZuoTaiName2;
    }

    public void setZuoTaiName2(String zuoTaiName2) {
        ZuoTaiName2 = zuoTaiName2;
    }

    public String getZuoTaiName3() {
        return ZuoTaiName3;
    }

    public void setZuoTaiName3(String zuoTaiName3) {
        ZuoTaiName3 = zuoTaiName3;
    }

    public String getTaiQu() {
        return TaiQu;
    }

    public void setTaiQu(String taiQu) {
        TaiQu = taiQu;
    }
}
