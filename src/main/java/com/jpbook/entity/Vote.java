package com.jpbook.entity;

import java.util.Date;

public class Vote {
	private Integer voteid;
	private Integer uuid;
	private Integer wtid;
	private Date votetime;
	private Integer bookid;
	public Integer getVoteid() {
		return voteid;
	}
	public Integer getUuid() {
		return uuid;
	}
	public Integer getWtid() {
		return wtid;
	}
	public Date getVotetime() {
		return votetime;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setVoteid(Integer voteid) {
		this.voteid = voteid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public void setWtid(Integer wtid) {
		this.wtid = wtid;
	}
	public void setVotetime(Date votetime) {
		this.votetime = votetime;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "Vote [voteid=" + voteid + ", uuid=" + uuid + ", wtid=" + wtid
				+ ", votetime=" + votetime + ", bookid=" + bookid + "]";
	}
	
}
