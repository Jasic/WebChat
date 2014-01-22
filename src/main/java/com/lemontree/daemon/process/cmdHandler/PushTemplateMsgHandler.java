package com.lemontree.daemon.process.cmdHandler;

import com.lemontree.daemon.domm.cmd.PushTemplateMsgCmd;
import com.lemontree.daemon.domm.reslt.BaseReslt;
import org.springframework.stereotype.Repository;

@Repository

public class PushTemplateMsgHandler extends AbstractHandler<PushTemplateMsgCmd> {

    @Override
    protected BaseReslt doHandle(PushTemplateMsgCmd cmd) {
        return null;
    }
}
