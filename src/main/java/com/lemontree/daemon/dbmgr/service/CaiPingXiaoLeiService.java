package com.lemontree.daemon.dbmgr.service;

import com.lemontree.daemon.dbmgr.mapper.CaiPingXiaoLeiMapper;
import com.lemontree.daemon.dbmgr.mapper.SuperMapper;
import com.lemontree.daemon.dbmgr.model.CaiPingXiaoLei;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CaiPingXiaoLeiService extends BaseService<CaiPingXiaoLei> {

    @Resource
    private CaiPingXiaoLeiMapper mapper;

    @Override
    public SuperMapper<CaiPingXiaoLei> getMapper() {

        return mapper;
    }
}
