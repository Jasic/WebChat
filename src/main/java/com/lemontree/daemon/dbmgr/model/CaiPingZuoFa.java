package com.lemontree.daemon.dbmgr.model;

import cn.tisson.framework.annotation.Id;

/**
 * Author Jasic
 * Date 13-12-18.
 * 4、菜品做法
 */
public class CaiPingZuoFa extends SqlitePojo {

    @Id
    private Integer PID;
    private String CaiPingZuoFaID;
    private String CaiPingZuoFaName;
    private String CaiPingZuoFaName2;
    private String CaiPingZuoFaName3;
    private String LeiBie;
    private String CaiDaLei;
    private String CaiLei;
    private String CaiP;
    private String PingYing;
    private Long JiaGe;
    private Long ChengBenJiaGe;
    private Integer ShiFuoChenYuShuLiang;
    private Integer MulSelfAmount;

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public String getCaiPingZuoFaID() {
        return CaiPingZuoFaID;
    }

    public void setCaiPingZuoFaID(String caiPingZuoFaID) {
        CaiPingZuoFaID = caiPingZuoFaID;
    }

    public String getCaiPingZuoFaName() {
        return CaiPingZuoFaName;
    }

    public void setCaiPingZuoFaName(String caiPingZuoFaName) {
        CaiPingZuoFaName = caiPingZuoFaName;
    }

    public String getCaiPingZuoFaName2() {
        return CaiPingZuoFaName2;
    }

    public void setCaiPingZuoFaName2(String caiPingZuoFaName2) {
        CaiPingZuoFaName2 = caiPingZuoFaName2;
    }

    public String getCaiPingZuoFaName3() {
        return CaiPingZuoFaName3;
    }

    public void setCaiPingZuoFaName3(String caiPingZuoFaName3) {
        CaiPingZuoFaName3 = caiPingZuoFaName3;
    }

    public String getLeiBie() {
        return LeiBie;
    }

    public void setLeiBie(String leiBie) {
        LeiBie = leiBie;
    }

    public String getCaiDaLei() {
        return CaiDaLei;
    }

    public void setCaiDaLei(String caiDaLei) {
        CaiDaLei = caiDaLei;
    }

    public String getCaiLei() {
        return CaiLei;
    }

    public void setCaiLei(String caiLei) {
        CaiLei = caiLei;
    }

    public String getCaiP() {
        return CaiP;
    }

    public void setCaiP(String caiP) {
        CaiP = caiP;
    }

    public String getPingYing() {
        return PingYing;
    }

    public void setPingYing(String pingYing) {
        PingYing = pingYing;
    }

    public Long getJiaGe() {
        return JiaGe;
    }

    public void setJiaGe(Long jiaGe) {
        JiaGe = jiaGe;
    }

    public Long getChengBenJiaGe() {
        return ChengBenJiaGe;
    }

    public void setChengBenJiaGe(Long chengBenJiaGe) {
        ChengBenJiaGe = chengBenJiaGe;
    }

    public Integer getShiFuoChenYuShuLiang() {
        return ShiFuoChenYuShuLiang;
    }

    public void setShiFuoChenYuShuLiang(Integer shiFuoChenYuShuLiang) {
        ShiFuoChenYuShuLiang = shiFuoChenYuShuLiang;
    }

    public Integer getMulSelfAmount() {
        return MulSelfAmount;
    }

    public void setMulSelfAmount(Integer mulSelfAmount) {
        MulSelfAmount = mulSelfAmount;
    }
}
