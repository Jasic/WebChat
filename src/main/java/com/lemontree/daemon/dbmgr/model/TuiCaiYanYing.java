package com.lemontree.daemon.dbmgr.model;

import cn.tisson.framework.annotation.Id;

/**
 * Author Jasic
 * Date 13-12-18.
 */
public class TuiCaiYanYing extends SqlitePojo {

    @Id
    private Integer PID;
    private String TuiCaiYanYingID;
    private String TuiCaiYanYingName;
    private String TuiCaiYanYingName2;
    private String TuiCaiYanYingName3;

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public String getTuiCaiYanYingID() {
        return TuiCaiYanYingID;
    }

    public void setTuiCaiYanYingID(String tuiCaiYanYingID) {
        TuiCaiYanYingID = tuiCaiYanYingID;
    }

    public String getTuiCaiYanYingName() {
        return TuiCaiYanYingName;
    }

    public void setTuiCaiYanYingName(String tuiCaiYanYingName) {
        TuiCaiYanYingName = tuiCaiYanYingName;
    }

    public String getTuiCaiYanYingName2() {
        return TuiCaiYanYingName2;
    }

    public void setTuiCaiYanYingName2(String tuiCaiYanYingName2) {
        TuiCaiYanYingName2 = tuiCaiYanYingName2;
    }

    public String getTuiCaiYanYingName3() {
        return TuiCaiYanYingName3;
    }

    public void setTuiCaiYanYingName3(String tuiCaiYanYingName3) {
        TuiCaiYanYingName3 = tuiCaiYanYingName3;
    }
}
