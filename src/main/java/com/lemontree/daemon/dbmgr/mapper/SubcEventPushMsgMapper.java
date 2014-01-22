package com.lemontree.daemon.dbmgr.mapper;

import com.lemontree.daemon.dbmgr.model.SubcEventPushMsg;

import java.util.List;

public interface SubcEventPushMsgMapper extends SuperMapper<SubcEventPushMsg> {

    List<SubcEventPushMsg> getAll();

}