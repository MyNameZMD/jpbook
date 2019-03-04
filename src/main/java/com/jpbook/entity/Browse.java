package com.jpbook.entity;

public class Browse {
	private Integer browseid;
	private Integer uuid;
	private Integer chapid;
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
	@Override
	public String toString() {
		return "Browse [browseid=" + browseid + ", uuid=" + uuid + ", chapid="
				+ chapid + "]";
	}
	

}
