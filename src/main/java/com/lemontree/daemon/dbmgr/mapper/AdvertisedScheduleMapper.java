package com.lemontree.daemon.dbmgr.mapper;

import com.lemontree.daemon.dbmgr.model.AdvertisedSchedule;

import java.util.List;

public interface AdvertisedScheduleMapper extends SuperMapper<AdvertisedSchedule> {

    List<AdvertisedSchedule> getAllEffect();
}