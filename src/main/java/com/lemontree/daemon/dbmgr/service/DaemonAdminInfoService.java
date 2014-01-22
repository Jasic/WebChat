package com.lemontree.daemon.dbmgr.service;

import com.lemontree.daemon.dbmgr.mapper.DaemonAdminInfoMapper;
import com.lemontree.daemon.dbmgr.mapper.SuperMapper;
import com.lemontree.daemon.dbmgr.model.DaemonAdminInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author Jasic
 * Date 14-1-20.
 */
@Service
public class DaemonAdminInfoService extends BaseService<DaemonAdminInfo> {


    @Resource
    private DaemonAdminInfoMapper daemonAdminInfoMapper;


    public List<DaemonAdminInfo> getAll() {
        return daemonAdminInfoMapper.getAll();
    }

    @Override
    public SuperMapper<DaemonAdminInfo> getMapper() {
        return daemonAdminInfoMapper;
    }
}
