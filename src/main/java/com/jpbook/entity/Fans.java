package com.jpbook.entity;

public class Fans {
	private Integer fansid;
	private Integer fanuuid;
	private Integer uuid;
	public Integer getFansid() {
		return fansid;
	}
	public void setFansid(Integer fansid) {
		this.fansid = fansid;
	}
	public Integer getFanuuid() {
		return fanuuid;
	}
	public void setFanuuid(Integer fanuuid) {
		this.fanuuid = fanuuid;
	}
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	@Override
	public String toString() {
		return "Fans [fansid=" + fansid + ", fanuuid=" + fanuuid + ", uuid="
				+ uuid + "]";
	}
	
}
