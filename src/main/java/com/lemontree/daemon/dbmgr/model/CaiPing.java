package com.lemontree.daemon.dbmgr.model;

import cn.tisson.framework.annotation.Id;

/**
 * Author Jasic
 * Date 13-12-18.
 * 菜品表
 */
public class CaiPing extends SqlitePojo {

    @Id
    private Integer PID;
    private String CaiPingID;
    private String CaiPingName;
    private String CaiPingName2;
    private String CaiPingName3;
    private Long JiaGe;
    private String MoRenDanWei;
    private String MoRenDanWei2;
    private String MoRenDanWei3;
    private Integer ShowOrder;
    private Integer YinCan;
    private String JianJie;
    private String JianJie2;
    private String JianJie3;
    private String XiaoLei;
    private Integer YinCanInPad;
    private String FuZhuID;
    private String PingYing;
    private Integer BuJiChengTYZF;
    private Integer BuJiChengDLZF;
    private Integer BuJiChengXLZF;
    private Integer NoShowZuoFa;
    private Integer ShiJia;
    private Integer CanModName;


    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public String getCaiPingID() {
        return CaiPingID;
    }

    public void setCaiPingID(String caiPingID) {
        CaiPingID = caiPingID;
    }

    public String getCaiPingName() {
        return CaiPingName;
    }

    public void setCaiPingName(String caiPingName) {
        CaiPingName = caiPingName;
    }

    public String getCaiPingName2() {
        return CaiPingName2;
    }

    public void setCaiPingName2(String caiPingName2) {
        CaiPingName2 = caiPingName2;
    }

    public String getCaiPingName3() {
        return CaiPingName3;
    }

    public void setCaiPingName3(String caiPingName3) {
        CaiPingName3 = caiPingName3;
    }

    public Long getJiaGe() {
        return JiaGe;
    }

    public void setJiaGe(Long jiaGe) {
        JiaGe = jiaGe;
    }

    public String getMoRenDanWei() {
        return MoRenDanWei;
    }

    public void setMoRenDanWei(String moRenDanWei) {
        MoRenDanWei = moRenDanWei;
    }

    public String getMoRenDanWei2() {
        return MoRenDanWei2;
    }

    public void setMoRenDanWei2(String moRenDanWei2) {
        MoRenDanWei2 = moRenDanWei2;
    }

    public String getMoRenDanWei3() {
        return MoRenDanWei3;
    }

    public void setMoRenDanWei3(String moRenDanWei3) {
        MoRenDanWei3 = moRenDanWei3;
    }

    public Integer getShowOrder() {
        return ShowOrder;
    }

    public void setShowOrder(Integer showOrder) {
        ShowOrder = showOrder;
    }

    public Integer getYinCan() {
        return YinCan;
    }

    public void setYinCan(Integer yinCan) {
        YinCan = yinCan;
    }

    public String getJianJie() {
        return JianJie;
    }

    public void setJianJie(String jianJie) {
        JianJie = jianJie;
    }

    public String getJianJie2() {
        return JianJie2;
    }

    public void setJianJie2(String jianJie2) {
        JianJie2 = jianJie2;
    }

    public String getJianJie3() {
        return JianJie3;
    }

    public void setJianJie3(String jianJie3) {
        JianJie3 = jianJie3;
    }

    public String getXiaoLei() {
        return XiaoLei;
    }

    public void setXiaoLei(String xiaoLei) {
        XiaoLei = xiaoLei;
    }

    public Integer getYinCanInPad() {
        return YinCanInPad;
    }

    public void setYinCanInPad(Integer yinCanInPad) {
        YinCanInPad = yinCanInPad;
    }

    public String getFuZhuID() {
        return FuZhuID;
    }

    public void setFuZhuID(String fuZhuID) {
        FuZhuID = fuZhuID;
    }

    public String getPingYing() {
        return PingYing;
    }

    public void setPingYing(String pingYing) {
        PingYing = pingYing;
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

    public Integer getBuJiChengXLZF() {
        return BuJiChengXLZF;
    }

    public void setBuJiChengXLZF(Integer buJiChengXLZF) {
        BuJiChengXLZF = buJiChengXLZF;
    }

    public Integer getNoShowZuoFa() {
        return NoShowZuoFa;
    }

    public void setNoShowZuoFa(Integer noShowZuoFa) {
        NoShowZuoFa = noShowZuoFa;
    }

    public Integer getShiJia() {
        return ShiJia;
    }

    public void setShiJia(Integer shiJia) {
        ShiJia = shiJia;
    }

    public Integer getCanModName() {
        return CanModName;
    }

    public void setCanModName(Integer canModName) {
        CanModName = canModName;
    }
}
