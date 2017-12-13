package com.integrationstechnologien.demo.domain;

import com.datastax.driver.core.DataType;
import com.datastax.driver.core.utils.UUIDs;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Table("order")
public class CassandraOrder {

    @PrimaryKey
    private UUID idAsUUID = UUIDs.timeBased();
    private double oTotal;
    private UUID cUUID;
    @Transient
    @CassandraType(type = DataType.Name.TEXT)
    private CassandraCustomer customer;
    @Transient
    @CassandraType(type = DataType.Name.TEXT)
    private CassandraProduct product;
    //private List<CassandraProduct> oPid = new LinkedList<CassandraProduct>();
    public CassandraOrder(){}

    public CassandraOrder(double oTotal) {
        super();
        this.oTotal = oTotal;
    }

    public String getoId() { return this.idAsUUID.toString(); }

    public double getoTotal() { return oTotal; }

    public void setoTotal(double oTotal) { this.oTotal = oTotal; }

    public CassandraProduct getProduct() { return product; }

    public void setProduct(CassandraProduct product) { this.product = product; }

    @JsonIgnore
    public UUID getIdAsUUID() { return idAsUUID; }

    public void setIdAsUUID(UUID idAsUUID) { this.idAsUUID = idAsUUID; }

    @JsonIgnore
    public UUID getcUUID() { return cUUID; }

    public void setcUUID(UUID cUUID) { this.cUUID = cUUID; }

    public CassandraCustomer getCustomer() { return customer; }

    public void setCustomer(Customer customer) {
        this.customer = (CassandraCustomer)customer;
        this.cUUID = this.customer.getIdAsUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CassandraOrder that = (CassandraOrder) o;

        if (Double.compare(that.oTotal, oTotal) != 0) return false;
        if (idAsUUID != null ? !idAsUUID.equals(that.idAsUUID) : that.idAsUUID != null) return false;
        if (cUUID != null ? !cUUID.equals(that.cUUID) : that.cUUID != null) return false;
        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
        return product != null ? product.equals(that.product) : that.product == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idAsUUID != null ? idAsUUID.hashCode() : 0;
        temp = Double.doubleToLongBits(oTotal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (cUUID != null ? cUUID.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
}