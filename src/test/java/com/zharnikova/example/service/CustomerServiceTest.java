package com.zharnikova.example.service;


import com.zharnikova.example.dao.CustomerDao;
import com.zharnikova.example.dao.DAO;
import com.zharnikova.example.dto.CustomerDto;
import com.zharnikova.example.mapper.CustomerMapper;
import com.zharnikova.example.model.Customer;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CustomerServiceTest {

    private CustomerDao customerDao;
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        customerDao = mock(CustomerDao.class);
        customerService = new CustomerService();
    }

    @Test
    public void testGetAll() throws SQLException {
        Customer customer = new Customer();
        when(customerDao.getAll()).thenReturn(Collections.singletonList(customer));

        List<CustomerDto> customers = customerService.getAll();
        assertEquals(1, customers.size());
    }

    @Test
    public void testGetById() throws SQLException {
        Customer customer = new Customer();
        when(customerDao.getById(1)).thenReturn(Optional.of(customer));

        Optional<Customer> result = customerService.getById(1);
        assertTrue(result.isPresent());
    }

    @Test
    public void testAdd() throws SQLException {
        Customer customer = new Customer();
        doNothing().when(customerDao).add(customer);

        assertDoesNotThrow(() -> customerService.add(customer));
    }

    @Test
    public void testUpdate() throws SQLException {
        Customer customer = new Customer();
        doNothing().when(customerDao).update(customer);

        assertDoesNotThrow(() -> customerService.update(customer));
    }

    @Test
    public void testDeleteCustomer() throws SQLException {
        doNothing().when(customerDao).delete(1);

        assertDoesNotThrow(() -> customerService.deleteCustomer(1));
    }



    @Test
    void testGetAll1() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Olga");
        customer.setEmail("olga@example.com");
        customer.setPhone("+7984098543");
        customers.add(customer);
        List<Customer> customers1 = customerDao.getAll();
//       when(customers).thenReturn(customers1);
//        verify(customerDao,times(1)).getAll();

    }

    @Test
    void testGetById1() {

        // Arrange
        int customerId = 2;
        Customer mockCustomer = new Customer();
//        when(customerDao.getById(customerId)).thenReturn(Optional.of(mockCustomer));

        // Act
        Optional<Customer> result = customerService.getById(customerId);

        // Assert
        //assertEquals(mockCustomer, result.orElse(null));
        // Add more assertions as needed
    }




    @Test
     void testUpdate1() throws Exception {
        // Подготовка данных
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer(1,"Ivan","Ivanov","and.com");
        Customer customer2 = new Customer(2,"Ivan","Ivanov","and.com");
        Customer customer3 = new Customer(3,"Ivan","Ivanov","and.com");
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        int id = 1;
        String name = "John Doe";
        String phone = "+1234567890";
        String email = "john@doe.com";
        Customer customer = new Customer(id, name, phone, email);
        customerService.update(customer);
        customerService.getById(1);
        // Имитация работы сервиса


    }
}



