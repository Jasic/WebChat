package com.lemontree.daemon.dbmgr.model;

import cn.tisson.framework.annotation.Id;

import java.util.List;

/**
 * Author Jasic
 * Date 13-12-18.
 * ---  3菜品小类
 */
public class CaiPingXiaoLei extends SqlitePojo {

    private List<CaiPing> caiPings;

    public List<CaiPing> getCaiPings() {
        return caiPings;
    }

    public void setCaiPings(List<CaiPing> caiPings) {
        this.caiPings = caiPings;
    }

    @Id

    private Integer PID;
    private String CaiPingXiaoLeiID;
    private String CaiPingXiaoLeiName;
    private String CaiPingXiaoLeiName2;
    private String CaiPingXiaoLeiName3;
    private Integer ShowOrder;
    private Integer Hide;
    private String DaiLei;
    private Integer HideInPad;
    private Integer BuJiChengTYZF;
    private Integer BuJiChengDLZF;
    private Integer NoShowZuoFa;

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public String getCaiPingXiaoLeiID() {
        return CaiPingXiaoLeiID;
    }

    public void setCaiPingXiaoLeiID(String caiPingXiaoLeiID) {
        CaiPingXiaoLeiID = caiPingXiaoLeiID;
    }

    public String getCaiPingXiaoLeiName() {
        return CaiPingXiaoLeiName;
    }

    public void setCaiPingXiaoLeiName(String caiPingXiaoLeiName) {
        CaiPingXiaoLeiName = caiPingXiaoLeiName;
    }

    public String getCaiPingXiaoLeiName2() {
        return CaiPingXiaoLeiName2;
    }

    public void setCaiPingXiaoLeiName2(String caiPingXiaoLeiName2) {
        CaiPingXiaoLeiName2 = caiPingXiaoLeiName2;
    }

    public String getCaiPingXiaoLeiName3() {
        return CaiPingXiaoLeiName3;
    }

    public void setCaiPingXiaoLeiName3(String caiPingXiaoLeiName3) {
        CaiPingXiaoLeiName3 = caiPingXiaoLeiName3;
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

    public String getDaiLei() {
        return DaiLei;
    }

    public void setDaiLei(String daiLei) {
        DaiLei = daiLei;
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

    public Integer getBuJiChengDLZF() {
        return BuJiChengDLZF;
    }

    public void setBuJiChengDLZF(Integer buJiChengDLZF) {
        BuJiChengDLZF = buJiChengDLZF;
    }

    public Integer getNoShowZuoFa() {
        return NoShowZuoFa;
    }

    public void setNoShowZuoFa(Integer noShowZuoFa) {
        NoShowZuoFa = noShowZuoFa;
    }
}
