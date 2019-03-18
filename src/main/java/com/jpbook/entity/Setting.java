package com.jpbook.entity;

public class Setting {
    private Integer setid;
    private String setcolor;
    private String setfont;
    private Integer setfontsize;
    private Integer uuid;

    public Integer getSetid() {
        return setid;
    }

    public void setSetid(Integer setid) {
        this.setid = setid;
    }

    public String getSetcolor() {
        return setcolor;
    }

    public void setSetcolor(String setcolor) {
        this.setcolor = setcolor;
    }

    public String getSetfont() {
        return setfont;
    }

    public void setSetfont(String setfont) {
        this.setfont = setfont;
    }

    public Integer getSetfontsize() {
        return setfontsize;
    }

    public void setSetfontsize(Integer setfontsize) {
        this.setfontsize = setfontsize;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "setid=" + setid +
                ", setcolor='" + setcolor + '\'' +
                ", setfont='" + setfont + '\'' +
                ", setfontsize=" + setfontsize +
                ", uuid=" + uuid +
                '}';
    }
}
