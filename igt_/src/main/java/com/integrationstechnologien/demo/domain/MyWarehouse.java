package com.integrationstechnologien.demo.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class MyWarehouse{

    @Id
    @GeneratedValue
    private String wId;

    private String wDistrict;

    @OneToMany(targetEntity = MyProduct.class)
    private List<MyProduct> wPid = new LinkedList<MyProduct>();

    public MyWarehouse() { }

    public MyWarehouse(String wDistrict) {
        super();
        this.wDistrict = wDistrict;
    }

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) { this.wId = wId; }

    public String getwDistrict() {
        return wDistrict;
    }

    public void setwDistrict(String wDistrict) {
        this.wDistrict = wDistrict;
    }

    public List<MyProduct> getwPid() { return wPid; }

    public void setwPid(List<MyProduct> wPid) {
        this.wPid = wPid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyWarehouse that = (MyWarehouse) o;

        if (wId != null ? !wId.equals(that.wId) : that.wId != null) return false;
        if (wDistrict != null ? !wDistrict.equals(that.wDistrict) : that.wDistrict != null) return false;
        return wPid != null ? wPid.equals(that.wPid) : that.wPid == null;
    }

    @Override
    public int hashCode() {
        int result = wId != null ? wId.hashCode() : 0;
        result = 31 * result + (wDistrict != null ? wDistrict.hashCode() : 0);
        result = 31 * result + (wPid != null ? wPid.hashCode() : 0);
        return result;
    }
}
