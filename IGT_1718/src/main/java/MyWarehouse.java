package main.java;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "WAREHOUSE")
public class MyWarehouse implements Warehouse,java.io.Serializable {

    private int wId;
    private String wDistrict;
    private Set<Product> wPid = new HashSet<Product>();

    public MyWarehouse() { }

    public MyWarehouse(String wDistrict) {
        super();
        this.wDistrict = wDistrict;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "W_ID")
    public int getwId() {
        return wId;
    }

    public void setwId(int wId) {
        this.wId = wId;
    }

    @Basic
    @Column(name = "W_DISTRICT")
    public String getwDistrict() {
        return wDistrict;
    }

    public void setwDistrict(String wDistrict) {
        this.wDistrict = wDistrict;
    }

    @OneToMany
    @JoinColumn(name = "P_ID")
    public Set<Product> getwPid() {
        return wPid;
    }

    public void setwPid(Set<Product> wPid) {
        this.wPid = wPid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Warehouse warehouse = (Warehouse) o;

        if (wId != warehouse.getwId()) return false;
        if (wDistrict != null ? !wDistrict.equals(warehouse.getwDistrict()) : warehouse.getwDistrict() != null) return false;
        return wPid != null ? wPid.equals(warehouse.getwPid()) : warehouse.getwPid() == null;
    }

    @Override
    public int hashCode() {
        int result = wId;
        result = 31 * result + (wDistrict != null ? wDistrict.hashCode() : 0);
        result = 31 * result + (wPid != null ? wPid.hashCode() : 0);
        return result;
    }
}
