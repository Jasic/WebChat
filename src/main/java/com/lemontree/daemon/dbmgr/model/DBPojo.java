package com.lemontree.daemon.dbmgr.model;

import org.jasic.util.StringUtil;

import java.io.Serializable;

/**
 * User: Jasic
 * Date: 13-12-31
 */
public abstract class DBPojo implements Serializable {

    @Override
    public String toString() {
        String s = StringUtil.mapToString(StringUtil.fieldval2Map(this, SqlitePojo.class, 1));
        return s;
    }
}
