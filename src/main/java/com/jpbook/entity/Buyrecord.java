package com.jpbook.entity;

public class Buyrecord {
	private Integer buyid;
	private Integer uuid;
	private Integer chapid;
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
	@Override
	public String toString() {
		return "Buyrecord [buyid=" + buyid + ", uuid=" + uuid + ", chapid="
				+ chapid + "]";
	}
	

}
