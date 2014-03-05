package com.lemontree.daemon.dbmgr.mapper;

import com.lemontree.daemon.dbmgr.model.CaiPingXiaoLei;

import java.util.List;

public interface CaiPingXiaoLeiMapper extends SuperMapper<CaiPingXiaoLei> {
    int insert(CaiPingXiaoLei record);

    int insertSelective(CaiPingXiaoLei record);

    public List<CaiPingXiaoLei> getAll();
}