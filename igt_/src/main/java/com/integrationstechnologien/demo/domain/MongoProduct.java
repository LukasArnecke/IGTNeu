package com.integrationstechnologien.demo.domain;


import javax.persistence.*;

public class MongoProduct {
    @Id
    private String pId;
    private double pPreis;
    private String pName;

    public MongoProduct(){

    }

    public MongoProduct(String pName, double pPreis){
        super();
        this.pPreis = pPreis;
        this.pName = pName;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public double getpPreis() {
        return pPreis;
    }

    public void setpPreis(double pPreis) {
        this.pPreis = pPreis;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }
}
