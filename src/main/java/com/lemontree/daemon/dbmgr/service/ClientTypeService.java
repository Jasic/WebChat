package com.lemontree.daemon.dbmgr.service;

import com.lemontree.daemon.dbmgr.mapper.ClientTypeMapper;
import com.lemontree.daemon.dbmgr.mapper.SuperMapper;
import com.lemontree.daemon.dbmgr.model.ClientType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientTypeService extends BaseService<ClientType> {

    @Resource
    private ClientTypeMapper mapper;

    public List<ClientType> getAll() {
        return mapper.getAll();
    }

    @Override
    public SuperMapper<ClientType> getMapper() {
        return mapper;
    }
}
