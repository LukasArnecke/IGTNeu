package com.integrationstechnologien.demo.domain;

import java.util.*;

public interface Warehouse {

    public String getwId();

    public String getwDistrict();

    public void setwDistrict(String wDistrict);

    public Product getwPid();
    //public List<Product> getwPid();

    @Override
    public boolean equals(Object o);

    @Override
    public int hashCode();
}
