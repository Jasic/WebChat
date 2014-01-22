package com.lemontree.daemon.domm;

import java.util.Date;
import java.util.List;

/**
 * Author Jasic
 * Date 13-12-17.
 * <p/>
 * 订单
 */
public class BookList {

    /**
     * 订单编号
     */
    private String billId;

    /**
     * 顾客微信号
     */
    private String WeiXinID;

    /**
     * 顾客名称
     */
    private String name;

    /**
     * 顾客性别
     */
    private String sex;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 人数
     */
    private Integer peopleNum;

    /**
     * 预订房台号
     */
    private String tableNo;

    /**
     * 预抵时间
     */
    private Date arriTime;

    /**
     * 保留时长
     */
    private Long keepTime;

    /**
     * 食物
     */
    private List<Food> foods;


}
