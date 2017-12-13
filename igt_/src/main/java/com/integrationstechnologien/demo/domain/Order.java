package com.integrationstechnologien.demo.domain;


import java.util.List;
import java.util.Set;

public interface Order {

    public String getoId();

    public double getoTotal();

    public void setoTotal(double oTotal);

    public Customer getoCid();

    //public List<Product> getoPid();
    public Product getoPid();

    @Override
    public boolean equals(Object o);

    @Override
    public int hashCode();
}
