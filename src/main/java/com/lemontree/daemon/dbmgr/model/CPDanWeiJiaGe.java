package com.lemontree.daemon.dbmgr.model;

import cn.tisson.framework.annotation.Id;

/**
 * Author Jasic
 * Date 13-12-18.
 */
public class CPDanWeiJiaGe extends SqlitePojo {

    @Id

    private Integer PID;
    private String ID;
    private String DanWeiMing;
    private Long BiLv;
    private Long JiaGe;
    private Long ChengBenJiaGe;
    private Long XiaoShouTiCheng;
    private Integer NoBilling;
    private Integer Def;
    private String DanWeiMing2;
    private String DanWeiMing3;
    private String CaiP;

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDanWeiMing() {
        return DanWeiMing;
    }

    public void setDanWeiMing(String danWeiMing) {
        DanWeiMing = danWeiMing;
    }

    public Long getBiLv() {
        return BiLv;
    }

    public void setBiLv(Long biLv) {
        BiLv = biLv;
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

    public Long getXiaoShouTiCheng() {
        return XiaoShouTiCheng;
    }

    public void setXiaoShouTiCheng(Long xiaoShouTiCheng) {
        XiaoShouTiCheng = xiaoShouTiCheng;
    }

    public Integer getNoBilling() {
        return NoBilling;
    }

    public void setNoBilling(Integer noBilling) {
        NoBilling = noBilling;
    }

    public Integer getDef() {
        return Def;
    }

    public void setDef(Integer def) {
        Def = def;
    }

    public String getDanWeiMing2() {
        return DanWeiMing2;
    }

    public void setDanWeiMing2(String danWeiMing2) {
        DanWeiMing2 = danWeiMing2;
    }

    public String getDanWeiMing3() {
        return DanWeiMing3;
    }

    public void setDanWeiMing3(String danWeiMing3) {
        DanWeiMing3 = danWeiMing3;
    }

    public String getCaiP() {
        return CaiP;
    }

    public void setCaiP(String caiP) {
        CaiP = caiP;
    }
}
