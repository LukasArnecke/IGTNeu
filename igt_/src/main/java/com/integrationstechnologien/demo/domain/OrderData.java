package com.integrationstechnologien.demo.domain;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class OrderData implements Order {
    private String oId;
    private double oTotal;
    private CustomerData oCid;
    private ProductData product;

    public OrderData() {
    }

    public OrderData(double oTotal, Customer customer, Product product){
        super();
        this.oTotal = oTotal;
        this.product = new ProductData(product);
        this.oCid = new CustomerData(customer);
    }
    @Override
    public String getoId() {return this.oId; }

    @Override
    public double getoTotal() {return this.oTotal; }

    @Override
    public void setoTotal(double oTotal) { this.oTotal = oTotal; }

    @Override
    public Customer getoCid() { return this.oCid; }

    public void setCustomer(CustomerData customer){ this.oCid = customer;}

    public void setProduct(ProductData product){ this.product=product;}
    @Override
    public Product getoPid() { return null; }
}
