package com.lemontree.daemon.dbmgr.model;

import cn.tisson.framework.annotation.Id;

/**
 * Author Jasic
 * Date 13-12-18.
 * <p/>
 * 7
 */
public class MN_CaiPinAndMember extends SqlitePojo {
    @Id

    private Integer PID;
    private Long ID;
    private Long Name;
    private Long Cai;
    private Long MemberType;
    private Long Price;
    private Long Unit;

    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getName() {
        return Name;
    }

    public void setName(Long name) {
        Name = name;
    }

    public Long getCai() {
        return Cai;
    }

    public void setCai(Long cai) {
        Cai = cai;
    }

    public Long getMemberType() {
        return MemberType;
    }

    public void setMemberType(Long memberType) {
        MemberType = memberType;
    }

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        Price = price;
    }

    public Long getUnit() {
        return Unit;
    }

    public void setUnit(Long unit) {
        Unit = unit;
    }
}
