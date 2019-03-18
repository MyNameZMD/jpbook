package com.jpbook.entity;

import java.sql.Date;

public class Chapter {
	private Integer chapid;
	private String chapvalue;
	private Integer chapnum;
	private Integer chapmoney;
	private Integer chapstate;
	private Date chaptime;
	private Date updatetime;
	private String url;
	public Integer getChapid() {
		return chapid;
	}
	public void setChapid(Integer chapid) {
		this.chapid = chapid;
	}
	public String getChapvalue() {
		return chapvalue;
	}
	public void setChapvalue(String chapvalue) {
		this.chapvalue = chapvalue;
	}
	public Integer getChapnum() {
		return chapnum;
	}
	public void setChapnum(Integer chapnum) {
		this.chapnum = chapnum;
	}
	public Integer getChapmoney() {
		return chapmoney;
	}
	public void setChapmoney(Integer chapmoney) {
		this.chapmoney = chapmoney;
	}
	public Integer getChapstate() {
		return chapstate;
	}
	public void setChapstate(Integer chapstate) {
		this.chapstate = chapstate;
	}
	public Date getChaptime() {
		return chaptime;
	}
	public void setChaptime(Date chaptime) {
		this.chaptime = chaptime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Chapter [chapid=" + chapid + ", chapvalue=" + chapvalue
				+ ", chapnum=" + chapnum + ", chapmoney=" + chapmoney
				+ ", chapstate=" + chapstate + ", chaptime=" + chaptime
				+ ", updatetime=" + updatetime + ", url=" + url + "]";
	}
	

}
