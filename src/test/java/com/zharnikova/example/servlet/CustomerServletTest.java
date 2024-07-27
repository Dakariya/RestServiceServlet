package com.zharnikova.example.servlet;

import com.mysql.cj.util.StringUtils;
import com.zharnikova.example.dao.CustomerDao;
import com.zharnikova.example.dao.DAO;
import com.zharnikova.example.dto.CustomerDto;
import com.zharnikova.example.mapper.CustomerMapper;
import com.zharnikova.example.model.Customer;
import com.zharnikova.example.service.CustomerService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServletTest {

    @Test
    void testGetById() {
        // Arrange: Create an instance of CustomerDao (assuming it's properly initialized)
        CustomerService customerService = new CustomerService();

        // Act: Call the method with a specific customer ID
        int customerIdToRetrieve = 2; // Replace with an actual customer ID
        Optional<Customer> result = customerService.getById(customerIdToRetrieve);

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
        CustomerService customerService = new CustomerService();

        // Act: Call the method
        List<CustomerDto> result;
        result = customerService.getAll();

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

    private CustomerService customerService;
    private CustomerMapper customerMapper;


    @Test
     void testGetById1() {

    }



    @Test
     void testUpdate() throws Exception {
        // Подготовка данных
        customerService = new CustomerService();
        int id = 1;
        String name = "John Doe";
        String phone = "+1234567890";
        String email = "john@doe.com";
        Customer customer = new Customer(id, name, phone, email);

        CustomerDto customerMapper1 = CustomerMapper.mapToCustomerDto(customer);
        customerService.update(customer);
        assertEquals(customerService.getById(1),Optional.empty());
        // Имитация работы сервиса
        //when(customerService.update(customer)).thenReturn(true);

        // Вызов тестируемого метода
        //boolean result = customerService.update(customer);

        // Проверка поведения
        //assertTrue("Ожидаемое значение", result);
    }

}