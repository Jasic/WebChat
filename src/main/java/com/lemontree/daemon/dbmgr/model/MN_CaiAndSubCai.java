package com.lemontree.daemon.dbmgr.model;

import cn.tisson.framework.annotation.Id;

/**
 * Author Jasic
 * Date 13-12-18.
 * 6、
 */
public class MN_CaiAndSubCai extends SqlitePojo {
    @Id

    private Integer PID;
    private String ID;
    private String Name;
    private String MainCai;
    private String SubCai;
    private String Unit;
    private Integer Amount;
    private Integer MaxAmount;
    private Long Price;

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

    public String getMainCai() {
        return MainCai;
    }

    public void setMainCai(String mainCai) {
        MainCai = mainCai;
    }

    public String getSubCai() {
        return SubCai;
    }

    public void setSubCai(String subCai) {
        SubCai = subCai;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public Integer getMaxAmount() {
        return MaxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        MaxAmount = maxAmount;
    }

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        Price = price;
    }
}
