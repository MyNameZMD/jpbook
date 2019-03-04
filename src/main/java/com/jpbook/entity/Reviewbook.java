package com.jpbook.entity;

import java.util.Date;

public class Reviewbook {
	private Integer revid;
	private String revtitle;
	private String revvlue;
	private Date commenttime;
	private Integer uuid;
	private Integer bookid;
	public Integer getRevid() {
		return revid;
	}
	public void setRevid(Integer revid) {
		this.revid = revid;
	}
	public String getRevtitle() {
		return revtitle;
	}
	public void setRevtitle(String revtitle) {
		this.revtitle = revtitle;
	}
	public String getRevvlue() {
		return revvlue;
	}
	public void setRevvlue(String revvlue) {
		this.revvlue = revvlue;
	}
	public Date getCommenttime() {
		return commenttime;
	}
	public void setCommenttime(Date commenttime) {
		this.commenttime = commenttime;
	}
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "Reviewbook [revid=" + revid + ", revtitle=" + revtitle
				+ ", revvlue=" + revvlue + ", commenttime=" + commenttime
				+ ", uuid=" + uuid + ", bookid=" + bookid + "]";
	}

}
