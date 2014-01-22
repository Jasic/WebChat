package com.lemontree.daemon.process.cmdHandler;

import com.lemontree.daemon.domm.cmd.PushTakeOutListCmd;
import com.lemontree.daemon.domm.reslt.BaseReslt;
import org.springframework.stereotype.Repository;

@Repository

public class PushTakeOutListHandler extends AbstractHandler<PushTakeOutListCmd> {

    @Override
    protected BaseReslt doHandle(PushTakeOutListCmd cmd) {
        return null;
    }
}
