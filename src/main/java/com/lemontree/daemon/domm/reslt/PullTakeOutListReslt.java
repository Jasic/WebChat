package com.lemontree.daemon.domm.reslt;

import com.lemontree.daemon.domm.BookList;

import java.util.List;

/**
 * Author Jasic
 * Date 13-12-17.
 * <p/>
 * Respond the valid list results
 * 餐厅服务器向微信服务器查询本店的预订记录响应
 */
public class PullTakeOutListReslt extends BaseReslt {


    /**
     * 返回有效的订单
     */
    private List<BookList> bookLists;
}
