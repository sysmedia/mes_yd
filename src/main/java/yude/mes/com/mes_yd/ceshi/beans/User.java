package yude.mes.com.mes_yd.ceshi.beans;

public class User {
    private String usercode;

    private String userpwd;

    private String username;

    private String usertel;

    private String useremail;

    private String userdepart;

    private String muser;

    private Integer mdate;

    private Integer mtime;

    private String eattribute1;

    private String userstat;

    private String loginres;

    private Integer logindate;

    private Integer logintime;

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel == null ? null : usertel.trim();
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public String getUserdepart() {
        return userdepart;
    }

    public void setUserdepart(String userdepart) {
        this.userdepart = userdepart == null ? null : userdepart.trim();
    }

    public String getMuser() {
        return muser;
    }

    public void setMuser(String muser) {
        this.muser = muser == null ? null : muser.trim();
    }

    public Integer getMdate() {
        return mdate;
    }

    public void setMdate(Integer mdate) {
        this.mdate = mdate;
    }

    public Integer getMtime() {
        return mtime;
    }

    public void setMtime(Integer mtime) {
        this.mtime = mtime;
    }

    public String getEattribute1() {
        return eattribute1;
    }

    public void setEattribute1(String eattribute1) {
        this.eattribute1 = eattribute1 == null ? null : eattribute1.trim();
    }

    public String getUserstat() {
        return userstat;
    }

    public void setUserstat(String userstat) {
        this.userstat = userstat == null ? null : userstat.trim();
    }

    public String getLoginres() {
        return loginres;
    }

    public void setLoginres(String loginres) {
        this.loginres = loginres == null ? null : loginres.trim();
    }

    public Integer getLogindate() {
        return logindate;
    }

    public void setLogindate(Integer logindate) {
        this.logindate = logindate;
    }

    public Integer getLogintime() {
        return logintime;
    }

    public void setLogintime(Integer logintime) {
        this.logintime = logintime;
    }
}