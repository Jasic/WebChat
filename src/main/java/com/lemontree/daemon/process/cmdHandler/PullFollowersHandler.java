package com.lemontree.daemon.process.cmdHandler;

import com.lemontree.daemon.domm.cmd.PullFollowersCmd;
import com.lemontree.daemon.domm.reslt.BaseReslt;
import org.springframework.stereotype.Repository;

@Repository

public class PullFollowersHandler extends AbstractHandler<PullFollowersCmd> {

    @Override
    protected BaseReslt doHandle(PullFollowersCmd cmd) {
        return null;
    }
}
