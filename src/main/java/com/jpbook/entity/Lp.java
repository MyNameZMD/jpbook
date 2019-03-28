package com.jpbook.entity;

import java.util.List;
import java.util.Map;

public class Lp {

    private Integer status =  200;
    private String message =  "";
    private Integer total = 0;
    private Map<String,List<?>> rows;

    public Lp() {
    }
    public Lp(Map<String, List<?>> rows) {
        this.rows = rows;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public Map<String, List<?>> getRows() {
        return rows;
    }
    public void setRows(Map<String, List<?>> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Lp{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", total=" + total +
                ", rows=" + rows +
                '}';
    }
}
