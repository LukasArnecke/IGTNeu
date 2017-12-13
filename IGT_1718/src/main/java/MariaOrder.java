package main.java;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "ORDERS")
public class MariaOrder implements Order,java.io.Serializable {


    @Id
    @GeneratedValue
    private int oId;
    private double oTotal;
    private Customer oCid;
    private Set<Product> oPid = new HashSet<Product>();


    public MariaOrder(){

    }

    public MariaOrder(double oTotal){
        super();
        this.oTotal = oTotal;
    }

    @Id
    @Column(name = "O_ID")
    public int getoId() {
        return 0;
    }

    public void setoId(int oId) {

    }

    @Column(name = "O_TOTAL")
    public double getoTotal() {
        return 0;
    }

    public void setoTotal(double oTotal) {

    }

    @JoinColumn(name = "O_CID")
    public Customer getoCid() {
        return null;
    }

    public void setoCid(Customer oCid) {

    }

    @JoinColumn(name = "P_ID")
    public Set<Product> getoPid() {
        return null;
    }

    public void setoPid(Set<Product> oPid) {

    }
}
