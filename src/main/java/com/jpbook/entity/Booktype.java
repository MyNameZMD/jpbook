package com.jpbook.entity;

public class Booktype {
	private Integer btid;
	private String btname;
	private String btico;
	public Integer getBtid() {
		return btid;
	}
	public void setBtid(Integer btid) {
		this.btid = btid;
	}
	public String getBtname() {
		return btname;
	}
	public void setBtname(String btname) {
		this.btname = btname;
	}
	public String getBtico() {
		return btico;
	}
	public void setBtico(String btico) {
		this.btico = btico;
	}
	@Override
	public String toString() {
		return "Booktype [btid=" + btid + ", btname=" + btname + ", btico="
				+ btico + "]";
	}
	
}
