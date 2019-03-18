package com.jpbook.entity;

import java.sql.Date;

public class Buyrecord {
	private Integer buyid;
	private Integer uuid;
	private Integer chapid;
	private Date buydate;
	public Integer getBuyid() {
		return buyid;
	}
	public void setBuyid(Integer buyid) {
		this.buyid = buyid;
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
	public Date getBuydate() {
		return buydate;
	}
	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}

	@Override
	public String toString() {
		return "Buyrecord [buyid=" + buyid + ", uuid=" + uuid + ", chapid="
				+ chapid + "]";
	}
	

}
