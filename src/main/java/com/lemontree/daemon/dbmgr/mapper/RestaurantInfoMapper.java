package com.lemontree.daemon.dbmgr.mapper;

import com.lemontree.daemon.dbmgr.model.RestaurantInfo;

import java.util.List;

public interface RestaurantInfoMapper extends SuperMapper<RestaurantInfo> {

    List<RestaurantInfo> getAll();

}