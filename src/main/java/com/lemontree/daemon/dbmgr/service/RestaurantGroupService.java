package com.lemontree.daemon.dbmgr.service;

import com.lemontree.daemon.dbmgr.mapper.RestaurantGroupMapper;
import com.lemontree.daemon.dbmgr.mapper.SuperMapper;
import com.lemontree.daemon.dbmgr.model.RestaurantGroup;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author Jasic
 * Date 14-1-20.
 */
@Service
public class RestaurantGroupService extends BaseService<RestaurantGroup> {

    @Resource
    private RestaurantGroupMapper restaurantGroupMapper;

    public List<RestaurantGroup> getAll() {
        return restaurantGroupMapper.getAll();
    }

    @Override
    public SuperMapper<RestaurantGroup> getMapper() {
        return restaurantGroupMapper;
    }
}
