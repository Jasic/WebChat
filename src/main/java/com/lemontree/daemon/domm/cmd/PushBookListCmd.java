package com.lemontree.daemon.domm.cmd;

import com.lemontree.daemon.domm.BookList;

import java.util.List;

/**
 * Author Jasic
 * Date 13-12-17.
 * API 004 标记预订记录
 * 当餐厅服务器成功处理外卖记录后，需要通知微信服务器，微信服务器将该条记录标示为已经处理，下次查询时不在返回该条记录。.
 */
public class PushBookListCmd extends BaseCmd {

    /**
     * 所有被接受的订单
     */
    private List<BookList> bookLists;
}
