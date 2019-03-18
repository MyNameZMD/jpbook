package com.jpbook.entity;

import java.util.Date;

public class Reviewbook {
	private Integer revid;
	private String revtitle;
	private String revvlue;
	private Date commenttime;
	private Integer uuid;
	private Integer bookid;
	private Integer retype;

	public Integer getRetype() {
		return retype;
	}

	public void setRetype(Integer retype) {
		this.retype = retype;
	}

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

	public Reviewbook() {
	}

	public Reviewbook(Integer revid, String revvlue, Date commenttime, Integer uuid, Integer retype, Integer bookid) {
		this.revid = revid;
		this.revvlue = revvlue;
		this.commenttime = commenttime;
		this.uuid = uuid;
		this.retype = retype;
		this.bookid = bookid;
	}

	@Override
	public String toString() {
		return "Reviewbook{" +
				"revid=" + revid +
				", revvlue='" + revvlue + '\'' +
				", commenttime=" + commenttime +
				", uuid=" + uuid +
				", retype=" + retype +
				", bookid=" + bookid +
				'}';
	}
}
