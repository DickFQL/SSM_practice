package com.ssm.pojo;

public class Brand {

    private Integer bid;

    private String brandName;

    public Brand(Integer bid, String brandName) {
        this.bid = bid;
        this.brandName = brandName;
    }

    public Brand() {
    }

    @Override
    public String toString() {
        return "Brand{" +
                "bid=" + bid +
                ", brandName='" + brandName + '\'' +
                '}';
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
