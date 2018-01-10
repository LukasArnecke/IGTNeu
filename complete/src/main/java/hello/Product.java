package hello;

import java.util.Date;

public class Product {
    private String pId;
    private String name;
    private double preis;

    public Product (String pId, String name, double preis){
        pId = this.pId;
        name = this.name;
        preis = this.preis;
    }

    public Product (String name, double preis){
        name = this.name;
        preis = this.preis;
    }

    /*public void setDistrict(String district) {
        this.district = district;
    }*/

    public String toString(Product product){
        String back;
        back = "pId: " + pId + " Name: " + name + " Preis: " + preis;
        return back;
    }
}
