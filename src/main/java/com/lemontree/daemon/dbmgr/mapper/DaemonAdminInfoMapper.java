package com.lemontree.daemon.dbmgr.mapper;

import com.lemontree.daemon.dbmgr.model.DaemonAdminInfo;

import java.util.List;

public interface DaemonAdminInfoMapper extends SuperMapper<DaemonAdminInfo> {

    List<DaemonAdminInfo> getAll();

}