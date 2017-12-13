package com.integrationstechnologien.demo.domain;
import com.integrationstechnologien.demo.domain.Customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;
import javax.persistence.Table;
import java.util.Date;


public class MongoCustomer {

    @Id
    private String cId;
    private String name;
    private String district;
    private Date date;

    public MongoCustomer() {
    }

    public MongoCustomer(String name, String district, Date date) {
        this.name = name;
        this.district = district;
        this.date = date;
    }

    public String getcId() { return cId; }

    public void setcId(String cId) { this.cId = cId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDistrict() { return district; }

    public void setDistrict(String district) { this.district = district; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MongoCustomer that = (MongoCustomer) o;

        if (cId != null ? !cId.equals(that.cId) : that.cId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return district != null ? district.equals(that.district) : that.district == null;
    }

    @Override
    public int hashCode() {
        int result = cId != null ? cId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        return result;
    }
}
