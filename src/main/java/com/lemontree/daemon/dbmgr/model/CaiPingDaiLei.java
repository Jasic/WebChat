package com.lemontree.daemon.dbmgr.model;

import cn.tisson.framework.annotation.Id;

/**
 * Author Jasic
 * Date 13-12-18.
 * 2菜品大类
 */
public class CaiPingDaiLei extends SqlitePojo {

    @Id
    private Integer PID;
    private String CaiPingDaiLeiID;
    private String CaiPingDaiLeiName;
    private String CaiPingDaiLeiName2;
    private String CaiPingDaiLeiName3;
    private Integer ShowOrder;
    private Integer Hide;
    private Integer HideInPad;
    private Integer BuJiChengTYZF;
    private Integer NoShowZuoFa;


    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public String getCaiPingDaiLeiID() {
        return CaiPingDaiLeiID;
    }

    public void setCaiPingDaiLeiID(String caiPingDaiLeiID) {
        CaiPingDaiLeiID = caiPingDaiLeiID;
    }

    public String getCaiPingDaiLeiName() {
        return CaiPingDaiLeiName;
    }

    public void setCaiPingDaiLeiName(String caiPingDaiLeiName) {
        CaiPingDaiLeiName = caiPingDaiLeiName;
    }

    public String getCaiPingDaiLeiName2() {
        return CaiPingDaiLeiName2;
    }

    public void setCaiPingDaiLeiName2(String caiPingDaiLeiName2) {
        CaiPingDaiLeiName2 = caiPingDaiLeiName2;
    }

    public String getCaiPingDaiLeiName3() {
        return CaiPingDaiLeiName3;
    }

    public void setCaiPingDaiLeiName3(String caiPingDaiLeiName3) {
        CaiPingDaiLeiName3 = caiPingDaiLeiName3;
    }

    public Integer getShowOrder() {
        return ShowOrder;
    }

    public void setShowOrder(Integer showOrder) {
        ShowOrder = showOrder;
    }

    public Integer getHide() {
        return Hide;
    }

    public void setHide(Integer hide) {
        Hide = hide;
    }

    public Integer getHideInPad() {
        return HideInPad;
    }

    public void setHideInPad(Integer hideInPad) {
        HideInPad = hideInPad;
    }

    public Integer getBuJiChengTYZF() {
        return BuJiChengTYZF;
    }

    public void setBuJiChengTYZF(Integer buJiChengTYZF) {
        BuJiChengTYZF = buJiChengTYZF;
    }

    public Integer getNoShowZuoFa() {
        return NoShowZuoFa;
    }

    public void setNoShowZuoFa(Integer noShowZuoFa) {
        NoShowZuoFa = noShowZuoFa;
    }
}
