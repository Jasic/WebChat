package com.lemontree.daemon.dbmgr.service;

import com.lemontree.daemon.dbmgr.mapper.SuperMapper;
import com.lemontree.daemon.dbmgr.mapper.TakeOutAddressMapper;
import com.lemontree.daemon.dbmgr.model.TakeOutAddress;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Jasic
 * Date: 14-2-19
 */
@Service
public class TakeOutAddressService extends BaseService<TakeOutAddress> {

    @Resource
    private TakeOutAddressMapper mapper;

    public List<TakeOutAddress> getListByMemNo(String memNo) {
        return mapper.getListByMemNo(memNo);
    }

    @Override
    public SuperMapper<TakeOutAddress> getMapper() {
        return mapper;
    }
}
