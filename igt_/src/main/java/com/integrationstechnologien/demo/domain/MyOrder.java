package com.integrationstechnologien.demo.domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
public class MyOrder{
    @Id
    @GeneratedValue
    private String oId;
    private double oTotal;
    @ManyToOne(targetEntity = MyCustomer.class )
    private MyCustomer oCid;
    @OneToMany(targetEntity = MyProduct.class)
    private List<MyProduct> oPid = new LinkedList<MyProduct>();

    public MyOrder(){}

    public MyOrder(double oTotal) {
        super();
        this.oTotal = oTotal;
    }

    public String getoId() { return oId; }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public double getoTotal() { return oTotal; }

    public void setoTotal(double oTotal) { this.oTotal = oTotal; }

    public MyCustomer getoCid() { return oCid; }

    public void setoCid(MyCustomer oCid) {
        this.oCid = oCid;
    }

    public List<MyProduct> getoPid() { return oPid; }

    public void setoPid(List<MyProduct> oPid) { this.oPid = oPid; }

    @Override
    public String toString() { return "Order{" + "oId=" + oId + '}'; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyOrder myOrder = (MyOrder) o;

        if (Double.compare(myOrder.oTotal, oTotal) != 0) return false;
        if (oId != null ? !oId.equals(myOrder.oId) : myOrder.oId != null) return false;
        if (oCid != null ? !oCid.equals(myOrder.oCid) : myOrder.oCid != null) return false;
        return oPid != null ? oPid.equals(myOrder.oPid) : myOrder.oPid == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = oId != null ? oId.hashCode() : 0;
        temp = Double.doubleToLongBits(oTotal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (oCid != null ? oCid.hashCode() : 0);
        result = 31 * result + (oPid != null ? oPid.hashCode() : 0);
        return result;
    }
}
