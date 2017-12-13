package main.java;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class MariaCustomer implements Customer, java.io.Serializable {


    @Id
    @GeneratedValue
    private int cId;
    private String cUname;
    private String cAddr;
    private String cDistrict;

    public MariaCustomer(){

    }

    public MariaCustomer(String cUname, String cAddr, String cDistrict){
        super();
        this.cUname = cUname;
        this.cAddr = cAddr;
        this.cDistrict = cDistrict;
    }


    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {

    }

    public String getcUname() {
        return cUname;
    }

    public void setcUname(String cUname) {

    }

    public String getcAddr() {
        return cAddr;
    }

    public void setcAddr(String cAddr) {

    }

    public String getcDistrict() {
        return cDistrict;
    }

    public void setcDistrict(String cDistrict) {

    }
}
