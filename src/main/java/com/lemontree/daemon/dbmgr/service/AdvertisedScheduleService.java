package com.lemontree.daemon.dbmgr.service;

import com.lemontree.daemon.dbmgr.mapper.AdvertisedScheduleMapper;
import com.lemontree.daemon.dbmgr.mapper.SuperMapper;
import com.lemontree.daemon.dbmgr.model.AdvertisedSchedule;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author Jasic
 * Date 14-1-22.
 */
@Service
public class AdvertisedScheduleService extends BaseService<AdvertisedSchedule> {

    @Resource
    private AdvertisedScheduleMapper advertisedScheduleMapper;

    public List<AdvertisedSchedule> getAllEffect() {
        return advertisedScheduleMapper.getAllEffect();
    }

    @Override
    public SuperMapper<AdvertisedSchedule> getMapper() {
        return advertisedScheduleMapper;

    }
}
