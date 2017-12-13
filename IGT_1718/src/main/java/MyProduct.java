package main.java;
import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class MyProduct implements Product,java.io.Serializable {

    private double pPreis;
    private String pName;
    private int pId;

    public MyProduct() { }

    public MyProduct(double pPreis, String pName) {
        super();
        this.pPreis = pPreis;
        this.pName = pName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")
    public int getpId() { return pId; }

    public void setpId(int pId) { this.pId = pId; }

    @Basic
    @Column(name = "P_PRICE")
    public double getpPreis() { return pPreis; }

    public void setpPreis(double pPreis) { this.pPreis = pPreis; }

    @Basic
    @Column(name = "P_NAME")
    public String getpName() { return pName; }

    public void setpName(String pName) { this.pName = pName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.getpPreis(), pPreis) != 0) return false;
        if (pId != product.getpId()) return false;
        return pName != null ? pName.equals(product.getpName()) : product.getpName() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(pPreis);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (pName != null ? pName.hashCode() : 0);
        result = 31 * result + pId;
        return result;
    }
}
