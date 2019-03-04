package com.jpbook.entity;

public class Recharge {
	private Integer recid;
	private Integer uuid;
	private Integer money;
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
	@Override
	public String toString() {
		return "Recharge [recid=" + recid + ", uuid=" + uuid + ", money="
				+ money + "]";
	}
	
}
