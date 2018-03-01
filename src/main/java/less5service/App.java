package less5service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import less5service.models.CustomerModern;
import less5service.models.entities.Product;
import less5service.models.entities.Customer;

public class App {

    public static final String TXT_FILE_NAME = "inputData";
    public static final String JSON_SOURCE_FILE_NAME = "customers.json";
    public static final ClassLoader loader = ClassLoader.getSystemClassLoader();
    public static final String JSON_OUT_FILE_NAME = "out.json";
    public static final String JSON_OUT_FILE_NAME_STORAGE = "/home/user/java_storage/out.json";
    public static final String JSON_IN_FILE_NAME = "in.json";


    public static void main(String[] args) throws IOException {

        List<Customer> customersRead = null;
        List<CustomerModern> customerModernsRead = null;
        List<Customer> customersWrite = new ArrayList<>();
        List<CustomerModern> customerModernsWrite = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        //for writing customer ot json
        /*IntStream.range(1, 10).forEach(i -> {
            Customer tempCustomer = createRandomCustomer();
            if (tempCustomer != null) {
                customersWrite.add(tempCustomer);
            }
            System.out.println("Done!");
        });
        mapper.writeValue(
            new File(JSON_OUT_FILE_NAME_STORAGE),
            customersWrite);
        //for reading customer from json
        customersRead = mapper.readValue(loader.getResource(JSON_SOURCE_FILE_NAME),
            new TypeReference<List<CustomerModern>>() {
            });*/

        //for writing customerModerns to json
        IntStream.range(1, 10)
            .forEach(i -> {
                customerModernsWrite.add(createRandomCustomerModern());
            });

        mapper.writeValue(new File(JSON_OUT_FILE_NAME_STORAGE), customerModernsWrite);
        //for reading customerModerns from json
        customerModernsRead = mapper.readValue(loader.getResource(JSON_OUT_FILE_NAME), new TypeReference<List<CustomerModern>>(){});
        customerModernsRead.forEach(item->{
            System.out.println(item.getId());
            System.out.println(item.getFirstName());
            System.out.println(item.getLastName());
            item.getProducts().forEach(product -> System.out.println(product));
        });







    }


    public static Collection<CustomerModern> readJson(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        List<CustomerModern> customerModerns = null;
        try {
            customerModerns = mapper.readValue(loader.getResource(JSON_IN_FILE_NAME),
                new TypeReference<List<CustomerModern>>() {
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerModerns;
    }

    public static boolean writeJson(Collection<? extends CustomerModern> customers,
        String filePath) {
        boolean isWrote = false;
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper
                .writeValue(new File(loader.getResource(JSON_OUT_FILE_NAME).getFile()), customers);
            isWrote = true;
        } catch (IOException e) {
            e.printStackTrace();
            isWrote = false;
        }

        return isWrote;
    }

    public static boolean writeJson(CustomerModern customerModern, String filePath) {
        boolean isWrote = false;
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filePath), customerModern);
            isWrote = true;
        } catch (IOException e) {
            //
        }
        return isWrote;
    }

    public static CustomerModern createRandomCustomerModern() {
        Random random = new Random();
        int counter = 0;
        List<Product> products = IntStream.range(1, 3)
            .mapToObj(index -> {
                return new Product(index, "some desc for " + index, "name" + index);
            })
            .collect(Collectors.toList());

        return new CustomerModern(random.nextLong(),
            "modern_first_name" + random.nextInt(100),
            "modern_last_name" + random.nextInt(100),
            products);
    }


    public static Customer createRandomCustomer() {
        Random random = new Random();
        return new Customer(random.nextLong(),
            "customer_first_name" + random.nextInt(100),
            "customer_last_name" + random.nextInt(100));
    }
}
