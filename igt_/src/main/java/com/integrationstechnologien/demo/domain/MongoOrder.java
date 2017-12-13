package com.integrationstechnologien.demo.domain;

import com.integrationstechnologien.demo.domain.MongoCustomer;
import com.integrationstechnologien.demo.domain.Order;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


public class MongoOrder {

    @Id
    private String oId;
    private double oTotal;
    @DBRef
    private MongoCustomer oCid;
    @DBRef
    private Set<MongoProduct> oPid = new HashSet<MongoProduct>();

    public MongoOrder(){

    }

    public MongoOrder(double oTotal){
        super();
        this.oTotal = oTotal;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public double getoTotal() {
        return oTotal;
    }

    public void setoTotal(double oTotal) {
        this.oTotal = oTotal;
    }

    public MongoCustomer getoCid() {
        return oCid;
    }

    public void setoCid(MongoCustomer oCid) {
        this.oCid = oCid;
    }

    public Set<MongoProduct> getoPid() {
        return oPid;
    }

    public void setoPid(Set<MongoProduct> oPid) {
        this.oPid = oPid;
    }
}
