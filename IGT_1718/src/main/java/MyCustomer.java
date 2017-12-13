package main.java;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class MyCustomer implements Customer, java.io.Serializable {

    private int cId;
    private String cUname;
    private String cAddr;
    private String cDistrict;

    public MyCustomer(){}

    public MyCustomer(String cUname, String cAddr, String cDistrict) {
        super();
        this.cUname = cUname;
        this.cAddr = cAddr;
        this.cDistrict = cDistrict;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_ID")
    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    @Basic
    @Column(name = "C_UNAME")
    public String getcUname() {
        return cUname;
    }

    public void setcUname(String cUname) {
        this.cUname = cUname;
    }

    @Basic
    @Column(name = "C_ADDRESS")
    public String getcAddr() { return cAddr; }

    public void setcAddr(String cAddr) { this.cAddr = cAddr; }

    @Basic
    @Column(name = "C_DISTRICT")
    public String getcDistrict() { return cDistrict; }

    public void setcDistrict(String cDistrict) { this.cDistrict = cDistrict; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (cId != customer.getcId()) return false;
        if (cUname != null ? !cUname.equals(customer.getcUname()) : customer.getcUname() != null) return false;
        if (cAddr != null ? !cAddr.equals(customer.getcAddr()) : customer.getcAddr() != null) return false;
        return cDistrict != null ? cDistrict.equals(customer.getcDistrict()) : customer.getcDistrict() == null;
    }

    @Override
    public int hashCode() {
        int result = cId;
        result = 31 * result + (cUname != null ? cUname.hashCode() : 0);
        result = 31 * result + (cAddr != null ? cAddr.hashCode() : 0);
        result = 31 * result + (cDistrict != null ? cDistrict.hashCode() : 0);
        return result;
    }
}
