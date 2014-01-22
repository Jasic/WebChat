package com.lemontree.daemon.dbmgr.service;

import com.lemontree.daemon.dbmgr.mapper.SubcEventPushMsgMapper;
import com.lemontree.daemon.dbmgr.mapper.SuperMapper;
import com.lemontree.daemon.dbmgr.model.SubcEventPushMsg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author Jasic
 * Date 14-1-20.
 */
@Service
public class SubcEventPushMsgService extends BaseService<SubcEventPushMsg> {

    @Resource
    private SubcEventPushMsgMapper subcEventPushMsgMapper;

    public List<SubcEventPushMsg> getAll() {
        return subcEventPushMsgMapper.getAll();
    }


    @Override
    public SuperMapper<SubcEventPushMsg> getMapper() {
        return subcEventPushMsgMapper;
    }
}
