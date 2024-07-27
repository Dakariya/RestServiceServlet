package com.zharnikova.example.dao;

import com.zharnikova.example.DataSource;
import com.zharnikova.example.model.Customer;
import com.zharnikova.example.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;





import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;



 class ProductDaoTest {

    @Test
    void testGetById() {
       // Arrange: Create an instance of CustomerDao (assuming it's properly initialized)
       ProductDao productDao = new ProductDao();

       // Act: Call the method with a specific customer ID
       int productIdToRetrieve = 12; // Replace with an actual customer ID
       Optional<Product> result = productDao.getById(productIdToRetrieve);

       // Assert: Verify the expected behavior
       assertTrue(result.isPresent(), "Customer should exist");
       Product retrievedProduct = result.get();
       assertEquals(productIdToRetrieve, retrievedProduct.getId(), "IDs should match");
       // Add more assertions based on your specific requirements

       // Optional: Print the retrieved customer details for debugging
       System.out.println("Retrieved customer: " + retrievedProduct.getName() + " - " + retrievedProduct.getDescription());
    }

    @Test
    void testGetAll() {
       // Arrange: Create an instance of CustomerDao (assuming it's properly initialized)
       ProductDao productDao = new ProductDao();

       // Act: Call the method
       List<Product> result;
       try {
          result = productDao.getAll();
       } catch (SQLException e) {
          // Handle any exceptions (e.g., log or fail the test)
          fail("Exception occurred: " + e.getMessage());
          return;
       }

       // Assert: Verify the expected behavior
       assertNotNull(result, "Result should not be null");
       // Add more assertions based on your specific requirements

       // Optional: Print the results for debugging
       result.forEach(product -> System.out.println(product.getName() + " - " + product.getDescription()));
    }
    private ProductDao productDao;
    @BeforeEach
    void setUp() {
       // Initialize your CustomerDao instance (e.g., using an in-memory database)
       productDao = new ProductDao();
    }

    @Test
    void testAddCustomer() {
       // Create a new customer
       Product newProduct = new Product();
       newProduct.setId(4);
       newProduct.setName("Coca cola");
       newProduct.setDescription("original taste");
       newProduct.setPrice(10.0);
       newProduct.setStock(15);

       try {
          // Add the customer to the database
          productDao.add(newProduct);

          // Verify that the customer was added successfully
          Optional<Product> retrievedProduct = productDao.getById(newProduct.getId());
          assertTrue(retrievedProduct.isPresent());
          assertEquals(newProduct.getName(), retrievedProduct.get().getName());
          assertEquals(newProduct.getDescription(), retrievedProduct.get().getDescription());
          assertEquals(newProduct.getPrice(), retrievedProduct.get().getPrice());
          assertEquals(newProduct.getStock(), retrievedProduct.get().getStock());
       } catch (SQLException e){

       }
    }

    @Test
    void testUpdateProduct() throws SQLException {
       Product newProduct = new Product();
       newProduct.setId(10);
       newProduct.setName("watermelon");
       newProduct.setDescription("yellow");
       newProduct.setPrice(56.6);
       newProduct.setStock(10);


       try {
          // Add the customer to the database
          productDao.update(newProduct);

          // Verify that the customer was added successfully
          Optional<Product> retrievedProduct = productDao.getById(newProduct.getId());
          assertTrue(retrievedProduct.isPresent());
          assertEquals(newProduct.getId(), retrievedProduct.get().getId());
          assertEquals(newProduct.getName(), retrievedProduct.get().getName());
          assertEquals(newProduct.getDescription(), retrievedProduct.get().getDescription());
          assertEquals(newProduct.getPrice(), retrievedProduct.get().getPrice());
          assertEquals(newProduct.getStock(), retrievedProduct.get().getStock());
       } catch (SQLException e) {

       }

    }


    @Test
    void testDeleteProduct() throws SQLException {
       Product newProduct = new Product();
       newProduct.setId(13);
       newProduct.setName("Product");
       newProduct.setDescription("description");
       newProduct.setPrice(10.0);
       newProduct.setStock(10);

       try {
          // Add the customer to the database
          productDao.delete(13);

          // Verify that the customer was added successfully
          Optional<Product> retrievedProduct = productDao.getById(newProduct.getId());
          assertEquals(newProduct.getId(), retrievedProduct.get().getId());
          assertEquals(newProduct.getName(), retrievedProduct.get().getName());
          assertEquals(newProduct.getDescription(), retrievedProduct.get().getDescription());
          assertEquals(newProduct.getPrice(), retrievedProduct.get().getPrice());
          assertEquals(newProduct.getStock(), retrievedProduct.get().getStock());
       } catch (SQLException e) {

       }
    }

 }