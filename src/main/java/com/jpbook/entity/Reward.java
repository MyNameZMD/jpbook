package com.jpbook.entity;

import java.sql.Date;

public class Reward {
	private Integer rewaid;
	private Integer uuid;
	private Integer rewanum;
	private Integer bookid;
	private Date rewatime;
	public Integer getRewaid() {
		return rewaid;
	}
	public void setRewaid(Integer rewaid) {
		this.rewaid = rewaid;
	}
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public Integer getRewanum() {
		return rewanum;
	}
	public void setRewanum(Integer rewanum) {
		this.rewanum = rewanum;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public Date getRewatime() {
		return rewatime;
	}
	public void setRewatime(Date rewatime) {
		this.rewatime = rewatime;
	}

	@Override
	public String toString() {
		return "Reward [rewaid=" + rewaid + ", uuid=" + uuid + ", rewanum="
				+ rewanum + ", bookid=" + bookid + "]";
	}

}
