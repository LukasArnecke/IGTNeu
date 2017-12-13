package com.integrationstechnologien.demo.domain;

import java.util.Date;

public class CustomerData implements Customer {

    private String cId;

    private String name;

    private String district;

    private Date date;

    public CustomerData() {

    }

    public CustomerData(String name, String district, Date date) {
        this.name = name;
        this.district = district;
        this.date = date;
    }

    public CustomerData(Customer customer) {
        super();
        this.copy(customer);
    }

    public void copy(Customer customer) {
        this.cId = customer.getcId();
        this.name = customer.getName();
        this.date = customer.getDate();
    }

    public String getcId() {
        return cId;
    }

    public void setId(String cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}