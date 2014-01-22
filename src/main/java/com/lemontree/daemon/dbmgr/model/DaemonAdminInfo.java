package com.lemontree.daemon.dbmgr.model;

public class DaemonAdminInfo {
    private Integer pid;

    private Integer restid;

    private String staffname;

    private String passwd;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getRestid() {
        return restid;
    }

    public void setRestid(Integer restid) {
        this.restid = restid;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname == null ? null : staffname.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }
}