package hello;

import java.util.Date;
import java.util.List;

public class Customer {

    private String cId;
    private String name;
    private String district;
    private Date date;
    private List<Product> products;

    public Customer (String cId, String name, String district, Date date, List<Product> products){
        cId = this.cId;
        name = this.name;
        district = this.district;
        date = this.date;
        products = this.products;
    }

    public Customer (String name, String district, Date date){
        name = this.name;
        district = this.district;
        date = this.date;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getcId(){
        return this.cId;
    }

    public void addProduct(Product product){this.products.add(product); }

    public String toString(Customer customer){
        String back;
        back = "cId: " + cId + " Name: " + name + " District: " + district + " Datum: " + date + " Produkte: ";
        for (Product product: products)
        {
            back = back + product.toString() + ", ";
        }
        return back;
    }
}
