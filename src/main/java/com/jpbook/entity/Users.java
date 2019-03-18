package com.jpbook.entity;

import java.sql.Date;

public class Users {
	private Integer uuid;
	private String uname;
	private String pwd;
	private Integer sex;
	private Date birthday;
	private String realname;
	private String idcard;
	private String phone;
	private Integer vip;
	private Integer rechargeamount;
	private Integer pro;
	private Integer city;
	private String self;
	private String icon;
	private Integer exp;
	private Integer grade;
	private Integer money;
	private String pen;
	private String qqid;
	private String email;
	public Integer getUuid() {
		return uuid;
	}
	public String getUname() {
		return uname;
	}
	public String getPwd() {
		return pwd;
	}
	public Integer getSex() {
		return sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public String getRealname() {
		return realname;
	}
	public String getIdcard() {
		return idcard;
	}
	public String getPhone() {
		return phone;
	}
	public Integer getVip() {
		return vip;
	}
	public Integer getRechargeamount() {
		return rechargeamount;
	}
	public Integer getPro() {
		return pro;
	}
	public Integer getCity() {
		return city;
	}
	public String getSelf() {
		return self;
	}
	public String getIcon() {
		return icon;
	}
	public Integer getExp() {
		return exp;
	}
	public Integer getGrade() {
		return grade;
	}
	public Integer getMoney() {
		return money;
	}
	public String getPen() {
		return pen;
	}
	public String getQqid() {
		return qqid;
	}
	public String getEmail() {
		return email;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setVip(Integer vip) {
		this.vip = vip;
	}
	public void setRechargeamount(Integer rechargeamount) {
		this.rechargeamount = rechargeamount;
	}
	public void setPro(Integer pro) {
		this.pro = pro;
	}
	public void setCity(Integer city) {
		this.city = city;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public void setExp(Integer exp) {
		this.exp = exp;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public void setPen(String pen) {
		this.pen = pen;
	}
	public void setQqid(String qqid) {
		this.qqid = qqid;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Users [uuid=" + uuid + ", uname=" + uname + ", pwd=" + pwd
				+ ", sex=" + sex + ", birthday=" + birthday + ", realname="
				+ realname + ", idcard=" + idcard + ", phone=" + phone
				+ ", vip=" + vip + ", rechargeamount=" + rechargeamount
				+ ", pro=" + pro + ", city=" + city + ", self=" + self
				+ ", icon=" + icon + ", exp=" + exp + ", grade=" + grade
				+ ", money=" + money + ", pen=" + pen + ", qqid=" + qqid
				+ ", email=" + email + "]";
	}
	
}
