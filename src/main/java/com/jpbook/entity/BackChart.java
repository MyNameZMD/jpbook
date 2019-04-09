package com.jpbook.entity;

import java.util.Arrays;
import java.util.Map;

public class BackChart {
    private String name;
    private String type;
    private Object[] data;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "{" +
                "name:'" + name + '\'' +
                ", type:'" + type + '\'' +
                ", data:" + Arrays.toString(data) +
                ", markPoint:{" +
                "data:[" +
                "                    {type : 'max', name: '最大值'}," +
                "                    {type : 'min', name: '最小值'}" +
                "                ]" +
                "}" +
                '}';
    }
}
