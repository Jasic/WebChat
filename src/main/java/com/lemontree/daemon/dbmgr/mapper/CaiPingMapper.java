package com.lemontree.daemon.dbmgr.mapper;

import com.lemontree.daemon.dbmgr.model.CaiPing;

import java.util.List;

public interface CaiPingMapper extends SuperMapper<CaiPing> {

    List<CaiPing> getAll();

    Integer countAll();

}