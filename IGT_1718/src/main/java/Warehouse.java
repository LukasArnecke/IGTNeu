package main.java;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "WAREHOUSE")
public interface Warehouse {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "W_ID")
    public int getwId();

    public void setwId(int wId);

    @Basic
    @Column(name = "W_DISTRICT")
    public String getwDistrict();

    public void setwDistrict(String wDistrict);

    @OneToMany
    @JoinColumn(name = "P_ID")
    public Set<Product> getwPid();

    public void setwPid(Set<Product> wPid);

    @Override
    public boolean equals(Object o);

    @Override
    public int hashCode();
}
