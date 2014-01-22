package com.lemontree.daemon.dbmgr.service;

import com.lemontree.daemon.dbmgr.mapper.RestaurantInfoMapper;
import com.lemontree.daemon.dbmgr.mapper.SuperMapper;
import com.lemontree.daemon.dbmgr.model.RestaurantInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author Jasic
 * Date 14-1-20.
 */
@Service
public class RestaurantInfoService extends BaseService<RestaurantInfo> {

    @Resource
    private RestaurantInfoMapper restaurantInfoMapper;

    public List<RestaurantInfo> getAll() {
        return restaurantInfoMapper.getAll();
    }

    @Override
    public SuperMapper<RestaurantInfo> getMapper() {

        return restaurantInfoMapper;
    }
}
