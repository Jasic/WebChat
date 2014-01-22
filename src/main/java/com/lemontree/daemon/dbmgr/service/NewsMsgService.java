package com.lemontree.daemon.dbmgr.service;

import com.lemontree.daemon.dbmgr.mapper.NewsMsgMapper;
import com.lemontree.daemon.dbmgr.mapper.SuperMapper;
import com.lemontree.daemon.dbmgr.model.NewsMsg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author Jasic
 * Date 14-1-20.
 */
@Service
public class NewsMsgService extends BaseService<NewsMsg> {

    @Resource
    private NewsMsgMapper newsMsgMapper;

    public List<NewsMsg> getAll() {
        return newsMsgMapper.getAll();
    }


    @Override
    public SuperMapper<NewsMsg> getMapper() {
        return newsMsgMapper;
    }
}
