package com.jpbook.entity;

public class Likes {

    private Integer lid;
    private Integer revid;
    private Integer uuid;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getRevid() {
        return revid;
    }

    public void setRevid(Integer revid) {
        this.revid = revid;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Likes(Integer lid, Integer revid, Integer uuid) {
        this.lid = lid;
        this.revid = revid;
        this.uuid = uuid;
    }

    public Likes() {
    }

    @Override
    public String toString() {
        return "Likes{" +
                "lid=" + lid +
                ", revid=" + revid +
                ", uuid=" + uuid +
                '}';
    }
}
