package com.lemontree.daemon.dbmgr.service;

import com.lemontree.daemon.dbmgr.mapper.SuperMapper;
import com.lemontree.daemon.dbmgr.mapper.TextMapper;
import com.lemontree.daemon.dbmgr.model.Text;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author Jasic
 * Date 14-3-26.
 */
@Service
public class TextService extends BaseService<Text> {

    @Resource
    private TextMapper mapper;

    @Override
    public SuperMapper<Text> getMapper() {
        return mapper;
    }

    public List<Text> getAll() {
        return mapper.getAll();
    }
}
