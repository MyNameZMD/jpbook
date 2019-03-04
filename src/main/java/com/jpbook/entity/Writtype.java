package com.jpbook.entity;

public class Writtype {
	private Integer wtid;
	private String wtname;
	public Integer getWtid() {
		return wtid;
	}
	public String getWtname() {
		return wtname;
	}
	public void setWtid(Integer wtid) {
		this.wtid = wtid;
	}
	public void setWtname(String wtname) {
		this.wtname = wtname;
	}
	@Override
	public String toString() {
		return "Writtype [wtid=" + wtid + ", wtname=" + wtname + "]";
	}
	
}
