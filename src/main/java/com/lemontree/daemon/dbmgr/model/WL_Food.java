package com.lemontree.daemon.dbmgr.model;

import cn.tisson.framework.annotation.Id;

/**
 * Author Jasic
 * Date 13-12-18.
 */
public class WL_Food extends SqlitePojo {

    @Id

    private Integer PID;
    private String ID;
    private String Name;
    private Integer Hide;
    private Integer ShowOrder;
    private String FoodPage;
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

    public String getFoodPage() {
        return FoodPage;
    }

    public void setFoodPage(String foodPage) {
        FoodPage = foodPage;
    }

    public String getCaiP() {
        return CaiP;
    }

    public void setCaiP(String caiP) {
        CaiP = caiP;
    }
}
