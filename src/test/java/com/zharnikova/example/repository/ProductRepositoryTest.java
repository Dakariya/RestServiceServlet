package com.zharnikova.example.repository;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import com.zharnikova.example.model.CustomersProducts;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.ext.ScriptUtils;
import org.testcontainers.jdbc.JdbcDatabaseDelegate;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@Tag("DockerRequired")
class ProductRepositoryTest {

    private static final String INIT_SQL = "sql/schema.sql";
    public static ProductRepository productRepository;
    private static int containerPort = 5432;
    private static int localPort = 5432;

    @Container
    public static MySQLContainer<?> container = new MySQLContainer<>("servlet")
            .withDatabaseName("mydb")
            .withUsername("root")
            .withPassword("E65@pop3!")
            .withExposedPorts(containerPort)
            .withCreateContainerCmdModifier(cmd -> cmd.withHostConfig(
                    new HostConfig().withPortBindings(new PortBinding(Ports.Binding.bindPort(localPort), new ExposedPort(containerPort)))
            ))
            .withInitScript(INIT_SQL);

    private static JdbcDatabaseDelegate jdbcDatabaseDelegate;

    @BeforeAll
    static void beforeAll() {
        container.start();
        productRepository = new ProductRepository();
        jdbcDatabaseDelegate = new JdbcDatabaseDelegate(container, "");
    }

    @AfterAll
    static void afterAll() {
        container.stop();
    }

    @BeforeEach
    void setUp() {
        ScriptUtils.runInitScript(jdbcDatabaseDelegate, INIT_SQL);
    }

    @Test
    void testGetCustomerProductNames() {
        // Arrange: Create an instance of ProductRepository (assuming it's properly initialized)
        ProductRepository productRepository = new ProductRepository();

        // Act: Call the method
        List<CustomersProducts> result;
        try {
            result = productRepository.getCustomerProductNames();
        } catch (SQLException e) {
            // Handle any exceptions (e.g., log or fail the test)
            fail("Exception occurred: " + e.getMessage());
            return;
        }

        // Assert: Verify the expected behavior
        assertNotNull(result, "Result should not be null");
        // Add more assertions based on your specific requirements

        // Optional: Print the results for debugging
        result.forEach(cp -> System.out.println(cp.getCustomer_name() + " - " + cp.getProduct_name()));
    }

    @Test
    void testGetCustomerProductNames1()  {
        List<CustomersProducts> excpect = new ArrayList<>();
        CustomersProducts customersProducts1 = new CustomersProducts("Ivan","sweets");
        CustomersProducts customersProducts2 = new CustomersProducts("Ivan","sweets");
        CustomersProducts customersProducts3 = new CustomersProducts("Svetlana","sweets");
        CustomersProducts customersProducts4 = new CustomersProducts("Ivan","watermelon");
        excpect.add(customersProducts1);
        excpect.add(customersProducts2);
        excpect.add(customersProducts3);
        excpect.add(customersProducts4);

        List<CustomersProducts> result  = null;
        try {
            result = productRepository.getCustomerProductNames();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(excpect, result);
    }
    }