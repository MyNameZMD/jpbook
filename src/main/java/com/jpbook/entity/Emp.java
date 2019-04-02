package com.jpbook.entity;

import java.util.Date;

public class Emp {
	private Integer eid;
	private String ename;
	private String epwd;
	private String ephone;
	private String eidcard;
	private Integer position;
	private String sex;
	private String email;
	private Date regtime;
	private Integer state;

	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEpwd() {
		return epwd;
	}
	public void setEpwd(String epwd) {
		this.epwd = epwd;
	}
	public String getEphone() {
		return ephone;
	}
	public void setEphone(String ephone) {
		this.ephone = ephone;
	}
	public String getEidcard() {
		return eidcard;
	}
	public void setEidcard(String eidcard) {
		this.eidcard = eidcard;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Emp{" +
				"eid=" + eid +
				", ename='" + ename + '\'' +
				", epwd='" + epwd + '\'' +
				", ephone='" + ephone + '\'' +
				", eidcard='" + eidcard + '\'' +
				", position=" + position +
				", sex='" + sex + '\'' +
				", email='" + email + '\'' +
				", regtime=" + regtime +
				", state=" + state +
				'}';
	}
}
