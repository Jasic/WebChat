package com.lemontree.daemon.dbmgr.mapper;

import com.lemontree.daemon.dbmgr.model.RestaurantGroup;

import java.util.List;

public interface RestaurantGroupMapper extends SuperMapper<RestaurantGroup> {

    List<RestaurantGroup> getAll();

}