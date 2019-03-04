package com.jpbook.entity;

import java.util.Date;

public class Books {
	private Integer bookid;
	private String bookname;
	private Integer uuid;
	private Integer btid;
	private Integer bookstate;
	private Date createtime;
	private String url;
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
	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", bookname=" + bookname + ", uuid="
				+ uuid + ", btid=" + btid + ", bookstate=" + bookstate
				+ ", createtime=" + createtime + ", url=" + url + "]";
	}
	

}
