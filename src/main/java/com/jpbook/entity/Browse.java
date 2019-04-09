package com.jpbook.entity;

import java.sql.Date;

public class Browse {
	private Integer browseid;
	private Integer uuid;
	private Integer chapid;
	private Date btime;
	public Integer getBrowseid() {
		return browseid;
	}
	public void setBrowseid(Integer browseid) {
		this.browseid = browseid;
	}
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public Integer getChapid() {
		return chapid;
	}
	public void setChapid(Integer chapid) {
		this.chapid = chapid;
	}
	public Date getBtime() { return btime; }
	public void setBtime(Date btime) { this.btime = btime; }

	public Browse(Integer uuid, Integer chapid) {
		this.uuid = uuid;
		this.chapid = chapid;
	}

	public Browse() {
	}

	@Override
	public String toString() {
		return "Browse [browseid=" + browseid + ", uuid=" + uuid + ", chapid="
				+ chapid + "]";
	}
	

}
