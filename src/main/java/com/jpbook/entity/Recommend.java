package com.jpbook.entity;

import java.util.Date;

public class Recommend {
    private Integer reid;
    private Integer reeid;
    private Integer rebookid;
    private Integer retype;
    private Date redate;

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public Integer getReeid() {
        return reeid;
    }

    public void setReeid(Integer reeid) {
        this.reeid = reeid;
    }

    public Integer getRebookid() {
        return rebookid;
    }

    public void setRebookid(Integer rebookid) {
        this.rebookid = rebookid;
    }

    public Integer getRetype() {
        return retype;
    }

    public void setRetype(Integer retype) {
        this.retype = retype;
    }

    public Date getRedate() {
        return redate;
    }

    public void setRedate(Date redate) {
        this.redate = redate;
    }

    public Recommend(Integer reid, Integer reeid, Integer rebookid, Integer retype, Date redate) {
        this.reid = reid;
        this.reeid = reeid;
        this.rebookid = rebookid;
        this.retype = retype;
        this.redate = redate;
    }

    public Recommend() {
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "reid=" + reid +
                ", reeid=" + reeid +
                ", rebookid=" + rebookid +
                ", retype=" + retype +
                ", redate=" + redate +
                '}';
    }
}
