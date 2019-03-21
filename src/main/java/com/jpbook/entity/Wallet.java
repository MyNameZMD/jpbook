package com.jpbook.entity;

import java.util.Date;

public class Wallet {
	private Integer walid;
	private Integer uuid;
	private Integer wtid;
	private Integer walnum;
	private Date waltime;

	public Integer getWalid() {
		return walid;
	}
	public Integer getUuid() {
		return uuid;
	}
	public Integer getWtid() {
		return wtid;
	}
	public Integer getWalnum() {
		return walnum;
	}
	public void setWalid(Integer walid) {
		this.walid = walid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public void setWtid(Integer wtid) {
		this.wtid = wtid;
	}
	public void setWalnum(Integer walnum) {
		this.walnum = walnum;
	}

	public Date getWaltime() {
		return waltime;
	}

	public void setWaltime(Date waltime) {
		this.waltime = waltime;
	}

	@Override
	public String toString() {
		return "Wallet{" +
				"walid=" + walid +
				", uuid=" + uuid +
				", wtid=" + wtid +
				", walnum=" + walnum +
				", waltime=" + waltime +
				'}';
	}
}
