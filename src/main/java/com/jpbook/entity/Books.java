package com.jpbook.entity;

import java.sql.Date;

public class Books {
	private Integer bookid;
	private String bookname;
	private String icon;
	private Integer uuid;
	private Integer btid;
	private Integer bookstate;
	private Date createtime;
	private Date endtime;
	private String url;
	private Integer sex;

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getSex() {
		return sex;
	}
	private String bookreferral;
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public Integer getBtid() {
		return btid;
	}
	public void setBtid(Integer btid) {
		this.btid = btid;
	}
	public Integer getBookstate() {
		return bookstate;
	}
	public void setBookstate(Integer bookstate) {
		this.bookstate = bookstate;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public Books(Integer bookid, String bookname, String icon, Integer uuid, Integer btid, Integer bookstate, Date createtime, Date endtime, String url, Integer sex) {
		this.bookid = bookid;
		this.bookname = bookname;
		this.icon = icon;
		this.uuid = uuid;
		this.btid = btid;
		this.bookstate = bookstate;
		this.createtime = createtime;
		this.endtime = endtime;
		this.url = url;
		this.sex = sex;
	}


	@Override
	public String toString() {
		return "Books{" +
				"bookid=" + bookid +
				", bookname='" + bookname + '\'' +
				", icon='" + icon + '\'' +
				", uuid=" + uuid +
				", btid=" + btid +
				", bookstate=" + bookstate +
				", createtime=" + createtime +
				", endtime=" + endtime +
				", url='" + url + '\'' +
				", sex=" + sex +
				'}';
	}
}
