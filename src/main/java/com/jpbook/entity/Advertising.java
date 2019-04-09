package com.jpbook.entity;

import java.util.Date;

public class Advertising {
    private Integer adid;
    private Integer bookid;
    private String pic;
    private Integer eid;
    private Date adtime;

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getAdtime() {
        return adtime;
    }

    public void setAdtime(Date adtime) {
        this.adtime = adtime;
    }

    @Override
    public String toString() {
        return "Advertising{" +
                "adid=" + adid +
                ", bookid=" + bookid +
                ", pic='" + pic + '\'' +
                ", eid=" + eid +
                ", adtime=" + adtime +
                '}';
    }
}
