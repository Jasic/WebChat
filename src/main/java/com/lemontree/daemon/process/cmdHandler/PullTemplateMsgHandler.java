package com.lemontree.daemon.process.cmdHandler;

import com.lemontree.daemon.domm.cmd.PullTemplateMsgCmd;
import com.lemontree.daemon.domm.reslt.BaseReslt;
import org.springframework.stereotype.Repository;

@Repository

public class PullTemplateMsgHandler extends AbstractHandler<PullTemplateMsgCmd> {

    @Override
    protected BaseReslt doHandle(PullTemplateMsgCmd cmd) {
        return null;
    }
}
