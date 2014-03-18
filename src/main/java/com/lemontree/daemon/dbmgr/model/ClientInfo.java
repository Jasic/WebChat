package com.lemontree.daemon.dbmgr.model;

public class ClientInfo {
    private Integer pid;

    private String memberno;

    private Integer faninfoid;

    private String email;

    private String loginmode;

    private String clientname;

    private String password;

    private String address;

    private Integer clienttypeid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getMemberno() {
        return memberno;
    }

    public void setMemberno(String memberno) {
        this.memberno = memberno == null ? null : memberno.trim();
    }

    public Integer getFaninfoid() {
        return faninfoid;
    }

    public void setFaninfoid(Integer faninfoid) {
        this.faninfoid = faninfoid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getLoginmode() {
        return loginmode;
    }

    public void setLoginmode(String loginmode) {
        this.loginmode = loginmode == null ? null : loginmode.trim();
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname == null ? null : clientname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getClienttypeid() {
        return clienttypeid;
    }

    public void setClienttypeid(Integer clienttypeid) {
        this.clienttypeid = clienttypeid;
    }
}