package com.zharnikova.example.service;

import com.zharnikova.example.dao.CustomerDao;
import com.zharnikova.example.dto.CustomerDto;
import com.zharnikova.example.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerDao customerDao;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testGetAll() throws SQLException {
        Customer customer1 = new Customer(1, "John Doe","+789885579","john@example.com");
        Customer customer2 = new Customer(2, "Jane Doe", "+789885580","jane@example.com");
        when(customerDao.getAll()).thenReturn(Arrays.asList(customer1, customer2));

        List<CustomerDto> result = customerService.getAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("Jane Doe", result.get(1).getName());
    }

    @Test
     void testGetAllSQLException() throws SQLException {
        when(customerDao.getAll()).thenThrow(new SQLException());

        List<CustomerDto> result = customerService.getAll();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
     void testGetById() throws SQLException {
        Customer customer = new Customer(1, "John Doe","+789885579","john@example.com");
        when(customerDao.getById(1)).thenReturn(Optional.of(customer));

        Optional<Customer> result = customerService.getById(1);

        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getName());
        assertEquals("+789885579", result.get().getPhone());
        assertEquals("john@example.com", result.get().getEmail());
    }

    @Test
     void testAdd() throws SQLException {
        Customer customer = new Customer(1, "John Doe","+789885579","john@example.com");
        doNothing().when(customerDao).add(customer);

        assertDoesNotThrow(() -> customerService.add(customer));
    }

    @Test
     void testUpdate() throws SQLException {
        Customer customer = new Customer(1, "John Doe","+789885579","john@example.com");
        doNothing().when(customerDao).update(customer);

        assertDoesNotThrow(() -> customerService.update(customer));
    }
//
//    @Test
//    public void testDeleteCustomer() throws SQLException {
//        doNothing().when(customerDao).delete(1);
//
//        assertDoesNotThrow(() -> customerService.deleteCustomer(1));
//    }
//}
//    @Mock
//    List mockList;
//
//    @Test
//    void whenMockAnnotation() {
//        //создаем правило: вернуть 10 при вызове метода size
//        Mockito.when(mockList.size() ).thenReturn(10);
//
//        //тут вызывается метод и вернет 10!!
//        assertEquals(10, mockList.size());
//    }
}