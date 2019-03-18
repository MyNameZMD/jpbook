package com.jpbook.entity;

import java.sql.Date;

public class Click {
    private Integer cid;
    private Integer bookid;
    private Integer uuid;
    private Date clicktime;
    private Integer cnum;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Date getClicktime() {
        return clicktime;
    }

    public void setClicktime(Date clicktime) {
        this.clicktime = clicktime;
    }

    public Integer getCnum() {
        return cnum;
    }

    public void setCnum(Integer cnum) {
        this.cnum = cnum;
    }

    public Click(Integer cid, Integer bookid, Integer uuid, Date clicktime, Integer cnum) {
        this.cid = cid;
        this.bookid = bookid;
        this.uuid = uuid;
        this.clicktime = clicktime;
        this.cnum = cnum;
    }

    public Click() {
    }

    @Override
    public String toString() {
        return "Click{" +
                "cid=" + cid +
                ", bookid=" + bookid +
                ", uuid=" + uuid +
                ", clicktime=" + clicktime +
                ", cnum=" + cnum +
                '}';
    }
}
