package com.zharnikova.example.dao;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import com.zharnikova.example.model.Customer;

import com.zharnikova.example.model.CustomersProducts;
import com.zharnikova.example.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.ext.ScriptUtils;
import org.testcontainers.jdbc.JdbcDatabaseDelegate;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;


@Testcontainers
@Tag("DockerRequired")
 class CustomerDaoTest {

    private static final String INIT_SQL = "sql/schema.sql";
    public static CustomerDao customerDao;
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
        customerDao = new CustomerDao();
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
     void testGetById() {
         // Arrange: Create an instance of CustomerDao (assuming it's properly initialized)
         CustomerDao customerDao = new CustomerDao();

         // Act: Call the method with a specific customer ID
         int customerIdToRetrieve = 2; // Replace with an actual customer ID
         Optional<Customer> result = customerDao.getById(customerIdToRetrieve);

         // Assert: Verify the expected behavior
         assertTrue(result.isPresent(), "Customer should exist");
         Customer retrievedCustomer = result.get();
         assertEquals(customerIdToRetrieve, retrievedCustomer.getId(), "IDs should match");
         // Add more assertions based on your specific requirements

         // Optional: Print the retrieved customer details for debugging
         System.out.println("Retrieved customer: " + retrievedCustomer.getName() + " - " + retrievedCustomer.getEmail());
     }


     @Test
     void testGetAll() {
         // Arrange: Create an instance of CustomerDao (assuming it's properly initialized)
         CustomerDao customerDao = new CustomerDao();

         // Act: Call the method
         List<Customer> result;
         try {
             result = customerDao.getAll();
         } catch (SQLException e) {
             // Handle any exceptions (e.g., log or fail the test)
             fail("Exception occurred: " + e.getMessage());
             return;
         }

         // Assert: Verify the expected behavior
         assertNotNull(result, "Result should not be null");
         // Add more assertions based on your specific requirements

         // Optional: Print the results for debugging
         result.forEach(customer -> System.out.println(customer.getName() + " - " + customer.getEmail()));
     }

     @Test
     void testAddCustomer() {
         // Create a new customer
         Customer newCustomer = new Customer();
         newCustomer.setName("John Doe");
         newCustomer.setPhone("123-456-7890");
         newCustomer.setEmail("john.doe@example.com");

         CustomerDao customerDao = new CustomerDao();
         try {
             // Add the customer to the database
             customerDao.add(newCustomer);

             // Verify that the customer was added successfully
             Optional<Customer> retrievedCustomer = customerDao.getById(newCustomer.getId());
             assertTrue(retrievedCustomer.isPresent());
             assertEquals(newCustomer.getName(), retrievedCustomer.get().getName());
             assertEquals(newCustomer.getPhone(), retrievedCustomer.get().getPhone());
             assertEquals(newCustomer.getEmail(), retrievedCustomer.get().getEmail());
         } catch (SQLException e) {

         }
     }

     @Test
     void testUpdateCustomer() throws SQLException {
         Customer newCustomer = new Customer();
         newCustomer.setId(2);
         newCustomer.setName("John Doe");
         newCustomer.setPhone("123-456-7890");
         newCustomer.setEmail("john.doe@example.com");

         CustomerDao customerDao = new CustomerDao();
         try {
             // Add the customer to the database
             customerDao.update(newCustomer);

             // Verify that the customer was added successfully
             Optional<Customer> retrievedCustomer = customerDao.getById(newCustomer.getId());
             assertTrue(retrievedCustomer.isPresent());
             assertEquals(newCustomer.getId(), retrievedCustomer.get().getId());
             assertEquals(newCustomer.getName(), retrievedCustomer.get().getName());
             assertEquals(newCustomer.getPhone(), retrievedCustomer.get().getPhone());
             assertEquals(newCustomer.getEmail(), retrievedCustomer.get().getEmail());
         } catch (SQLException e) {

         }

     }


     @Test
     void testDeleteCustomer() throws SQLException {
         Customer newCustomer = new Customer();
         newCustomer.setId(2);
         newCustomer.setName("John Doe");
         newCustomer.setPhone("123-456-7890");
         newCustomer.setEmail("john.doe@example.com");

         CustomerDao customerDao = new CustomerDao();
         try {
             // Add the customer to the database
             customerDao.delete(2);

             // Verify that the customer was added successfully
             Optional<Customer> retrievedCustomer = customerDao.getById(newCustomer.getId());
             assertTrue(retrievedCustomer.isPresent());
             assertEquals(newCustomer.getId(), retrievedCustomer.get().getId());
             assertEquals(newCustomer.getName(), retrievedCustomer.get().getName());
             assertEquals(newCustomer.getPhone(), retrievedCustomer.get().getPhone());
             assertEquals(newCustomer.getEmail(), retrievedCustomer.get().getEmail());
         } catch (SQLException e) {

         }
     }

    @Test
    void testGetAll1() throws SQLException {
        int expectedSize = 7;
        int resultSize = customerDao.getAll().size();

        Assertions.assertEquals(expectedSize, resultSize);
    }
 }