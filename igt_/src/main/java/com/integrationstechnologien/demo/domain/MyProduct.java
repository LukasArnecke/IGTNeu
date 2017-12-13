package com.integrationstechnologien.demo.domain;

import javax.persistence.*;

@Entity
public class MyProduct implements Product{

    private double pPreis;
    private String pName;

    @Id
    @GeneratedValue
    private String pId;

    public MyProduct() { }

    public MyProduct(double pPreis, String pName) {
        super();
        this.pPreis = pPreis;
        this.pName = pName;
    }

    public String getpId() { return pId; }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public double getpPreis() { return pPreis; }

    public void setpPreis(double pPreis) { this.pPreis = pPreis; }

    public String getpName() { return pName; }

    public void setpName(String pName) { this.pName = pName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyProduct myProduct = (MyProduct) o;

        if (Double.compare(myProduct.pPreis, pPreis) != 0) return false;
        if (pName != null ? !pName.equals(myProduct.pName) : myProduct.pName != null) return false;
        return pId != null ? pId.equals(myProduct.pId) : myProduct.pId == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(pPreis);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (pName != null ? pName.hashCode() : 0);
        result = 31 * result + (pId != null ? pId.hashCode() : 0);
        return result;
    }
}
