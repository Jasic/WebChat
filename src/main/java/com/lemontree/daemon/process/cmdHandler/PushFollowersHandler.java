package com.lemontree.daemon.process.cmdHandler;

import com.lemontree.daemon.domm.cmd.PushFollowersCmd;
import com.lemontree.daemon.domm.reslt.BaseReslt;
import org.springframework.stereotype.Repository;

@Repository

public class PushFollowersHandler extends AbstractHandler<PushFollowersCmd> {

    @Override
    protected BaseReslt doHandle(PushFollowersCmd cmd) {
        return null;
    }
}
