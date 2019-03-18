package com.jpbook.entity;

public class Zan {
    private Integer zanid;
    private Integer reviewid;
    private Integer zantype;
    private Integer uuid;
    private Integer  zstate;

    public Zan() {
    }

    public Zan(Integer zanid, Integer reviewid, Integer zantype, Integer uuid, Integer zstate) {
        this.zanid = zanid;
        this.reviewid = reviewid;
        this.zantype = zantype;
        this.uuid = uuid;
        this.zstate = zstate;
    }

    public Integer getZanid() {
        return zanid;
    }

    public void setZanid(Integer zanid) {
        this.zanid = zanid;
    }

    public Integer getReviewid() {
        return reviewid;
    }

    public void setReviewid(Integer reviewid) {
        this.reviewid = reviewid;
    }

    public Integer getZantype() {
        return zantype;
    }

    public void setZantype(Integer zantype) {
        this.zantype = zantype;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getZstate() {
        return zstate;
    }

    public void setZstate(Integer zstate) {
        this.zstate = zstate;
    }

    @Override
    public String toString() {
        return "Zan{" +
                "zanid=" + zanid +
                ", reviewid=" + reviewid +
                ", zantype=" + zantype +
                ", uuid=" + uuid +
                ", zstate=" + zstate +
                '}';
    }
}
