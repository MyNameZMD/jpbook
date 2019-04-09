package com.jpbook.entity;

import java.util.Date;

public class Notice {
    private Integer notid;
    private String notTitle;
    private String notvalue;
    private Date notTime;
    private Integer eid;

    @Override
    public String toString() {
        return "Notice{" +
                "notid=" + notid +
                ", notTitle='" + notTitle + '\'' +
                ", notvalue='" + notvalue + '\'' +
                ", notTime=" + notTime +
                ", eid=" + eid +
                '}';
    }

    public Integer getNotid() {
        return notid;
    }

    public void setNotid(Integer notid) {
        this.notid = notid;
    }

    public String getNotTitle() {
        return notTitle;
    }

    public void setNotTitle(String notTitle) {
        this.notTitle = notTitle;
    }

    public String getNotvalue() {
        return notvalue;
    }

    public void setNotvalue(String notvalue) {
        this.notvalue = notvalue;
    }

    public Date getNotTime() {
        return notTime;
    }

    public void setNotTime(Date notTime) {
        this.notTime = notTime;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
}
