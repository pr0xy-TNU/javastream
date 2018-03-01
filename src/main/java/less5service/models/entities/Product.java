package less5service.models.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    @JsonProperty("id")
    private int id;
    @JsonProperty("description")
    private String desc;
    @JsonProperty("product")
    private String productName;

    public Product() {
        //for jackson
    }

    @JsonCreator
    public Product(@JsonProperty("id") int id, @JsonProperty("description") String desc,
        @JsonProperty("product") String prodName) {
        this.id = id;
        this.desc = desc;
        this.productName = prodName;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public String getProductName() {
        return productName;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + id +
            ", desc='" + desc + '\'' +
            ", productName='" + productName + '\'' +
            '}';
    }
}
