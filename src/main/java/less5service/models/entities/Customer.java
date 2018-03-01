package less5service.models.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;


    public Customer() {
        //for jackson
    }

    @JsonCreator
    public Customer(@JsonProperty("id") Long id, @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

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
