package less5service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import less5service.models.CustomerModern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
class DataBaseTest implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcConnection;

    public static Logger logger = LoggerFactory.getLogger(DataBaseTest.class);
    public static final String TABLE_NAME = "customers";
    public static final String INSERT = "INSERT INTO(first_name, last_name) VALUES(?, ?)";
    public static final String CREATE =
        "CREATE TABLE IF NOT EXISTS customers("
            + "id INTEGER PRIMARY KEY AUTO_INCREMENT,"
            + "first_name VARCHAR(255) NOT NULL,"
            + "last_name VARCHAR(255) NOT NULL)";
    public static final String FILE_NAME = "inputData";
    public static List<Object[]> dbRecords;

    enum Fields {
        ID("id"),
        FIRST_NAME("first_name"),
        LAST_NAME("last_name");

        private String fieldName;


        Fields(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getFieldName() {
            return this.fieldName;
        }
    }

    public static final String[] TABLE_FIELDS = new String[]{
        Fields.ID.getFieldName(),
        Fields.FIRST_NAME.getFieldName(),
        Fields.LAST_NAME.getFieldName()
    };


  /*  public static void main(String[] args) {
        SpringApplication.run(DataBaseTest.class, args);
    }*/

    @Override
    public void run(String... strings) throws Exception {
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        try {
            dbRecords = Files.lines(Paths
                .get(loader.getResource(FILE_NAME).getFile()))
                .map(line -> line.replace("\"", ""))
                .map(line -> line.split(";"))
                .collect(Collectors.toList());

            /*dbRecords.forEach(lines -> {
                Stream.of(lines).forEach(System.out::println);
            });*/
        } catch (IOException e) {
            logger.info("Cannot read file...");
        }

        jdbcConnection.execute(CREATE);
        logger.info(CREATE);

        List<Object[]> test3 = Files.lines(Paths
            .get(loader.getResource(FILE_NAME).getFile()))
            .map(line -> line.replace("\"", ""))
            .map(line -> line.split(";"))
            .collect(Collectors.toList());

        test3.forEach(line -> System.out.println(line[0] + " : " + line[1]));
        jdbcConnection
            .batchUpdate("INSERT INTO customers(first_name, last_name) VALUES(?, ?);", test3);
/*
        List<CustomerModern> result = jdbcConnection.query("SELECT * FROM customers",
            new Object[]{},
            (response, rowNumber) -> new CustomerModern(
                response.getLong(Fields.ID.getFieldName()),
                response.getString(Fields.FIRST_NAME.getFieldName()),
                response.getString(Fields.LAST_NAME.getFieldName()))).stream()
            .collect(Collectors.toCollection(ArrayList::new));
        result.forEach(System.out::println);
        System.out.println("hello");
//        jdbcConnection.execute();*/

    }
}

