package com.lemontree.daemon.dbmgr.model;

import java.util.List;

public class CaiPingXiaoLei {

    private List<CaiPing> caiPings;

    public List<CaiPing> getCaiPings() {
        return caiPings;
    }

    public void setCaiPings(List<CaiPing> caiPings) {
        this.caiPings = caiPings;
    }

    private Integer pid;

    private String caipingxiaoleiid;

    private String caipingxiaoleiname;

    private String caipingxiaoleiname2;

    private String caipingxiaoleiname3;

    private Integer showorder;

    private String hide;

    private String dailei;

    private String hideinpad;

    private String bujichengtyzf;

    private String bujichengdlzf;

    private String noshowzuofa;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCaipingxiaoleiid() {
        return caipingxiaoleiid;
    }

    public void setCaipingxiaoleiid(String caipingxiaoleiid) {
        this.caipingxiaoleiid = caipingxiaoleiid == null ? null : caipingxiaoleiid.trim();
    }

    public String getCaipingxiaoleiname() {
        return caipingxiaoleiname;
    }

    public void setCaipingxiaoleiname(String caipingxiaoleiname) {
        this.caipingxiaoleiname = caipingxiaoleiname == null ? null : caipingxiaoleiname.trim();
    }

    public String getCaipingxiaoleiname2() {
        return caipingxiaoleiname2;
    }

    public void setCaipingxiaoleiname2(String caipingxiaoleiname2) {
        this.caipingxiaoleiname2 = caipingxiaoleiname2 == null ? null : caipingxiaoleiname2.trim();
    }

    public String getCaipingxiaoleiname3() {
        return caipingxiaoleiname3;
    }

    public void setCaipingxiaoleiname3(String caipingxiaoleiname3) {
        this.caipingxiaoleiname3 = caipingxiaoleiname3 == null ? null : caipingxiaoleiname3.trim();
    }

    public Integer getShoworder() {
        return showorder;
    }

    public void setShoworder(Integer showorder) {
        this.showorder = showorder;
    }

    public String getHide() {
        return hide;
    }

    public void setHide(String hide) {
        this.hide = hide == null ? null : hide.trim();
    }

    public String getDailei() {
        return dailei;
    }

    public void setDailei(String dailei) {
        this.dailei = dailei == null ? null : dailei.trim();
    }

    public String getHideinpad() {
        return hideinpad;
    }

    public void setHideinpad(String hideinpad) {
        this.hideinpad = hideinpad == null ? null : hideinpad.trim();
    }

    public String getBujichengtyzf() {
        return bujichengtyzf;
    }

    public void setBujichengtyzf(String bujichengtyzf) {
        this.bujichengtyzf = bujichengtyzf == null ? null : bujichengtyzf.trim();
    }

    public String getBujichengdlzf() {
        return bujichengdlzf;
    }

    public void setBujichengdlzf(String bujichengdlzf) {
        this.bujichengdlzf = bujichengdlzf == null ? null : bujichengdlzf.trim();
    }

    public String getNoshowzuofa() {
        return noshowzuofa;
    }

    public void setNoshowzuofa(String noshowzuofa) {
        this.noshowzuofa = noshowzuofa == null ? null : noshowzuofa.trim();
    }
}