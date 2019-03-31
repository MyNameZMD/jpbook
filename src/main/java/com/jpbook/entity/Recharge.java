package com.jpbook.entity;

import java.util.Date;

public class Recharge {
	private Integer recid;
	private Integer uuid;
	private Integer money;
	private Date topuptime;
	private String topupnotes;

	public Integer getRecid() {
		return recid;
	}
	public void setRecid(Integer recid) {
		this.recid = recid;
	}
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}

	public Date getTopuptime() {
		return topuptime;
	}

	public void setTopuptime(Date topuptime) {
		this.topuptime = topuptime;
	}

	public String getTopupnotes() {
		return topupnotes;
	}

	public void setTopupnotes(String topupnotes) {
		this.topupnotes = topupnotes;
	}

	@Override
	public String toString() {
		return "Recharge{" +
				"recid=" + recid +
				", uuid=" + uuid +
				", money=" + money +
				", topuptime=" + topuptime +
				", topupnotes='" + topupnotes + '\'' +
				'}';
	}
}
