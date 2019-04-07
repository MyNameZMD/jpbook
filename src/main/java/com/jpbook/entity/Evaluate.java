package com.jpbook.entity;

import java.util.Date;

public class Evaluate {
    private Integer evaid;
    private Integer bookid;
    private Integer uuid;
    private String evacontent;
    private Date evatime;
    private Integer evalv;
    private Date edittime;

    public Evaluate(Integer evaid, Integer bookid, Integer uuid, String evacontent, Date evatime, Integer evalv, Date edittime) {
        this.evaid = evaid;
        this.bookid = bookid;
        this.uuid = uuid;
        this.evacontent = evacontent;
        this.evatime = evatime;
        this.evalv = evalv;
        this.edittime = edittime;
    }

    public Integer getEvaid() {
        return evaid;
    }

    public void setEvaid(Integer evaid) {
        this.evaid = evaid;
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

    public String getEvacontent() {
        return evacontent;
    }

    public void setEvacontent(String evacontent) {
        this.evacontent = evacontent;
    }

    public Date getEvatime() {
        return evatime;
    }

    public void setEvatime(Date evatime) {
        this.evatime = evatime;
    }

    public Integer getEvalv() {
        return evalv;
    }

    public void setEvalv(Integer evalv) {
        this.evalv = evalv;
    }

    public Date getEdittime() {
        return edittime;
    }

    public void setEdittime(Date edittime) {
        this.edittime = edittime;
    }

    public Evaluate() {
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "evaid=" + evaid +
                ", bookid=" + bookid +
                ", uuid=" + uuid +
                ", evacontent='" + evacontent + '\'' +
                ", evatime=" + evatime +
                ", evalv=" + evalv +
                ", edittime=" + edittime +
                '}';
    }
}
