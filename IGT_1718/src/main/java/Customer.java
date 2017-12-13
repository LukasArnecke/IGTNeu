package main.java;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public interface Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_ID")
    public int getcId();

    public void setcId(int cId);

    @Basic
    @Column(name = "C_UNAME")
    public String getcUname();

    public void setcUname(String cUname);

    @Basic
    @Column(name = "C_ADDRESS")
    public String getcAddr();

    public void setcAddr(String cAddr);

    @Basic
    @Column(name = "C_DISTRICT")
    public String getcDistrict();

    public void setcDistrict(String cDistrict);

    @Override
    public boolean equals(Object o);

    @Override
    public int hashCode();
}
