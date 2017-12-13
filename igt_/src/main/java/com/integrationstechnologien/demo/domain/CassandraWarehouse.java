package com.integrationstechnologien.demo.domain;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.mapping.PrimaryKey;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class CassandraWarehouse {
    @PrimaryKey
    private UUID idAsUUID = UUIDs.timeBased();
    private String wDistrict;
    private List<MyProduct> wPid = new LinkedList<MyProduct>();

    public CassandraWarehouse() {
    }

    public CassandraWarehouse(String wDistrict) {
        super();
        this.wDistrict = wDistrict;
    }
    @Transient
    public UUID getIdAsUUID() { return idAsUUID; }

    public String getwId() {
        return this.idAsUUID.toString();
    }

    public String getwDistrict() {
        return wDistrict;
    }

    public void setwDistrict(String wDistrict) {
        this.wDistrict = wDistrict;
    }

    public List<MyProduct> getwPid() {
        return wPid;
    }

    public void setwPid(List<MyProduct> wPid) {
        this.wPid = wPid;
    }

}
