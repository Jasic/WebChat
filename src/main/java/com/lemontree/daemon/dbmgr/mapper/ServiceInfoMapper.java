package com.lemontree.daemon.dbmgr.mapper;

import com.lemontree.daemon.dbmgr.model.ServiceInfo;

import java.util.List;

public interface ServiceInfoMapper extends SuperMapper<ServiceInfo> {

    List<ServiceInfo> getAll();

}
