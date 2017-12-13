package com.integrationstechnologien.demo.domain;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.utils.UUIDs;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import java.util.Date;
import java.util.UUID;

@Table(value = "customer")
public class CassandraCustomer implements Customer{

    @PrimaryKey
    private UUID idAsUUID = UUIDs.timeBased();;
    private String name;
    private String district;
    private LocalDate date;

    protected CassandraCustomer(){}

    public CassandraCustomer(String name, String district, Date date) {
        super();
        this.name = name;
        this.district = district;
        this.date = LocalDate.fromMillisSinceEpoch(date.getTime());
    }

    public CassandraCustomer(Customer customerData) {
        super();
        this.copy(customerData);
    }

    public void copy(Customer customer) {
        this.name = customer.getName();
        this.district = customer.getDistrict();
        this.date = LocalDate.fromMillisSinceEpoch(customer.getDate().getTime());
    }

    @JsonIgnore
    public UUID getIdAsUUID() {
        return idAsUUID;
    }

    @Override
    public String getcId() { return idAsUUID.toString();}

    public void setcId(UUID cId) {
        this.idAsUUID = cId;
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
        return new Date(date.getMillisSinceEpoch());
    }

    public void setDate(Date date) {
        this.date = LocalDate.fromMillisSinceEpoch(date.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CassandraCustomer that = (CassandraCustomer) o;

        if (idAsUUID != null ? !idAsUUID.equals(that.idAsUUID) : that.idAsUUID != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return district != null ? district.equals(that.district) : that.district == null;
    }

    @Override
    public int hashCode() {
        int result = idAsUUID != null ? idAsUUID.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        return result;
    }
}

