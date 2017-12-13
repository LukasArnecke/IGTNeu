package com.integrationstechnologien.demo.domain;


import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class MongoWarehouse {

    @Id
    private int wId;
    private String wDistrict;
    @DBRef
    private Set<Product> wPid = new HashSet<Product>();

    public MongoWarehouse(){

    }

    public MongoWarehouse(String wDistrict){
        super();
        this.wDistrict = wDistrict;
    }

    public int getwId() {
        return wId;
    }

    public void setwId(int wId) {

    }

    public String getwDistrict() {
        return wDistrict;
    }

    public void setwDistrict(String wDistrict) {

    }

    public Set<Product> getwPid() {
        return wPid;
    }

    public void setwPid(Set<Product> wPid) {

    }
}
