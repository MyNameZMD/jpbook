package com.jpbook.entity;

public class Bookrack {
	private Integer brid;
	private Integer uuid;
	private Integer bookid;
	public Integer getBrid() {
		return brid;
	}
	public void setBrid(Integer brid) {
		this.brid = brid;
	}
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "Bookrack [brid=" + brid + ", uuid=" + uuid + ", bookid="
				+ bookid + "]";
	}
	
	

}
