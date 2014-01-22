package com.lemontree.daemon.dbmgr.service;

import com.lemontree.daemon.dbmgr.mapper.ServiceInfoMapper;
import com.lemontree.daemon.dbmgr.mapper.SuperMapper;
import com.lemontree.daemon.dbmgr.model.ServiceInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author Jasic
 * Date 14-1-17.
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ServiceInfoService extends BaseService<ServiceInfo> {

    @Resource
    private ServiceInfoMapper serviceInfoMapper;

    public List<ServiceInfo> getAll() {
        return serviceInfoMapper.getAll();
    }

    @Override
    public SuperMapper<ServiceInfo> getMapper() {
        return serviceInfoMapper;
    }
}
