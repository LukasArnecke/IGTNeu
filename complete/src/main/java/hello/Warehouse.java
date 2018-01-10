package hello;

import java.util.Date;
import java.util.List;

public class Warehouse {
    private String wId;
    private String wDistrict;
    private List<Product> products;

    public Warehouse (String wId, String wDistrict, List<Product> products){
        wId = this.wId;
        wDistrict = this.wDistrict;
        products = this.products;
    }

    public Warehouse (String wDistrict){
        wDistrict = this.wDistrict;
    }

    public void setDistrict(String district) {
        this.wDistrict = district;
    }

    public void addProduct(Product product){this.products.add(product); }

    public String toString(Warehouse warehouse){
        String back;
        back = "wId: " + wId + " District: " + wDistrict + " Produkte: ";
        for (Product product: products)
            {
                back = back + product.toString() + ", ";
            }
        return back;
    }
}
