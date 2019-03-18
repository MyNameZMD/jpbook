package com.jpbook.entity;

import java.util.Date;

public class Rbreply {
    private Integer repid;
    private Integer revid;
    private Integer replytype;
    private String repcontent;
    private Integer from_uuid;
    private Integer to_uuid;
    private Date reptime;

    public Rbreply() {
    }

    public Rbreply(Integer repid, Integer revid, Integer replytype, String repcontent, Integer from_uuid, Integer to_uuid, Date reptime) {
        this.repid = repid;
        this.revid = revid;
        this.replytype = replytype;
        this.repcontent = repcontent;
        this.from_uuid = from_uuid;
        this.to_uuid = to_uuid;
        this.reptime = reptime;
    }

    public Integer getRepid() {
        return repid;
    }

    public void setRepid(Integer repid) {
        this.repid = repid;
    }

    public Integer getRevid() {
        return revid;
    }

    public void setRevid(Integer revid) {
        this.revid = revid;
    }

    public Integer getReplytype() {
        return replytype;
    }

    public void setReplytype(Integer replytype) {
        this.replytype = replytype;
    }

    public String getRepcontent() {
        return repcontent;
    }

    public void setRepcontent(String repcontent) {
        this.repcontent = repcontent;
    }

    public Integer getFrom_uuid() {
        return from_uuid;
    }

    public void setFrom_uuid(Integer from_uuid) {
        this.from_uuid = from_uuid;
    }

    public Integer getTo_uuid() {
        return to_uuid;
    }

    public void setTo_uuid(Integer to_uuid) {
        this.to_uuid = to_uuid;
    }

    public Date getReptime() {
        return reptime;
    }

    public void setReptime(Date reptime) {
        this.reptime = reptime;
    }

    @Override
    public String toString() {
        return "Rbreply{" +
                "repid=" + repid +
                ", revid=" + revid +
                ", replytype=" + replytype +
                ", repcontent='" + repcontent + '\'' +
                ", from_uuid=" + from_uuid +
                ", to_uuid=" + to_uuid +
                ", reptime=" + reptime +
                '}';
    }
}
