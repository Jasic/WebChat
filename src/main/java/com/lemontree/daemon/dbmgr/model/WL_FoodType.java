package com.lemontree.daemon.dbmgr.model;

import cn.tisson.framework.annotation.Id;

/**
 * Author Jasic
 * Date 13-12-18.
 * 15
 */
public class WL_FoodType extends SqlitePojo {

    @Id

    private Integer PID;
    private String ID;
    private String Name;
    private String Name2;
    private String Name3;
    private Integer Hide;
    private Integer ShowOrder;
    private String FoodSuperType;

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

    public String getName2() {
        return Name2;
    }

    public void setName2(String name2) {
        Name2 = name2;
    }

    public String getName3() {
        return Name3;
    }

    public void setName3(String name3) {
        Name3 = name3;
    }

    public Integer getHide() {
        return Hide;
    }

    public void setHide(Integer hide) {
        Hide = hide;
    }

    public Integer getShowOrder() {
        return ShowOrder;
    }

    public void setShowOrder(Integer showOrder) {
        ShowOrder = showOrder;
    }

    public String getFoodSuperType() {
        return FoodSuperType;
    }

    public void setFoodSuperType(String foodSuperType) {
        FoodSuperType = foodSuperType;
    }
}
