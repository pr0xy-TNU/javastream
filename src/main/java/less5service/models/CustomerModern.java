package less5service.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import less5service.models.entities.Product;

public class CustomerModern implements Serializable {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("products")
    private List<Product> products;

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public CustomerModern() {
        //for jackson
    }


    @JsonCreator
    public CustomerModern(@JsonProperty("id") Long id, @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        @JsonProperty("products") List<Product> products) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.products = products;
    }


    public List<Product> getProducts() {

        return products;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {

        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String
            .format("\nCustomerModern[id: %d ,firstName: %s, lastName: %s]\n", this.id, this.firstName,
                this.lastName);
    }
}
