package com.lemontree.daemon.dbmgr.mapper;

import com.lemontree.daemon.dbmgr.model.FansInfo;

public interface FansInfoMapper extends SuperMapper<FansInfo> {

    FansInfo selectByWebChatID(String webchatid);

    int deleteByWebChatID(String webchatid);

}