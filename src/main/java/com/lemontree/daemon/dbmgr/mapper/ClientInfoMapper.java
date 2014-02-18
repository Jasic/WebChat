package com.lemontree.daemon.dbmgr.mapper;

import com.lemontree.daemon.dbmgr.model.ClientInfo;

import java.util.List;

public interface ClientInfoMapper extends SuperMapper<ClientInfo> {

    ClientInfo selectByMemNo(String menNo);
    List<ClientInfo> getAll();
}