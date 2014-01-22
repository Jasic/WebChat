package com.lemontree.daemon.dbmgr.model;

import cn.tisson.framework.annotation.Id;

/**
 * Author Jasic
 * Date 13-12-18.
 */
public class WL_FoodPage extends SqlitePojo {

    @Id

    private Integer PID;
    private String ID;
    private String Name;
    private Integer Hide;
    private Integer ShowOrder;
    private String FoodType;
    private String PageType;

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

    public String getFoodType() {
        return FoodType;
    }

    public void setFoodType(String foodType) {
        FoodType = foodType;
    }

    public String getPageType() {
        return PageType;
    }

    public void setPageType(String pageType) {
        PageType = pageType;
    }
}
