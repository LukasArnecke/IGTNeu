package main.java;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public interface Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "O_ID")
    public int getoId();

    public void setoId(int oId);

    @Basic
    @Column(name = "O_TOTAL")
    public double getoTotal();

    public void setoTotal(double oTotal);

    @ManyToOne
    @JoinColumn(name = "O_CID")
    public Customer getoCid();

    public void setoCid(Customer oCid);

    @OneToMany
    @JoinColumn(name = "P_ID")
    public Set<Product> getoPid();

    public void setoPid(Set<Product> oPid);

    @Override
    public boolean equals(Object o);

    @Override
    public int hashCode();

    @Override
    public String toString();

}
