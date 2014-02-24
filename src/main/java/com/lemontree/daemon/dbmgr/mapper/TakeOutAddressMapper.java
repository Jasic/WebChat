package com.lemontree.daemon.dbmgr.mapper;

import com.lemontree.daemon.dbmgr.model.TakeOutAddress;

import java.util.List;

public interface TakeOutAddressMapper extends SuperMapper<TakeOutAddress> {

    public List<TakeOutAddress> getListByMemNo(String memNo);
}
