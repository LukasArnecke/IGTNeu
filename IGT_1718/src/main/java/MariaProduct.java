package main.java;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class MariaProduct implements Product,java.io.Serializable {

    private double pPreis;
    private String pName;
    private int pId;


    public MariaProduct(){

    }

    public MariaProduct(String pName, double pPreis){
        super();
        this.pPreis = pPreis;
        this.pName = pName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {

    }

    @Basic
    @Column(name = "P_PRICE")
    public double getpPreis() {
        return pPreis;
    }

    public void setpPreis(double pPreis) {

    }

    @Basic
    @Column(name = "P_NAME")
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {

    }
}
