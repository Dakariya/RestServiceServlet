package com.zharnikova.example.service;

import com.zharnikova.example.dao.CustomerDao;
import com.zharnikova.example.dao.ProductDao;
import com.zharnikova.example.dto.CustomerProductDto;
import com.zharnikova.example.mapper.CustomerProductMapper;
import com.zharnikova.example.model.CustomersProducts;
import com.zharnikova.example.repository.ProductRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;

class ProductServiceTest {
    private final ProductDao productDao = new ProductDao();
    private final ProductService productService = new ProductService();


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

    private ProductService customerProductService;
    private ProductRepository productRepository;
    private CustomerProductMapper customerProductMapper;

    @Test
     void testGetCustomerProductNamesAll() throws Exception {
        // Подготовка данных
        List<CustomersProducts> customersProducts = new ArrayList<>();
        customersProducts.add(new CustomersProducts());

        // Имитация работы репозитория
        when(productRepository.getCustomerProductNames()).thenReturn(customersProducts);

        // Имитация работы картографа
        //when(customerProductMapper.mapToCustomerProductDto(any())).thenReturn(new CustomerProductDto());

        // Вызов тестируемого метода
       // List<CustomerProductDto> customerProductDtos = customerProductService.getCustomerProductNamesAll();

        // Проверка поведения
        //assertEquals("Ожидаемое значение", actualValue, expectedValue);
    }
}