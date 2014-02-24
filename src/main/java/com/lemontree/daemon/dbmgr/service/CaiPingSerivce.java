package com.lemontree.daemon.dbmgr.service;

import com.lemontree.daemon.dbmgr.mapper.CaiPingMapper;
import com.lemontree.daemon.dbmgr.mapper.SuperMapper;
import com.lemontree.daemon.dbmgr.model.CaiPing;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CaiPingSerivce extends BaseService<CaiPing> {

    @Resource
    private CaiPingMapper mapper;

    @Override
    public SuperMapper<CaiPing> getMapper() {

        return mapper;
    }
}
