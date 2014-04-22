package com.lemontree.daemon.dbmgr.mapper;

import com.lemontree.daemon.dbmgr.model.Text;

import java.util.List;

public interface TextMapper extends SuperMapper<Text>{

    List<Text> getAll();
}