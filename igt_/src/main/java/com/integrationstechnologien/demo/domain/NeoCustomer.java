package com.integrationstechnologien.demo.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Relationship;
import java.util.Date;


@NodeEntity
public class NeoCustomer implements Customer {

    @GraphId
    private String cId;

    private String name;
    private String district;
    private Date date;

    public NeoCustomer() { }

    public NeoCustomer(String name, String district, Date date){
        super();
        this.name = name;
        this.district = district;
        this.date = date;
    }

    public NeoCustomer(Customer customer){
        super();
        this.copy(customer);
    }

    public void copy(Customer customer){
        this.name = customer.getName();
        this.district = customer.getDistrict();
        this.date = customer.getDate();
    }

    @Override
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDistrict() {
        return district;
    }

    @Override
    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NeoCustomer that = (NeoCustomer) o;

        if (cId != null ? !cId.equals(that.cId) : that.cId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return district != null ? district.equals(that.district) : that.district == null;
    }

    @Override
    public int hashCode() {
        int result = cId != null ? cId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        return result;
    }
}