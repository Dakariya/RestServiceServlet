package com.zharnikova.example.service;


import com.zharnikova.example.dao.CustomerDao;
import com.zharnikova.example.dto.CustomerDto;
import com.zharnikova.example.mapper.CustomerMapper;
import com.zharnikova.example.model.Customer;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CustomerServiceTest {

    private final CustomerDao customerDao = new CustomerDao();
    private final CustomerService customerService = new CustomerService();


//    @Test
//    void testGetAll() throws SQLException {
//        List<Customer> customers = new ArrayList<>();
//        Customer customer = new Customer();
//        customer.setId(1);
//        customer.setName("Olga");
//        customer.setEmail("olga@example.com");
//        customer.setPhone("+7984098543");
//        customers.add(customer);
//        customers = customerDao.getAll();
//        when(customers).thenReturn(customers);
//        verify(customerDao,times(1)).getAll();
//
//    }

//    @Test
//    void testGetById() {
//
//        // Arrange
//        int customerId = 2;
//        Customer mockCustomer = new Customer();
//        when(customerDao.getById(customerId)).thenReturn(Optional.of(mockCustomer));
//
//        // Act
//        Optional<Customer> result = customerService.getById(customerId);
//
//        // Assert
//        assertEquals(mockCustomer, result.orElse(null));
//        // Add more assertions as needed
//    }

    // Add similar test methods for other service methods (add, update, delete)

    // Remember to handle exceptions appropriately in your service methods!
}

//    @Test
//    void testGetAll() {
//
//    }
//}


