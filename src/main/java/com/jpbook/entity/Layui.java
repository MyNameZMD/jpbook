package com.jpbook.entity;

import java.util.List;

public class Layui {
	private Integer code=0;
	private String msg;
	private Integer count;
	private Integer limits=5;
	private List<?> data;
	public Integer getLimits() {
		return limits;
	}
	public void setLimits(Integer limits) {
		this.limits = limits;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
