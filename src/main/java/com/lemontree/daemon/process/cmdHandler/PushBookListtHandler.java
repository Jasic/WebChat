package com.lemontree.daemon.process.cmdHandler;

import com.lemontree.daemon.domm.cmd.PushBookListCmd;
import com.lemontree.daemon.domm.reslt.BaseReslt;
import org.springframework.stereotype.Repository;

@Repository

public class PushBookListtHandler extends AbstractHandler<PushBookListCmd> {

    @Override
    protected BaseReslt doHandle(PushBookListCmd cmd) {
        return null;
    }
}
