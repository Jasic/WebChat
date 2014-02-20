package com.lemontree.daemon.dbmgr.service;

import com.lemontree.daemon.dbmgr.mapper.ClientInfoMapper;
import com.lemontree.daemon.dbmgr.mapper.SuperMapper;
import com.lemontree.daemon.dbmgr.model.ClientInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClientInfoService extends BaseService<ClientInfo>{

    @Resource
    private ClientInfoMapper mapper;

    public ClientInfo selectByMemNo(String menNo){
        return mapper.selectByMemNo(menNo);
    }

    public ClientInfo selectByFanInfoId(Integer fanInfoId) {
        return mapper.selectByFanInfoId(fanInfoId);
    }
    @Override
    public SuperMapper<ClientInfo> getMapper() {
        return mapper;
    }
}
