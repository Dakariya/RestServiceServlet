package com.zharnikova.example.dao;


import com.zharnikova.example.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerDaoTest {
 @Test
 void testGetById() {
  // Arrange: Create an instance of CustomerDao (assuming it's properly initialized)
  CustomerDao customerDao = new CustomerDao();

  // Act: Call the method with a specific customer ID
  int customerIdToRetrieve = 6; // Replace with an actual customer ID
  Optional<Customer> result = customerDao.getById(customerIdToRetrieve);

  // Assert: Verify the expected behavior
  assertTrue(result.isPresent(), "Customer should exist");
  Customer retrievedCustomer = result.get();
  assertEquals(customerIdToRetrieve, retrievedCustomer.getId(), "IDs should match");
  // Add more assertions based on your specific requirements

  // Optional: Print the retrieved customer details for debugging
  System.out.println("Retrieved customer: " + retrievedCustomer.getName() + " - " + retrievedCustomer.getPhone());
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
  result.forEach(customer -> System.out.println(customer.getName() + " - " + customer.getPhone()));
 }
 private CustomerDao customerDao;
 @BeforeEach
 void setUp() {
  // Initialize your CustomerDao instance (e.g., using an in-memory database)
  customerDao = new CustomerDao();
 }

 @Test
 void testAddCustomer() {
  // Create a new customer
  Customer newCustomer = new Customer();
  newCustomer.setId(3);
  newCustomer.setName("Petr");
  newCustomer.setPhone("+7985697683");
  newCustomer.setEmail("petr@example.com");

  try {
   // Add the customer to the database
   customerDao.add(newCustomer);

   // Verify that the customer was added successfully
   Optional<Customer> retrievedCustomer = customerDao.getById(newCustomer.getId());
   assertTrue(retrievedCustomer.isPresent());
   assertEquals(newCustomer.getName(), retrievedCustomer.get().getName());
   assertEquals(newCustomer.getPhone(), retrievedCustomer.get().getPhone());
   assertEquals(newCustomer.getEmail(), retrievedCustomer.get().getEmail());
  } catch (SQLException e){

  }
 }

 @Test
 void testUpdateCustomer() throws SQLException {
  Customer newCustomer = new Customer();
  newCustomer.setId(8);
  newCustomer.setName("Margo");
  newCustomer.setPhone("+7299953332");
  newCustomer.setEmail("margo@example.com");


  try {
   // Add the customer to the database
   customerDao.update(newCustomer);

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
 void testDeleteCustomer() throws SQLException {
  Customer newCustomer = new Customer();
  newCustomer.setId(2);
  newCustomer.setName("Ivan");
  newCustomer.setEmail("ivan@ivanov.com");
  newCustomer.setPhone("79085347316");

  try {
   // Add the customer to the database
   customerDao.delete(2);

   // Verify that the customer was added successfully
   Optional<Customer> retrievedCustomer = customerDao.getById(newCustomer.getId());
   assertEquals(newCustomer.getId(), retrievedCustomer.get().getId());
   assertEquals(newCustomer.getName(), retrievedCustomer.get().getName());
   assertEquals(newCustomer.getPhone(), retrievedCustomer.get().getPhone());
   assertEquals(newCustomer.getEmail(), retrievedCustomer.get().getEmail());
  } catch (SQLException e) {

  }
 }
 }