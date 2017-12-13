package com.integrationstechnologien.demo.domain;

import java.util.Date;

public interface Customer {

    public String getcId();

    public String getName();

    public void setName(String cUname);

    public String getDistrict();

    public void setDistrict(String cDistrict);

    public Date getDate();

    public void setDate(Date date);

    @Override
    public boolean equals(Object o);

    @Override
    public int hashCode();

}
