package main.java;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "WAREHOUSE")
public class MariaWarehouse implements Warehouse,java.io.Serializable {

    private int wId;
    private String wDistrict;
    private Set<Product> wPid = new HashSet<Product>();

    public MariaWarehouse(){

    }

    public MariaWarehouse(String wDistrict){
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

    }

    @Basic
    @Column(name = "W_DISTRICT")
    public String getwDistrict() {
        return wDistrict;
    }

    public void setwDistrict(String wDistrict) {

    }

    @OneToMany
    @JoinColumn(name = "P_ID")
    public Set<Product> getwPid() {
        return wPid;
    }

    public void setwPid(Set<Product> wPid) {

    }
}
