package com.jpbook.entity;

import java.util.List;

public class LayuiPage {

    private Integer code = 0;
    private String msg = "";
    private Integer count;      // 总页数
    private List<?> data;       // 数据

    private Integer page=0;
    private Integer limit=10;

    private String searchContent = ""; //查找内容

    public LayuiPage() { }
    public LayuiPage(List<?> data) {
        this.data = data;
    }
    public LayuiPage(Integer count, List<?> data) {
        this.count = count;
        this.data = data;
    }

    public LayuiPage(Integer count, List<?> data, Integer page, Integer limit) {
        this.count = count;
        this.data = data;
        this.page = page;
        this.limit = limit;
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
    public void setCount(Integer count) { this.count = count; }

    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        if (null == this.limit) {
            limit = 10;
        }
        if (null == this.page) {
            page = 1;
        }
        this.page = (page - 1) * limit;
    }
    public Integer getLimit() {
        return limit;
    }
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSearchContent() {
        return searchContent;
    }
    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    @Override
    public String toString() {
        return "LayuiPage{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                ", page=" + page +
                ", limit=" + limit +
                ", searchContent='" + searchContent + '\'' +
                '}';
    }
}
