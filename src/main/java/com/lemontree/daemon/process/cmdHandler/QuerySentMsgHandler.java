package com.lemontree.daemon.process.cmdHandler;

import com.lemontree.daemon.domm.cmd.QuerySentMsgCmd;
import com.lemontree.daemon.domm.reslt.BaseReslt;
import org.springframework.stereotype.Repository;

@Repository

public class QuerySentMsgHandler extends AbstractHandler<QuerySentMsgCmd> {

    @Override
    protected BaseReslt doHandle(QuerySentMsgCmd cmd) {
        return null;
    }
}
