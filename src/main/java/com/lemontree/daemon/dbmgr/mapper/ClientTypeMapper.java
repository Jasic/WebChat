package com.lemontree.daemon.dbmgr.mapper;

import com.lemontree.daemon.dbmgr.model.ClientType;

import java.util.List;

public interface ClientTypeMapper extends SuperMapper<ClientType> {
    List<ClientType> getAll();

}