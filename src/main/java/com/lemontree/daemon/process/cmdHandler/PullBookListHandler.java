package com.lemontree.daemon.process.cmdHandler;

import com.lemontree.daemon.domm.cmd.PullBookListCmd;
import com.lemontree.daemon.domm.reslt.BaseReslt;
import org.springframework.stereotype.Repository;

@Repository
public class PullBookListHandler extends AbstractHandler<PullBookListCmd> {

    @Override
    protected BaseReslt doHandle(PullBookListCmd cmd) {
        return null;
    }
}
