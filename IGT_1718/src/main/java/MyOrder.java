package main.java;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class MyOrder implements Order,java.io.Serializable {

    private int oId;
    private double oTotal;
    private Customer oCid;
    private Set<Product> oPid = new HashSet<Product>();
    //private Set<Product> order_list = new HashSet<Product>();
    public MyOrder(){}

    public MyOrder(double oTotal) {
        super();
        this.oTotal = oTotal;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "O_ID")
    public int getoId() { return oId; }

    public void setoId(int oId) { this.oId = oId; }

    @Basic
    @Column(name = "O_TOTAL")
    public double getoTotal() { return oTotal; }

    public void setoTotal(double oTotal) { this.oTotal = oTotal; }

    @ManyToOne
    @JoinColumn(name = "O_CID")
    public Customer getoCid() { return oCid; }

    public void setoCid(Customer oCid) {
        this.oCid = oCid;
    }

    @OneToMany
    @JoinColumn(name = "P_ID")
    public Set<Product> getoPid() {
        return oPid;
    }

    public void setoPid(Set<Product> oPid) {
        this.oPid = oPid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (oId != order.getoId()) return false;
        if (Double.compare(order.getoTotal(), oTotal) != 0) return false;
        if (oCid != null ? !oCid.equals(order.getoCid()) : order.getoCid() != null) return false;
        return oPid != null ? oPid.equals(order.getoPid()) : order.getoPid() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = oId;
        temp = Double.doubleToLongBits(oTotal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (oCid != null ? oCid.hashCode() : 0);
        result = 31 * result + (oPid != null ? oPid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() { return "Order{" + "oId=" + oId + '}'; }

}
