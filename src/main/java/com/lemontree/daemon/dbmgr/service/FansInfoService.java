package com.lemontree.daemon.dbmgr.service;

import com.lemontree.daemon.dbmgr.mapper.FansInfoMapper;
import com.lemontree.daemon.dbmgr.mapper.SuperMapper;
import com.lemontree.daemon.dbmgr.model.FansInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author Jasic
 * Date 14-1-20.
 */
@Service
public class FansInfoService extends BaseService<FansInfo> {

    @Resource
    private FansInfoMapper fansInfoMapper;

    public FansInfo selectByWebChatID(String webchatid) {
        return fansInfoMapper.selectByWebChatID(webchatid);
    }

    public int deleteByWebChatID(String webchatid) {
        return fansInfoMapper.deleteByWebChatID(webchatid);
    }


    @Override
    public SuperMapper<FansInfo> getMapper() {
        return fansInfoMapper;
    }


}
