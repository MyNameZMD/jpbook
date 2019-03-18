package com.jpbook.entity;

import java.sql.Date;
import java.util.List;

public class Roll {
	private Integer rollid;
	private String rollname;
	private Integer rollnum;
	private Integer bookid;
	private Date updatetime;
	private String url;
	private List<Chapter> chapterList;
	public Integer getRollid() {
		return rollid;
	}
	public void setRollid(Integer rollid) {
		this.rollid = rollid;
	}
	public String getRollname() {
		return rollname;
	}
	public void setRollname(String rollname) {
		this.rollname = rollname;
	}
	public Integer getRollnum() {
		return rollnum;
	}
	public void setRollnum(Integer rollnum) {
		this.rollnum = rollnum;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
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

	public List<Chapter> getChapterList() {
		return chapterList;
	}

	public void setChapterList(List<Chapter> chapterList) {
		this.chapterList = chapterList;
	}

	@Override
	public String toString() {
		return "Roll [rollid=" + rollid + ", rollname=" + rollname
				+ ", rollnum=" + rollnum + ", bookid=" + bookid
				+ ", updatetime=" + updatetime + ", url=" + url + "]";
	}
	
}
