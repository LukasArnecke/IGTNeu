package com.integrationstechnologien.demo.domain;

import com.datastax.driver.core.utils.UUIDs;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Table("Product")
public class CassandraProduct {

    private double pPreis;
    private String pName;
    @PrimaryKey
    private UUID idAsUUID = UUIDs.timeBased();

    public CassandraProduct() { }

    public CassandraProduct(double pPreis, String pName) {
        super();
        this.pPreis = pPreis;
        this.pName = pName;
    }

   @JsonIgnore
    public UUID getIdAsUUID() { return idAsUUID; }

    public String getpId(){ return this.idAsUUID.toString(); }

    public double getpPreis() { return pPreis; }

    public void setpPreis(double pPreis) { this.pPreis = pPreis; }

    public String getpName() { return pName; }

    public void setpName(String pName) { this.pName = pName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CassandraProduct that = (CassandraProduct) o;

        if (Double.compare(that.pPreis, pPreis) != 0) return false;
        if (pName != null ? !pName.equals(that.pName) : that.pName != null) return false;
        return idAsUUID != null ? idAsUUID.equals(that.idAsUUID) : that.idAsUUID == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(pPreis);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (pName != null ? pName.hashCode() : 0);
        result = 31 * result + (idAsUUID != null ? idAsUUID.hashCode() : 0);
        return result;
    }
}

