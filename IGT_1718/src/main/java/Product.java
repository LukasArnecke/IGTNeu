package main.java;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public interface Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")
    public int getpId();

    public void setpId(int pId);

    @Basic
    @Column(name = "P_PRICE")
    public double getpPreis();

    public void setpPreis(double pPreis);

    @Basic
    @Column(name = "P_NAME")
    public String getpName();

    public void setpName(String pName);

    @Override
    public boolean equals(Object o);

    @Override
    public int hashCode();
}
