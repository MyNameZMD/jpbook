package com.jpbook.entity;

import java.util.Date;

public class Signexp {
    private Integer seid;
    private Date signtime;
    private Integer num;
    private Integer signlong;
    private Integer uuid;

    public Integer getSeid() {
        return seid;
    }
    public void setSeid(Integer seid) {
        this.seid = seid;
    }
    public Date getSigntime() {
        return signtime;
    }
    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSignlong() {
        return signlong;
    }
    public void setSignlong(Integer signlong) {
        this.signlong = signlong;
    }
    public Integer getUuid() {
        return uuid;
    }
    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Signexp{" +
                "seid=" + seid +
                ", signtime=" + signtime +
                ", num=" + num +
                ", signlong=" + signlong +
                ", uuid=" + uuid +
                '}';
    }
}
