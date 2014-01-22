package com.lemontree.daemon.dbmgr.mapper;

import com.lemontree.daemon.dbmgr.model.NewsMsg;

import java.util.List;

public interface NewsMsgMapper extends SuperMapper<NewsMsg> {

    List<NewsMsg> getAll();

}