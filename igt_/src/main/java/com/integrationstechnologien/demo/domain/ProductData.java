package com.integrationstechnologien.demo.domain;

public class ProductData implements Product {

    private String pId;
    private double pPreis;
    private String pName;
    public ProductData(){}
    public ProductData(double pPreis, String pName) {
        this.pPreis = pPreis;
        this.pName = pName;
    }
    public ProductData(Product product){}
    @Override
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductData that = (ProductData) o;

        if (Double.compare(that.pPreis, pPreis) != 0) return false;
        if (pId != null ? !pId.equals(that.pId) : that.pId != null) return false;
        return pName != null ? pName.equals(that.pName) : that.pName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = pId != null ? pId.hashCode() : 0;
        temp = Double.doubleToLongBits(pPreis);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (pName != null ? pName.hashCode() : 0);
        return result;
    }
}
