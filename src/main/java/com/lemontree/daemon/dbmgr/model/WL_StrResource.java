package com.lemontree.daemon.dbmgr.model;

import cn.tisson.framework.annotation.Id;

/**
 * Author Jasic
 * Date 13-12-18.
 * 16
 */
public class WL_StrResource extends SqlitePojo {


    @Id

    private Integer PID;
    private String ID;
    private String Type;
    private String StrKey;
    private String Lan1;
    private String Lan2;
    private String Lan3;
    private String Remark;

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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getStrKey() {
        return StrKey;
    }

    public void setStrKey(String strKey) {
        StrKey = strKey;
    }

    public String getLan1() {
        return Lan1;
    }

    public void setLan1(String lan1) {
        Lan1 = lan1;
    }

    public String getLan2() {
        return Lan2;
    }

    public void setLan2(String lan2) {
        Lan2 = lan2;
    }

    public String getLan3() {
        return Lan3;
    }

    public void setLan3(String lan3) {
        Lan3 = lan3;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}
