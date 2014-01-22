package com.lemontree.daemon.dbmgr.model;

import cn.tisson.framework.annotation.Id;

/**
 * Author Jasic
 * Date 13-12-18.
 * <p/>
 * 8
 */
public class QuanJuCanShu extends SqlitePojo {
    @Id
    private Integer PID;
    private String ID;
    private String Name;
    private String StrVal;
    private String StrVal2;
    private String StrVal3;
    private Integer IntVal;
    private Integer BoolVal;
    private Long DoubleVal;
    private String DateVal;

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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStrVal() {
        return StrVal;
    }

    public void setStrVal(String strVal) {
        StrVal = strVal;
    }

    public String getStrVal2() {
        return StrVal2;
    }

    public void setStrVal2(String strVal2) {
        StrVal2 = strVal2;
    }

    public String getStrVal3() {
        return StrVal3;
    }

    public void setStrVal3(String strVal3) {
        StrVal3 = strVal3;
    }

    public Integer getIntVal() {
        return IntVal;
    }

    public void setIntVal(Integer intVal) {
        IntVal = intVal;
    }

    public Integer getBoolVal() {
        return BoolVal;
    }

    public void setBoolVal(Integer boolVal) {
        BoolVal = boolVal;
    }

    public Long getDoubleVal() {
        return DoubleVal;
    }

    public void setDoubleVal(Long doubleVal) {
        DoubleVal = doubleVal;
    }

    public String getDateVal() {
        return DateVal;
    }

    public void setDateVal(String dateVal) {
        DateVal = dateVal;
    }
}
