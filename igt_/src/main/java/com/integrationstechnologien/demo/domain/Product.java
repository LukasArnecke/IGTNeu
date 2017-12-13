package com.integrationstechnologien.demo.domain;

import javax.persistence.*;

public interface Product {

    public String getpId();

    public double getpPreis();

    public void setpPreis(double pPreis);

    public String getpName();

    public void setpName(String pName);

    @Override
    public boolean equals(Object o);

    @Override
    public int hashCode();

}
