package com.ssm.pojo;

public class Cate {

    private Integer cid;

    private String cateName;

    @Override
    public String toString() {
        return "Cate{" +
                "cid=" + cid +
                ", cateName='" + cateName + '\'' +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Cate() {
    }

    public Cate(Integer cid, String cateName) {
        this.cid = cid;
        this.cateName = cateName;
    }
}
