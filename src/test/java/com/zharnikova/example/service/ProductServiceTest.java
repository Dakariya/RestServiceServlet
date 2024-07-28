package com.zharnikova.example.service;

import com.zharnikova.example.DataSource;
import com.zharnikova.example.dao.CustomerDao;
import com.zharnikova.example.dao.ProductDao;
import com.zharnikova.example.dto.CustomerDto;
import com.zharnikova.example.dto.CustomerProductDto;
import com.zharnikova.example.dto.ProductDto;
import com.zharnikova.example.mapper.CustomerProductMapper;
import com.zharnikova.example.model.Customer;
import com.zharnikova.example.model.CustomersProducts;
import com.zharnikova.example.model.Product;
import com.zharnikova.example.repository.ProductRepository;
import org.junit.Before;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.doNothing;


import static org.mockito.Mockito.*;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ProductDao.class, ProductRepository.class})
 class ProductServiceTest {

    @Mock
    private ProductDao productDao;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
     void testGetAll() throws SQLException {
        List<Product> products = Collections.singletonList(new Product(1, "product","description",20.0,10));
        when(productDao.getAll()).thenReturn(products);
        assertNull(productDao.getAll());
        List<ProductDto> result = productService.getAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Product", result.get(0).getName());
    }

    @Test
     void testDelete() throws SQLException {
        doNothing().when(productDao).delete(1);

        productService.delete(1);

        verify(productDao, times(1)).delete(1);
    }

    @Test
     void testAdd() throws SQLException {
        Product product = new Product(1, "product","description",20.0,10);
        doNothing().when(productDao).add(product);

        productService.add(product);

        verify(productDao, times(1)).add(product);
    }

    @Test
     void testUpdate() throws SQLException {
        Product product = new Product(1, "product","description",20.0,10);
        doNothing().when(productDao).update(product);

        productService.update(product);

        verify(productDao, times(1)).update(product);
    }

    @Test
     void testGetById() throws SQLException {
        Product product = new Product(1, "product","description",20.0,10);
        when(productDao.getById(1)).thenReturn(Optional.of(product));

        Optional<Product> result = productService.getById(1);

        assertTrue(result.isPresent());
        assertEquals("Test Product", result.get().getName());
    }

//    @Test
//     void testGetCustomerProductNamesAll() throws SQLException {
//        List<CustomersProducts> customersProducts = Collections.singletonList(new CustomersProducts( "Customer", "Product"));
//        when(productRepository.getCustomerProductNames()).thenReturn(customersProducts);
//
//        List<CustomerProductDto> result = productService.getCustomerProductNamesAll();
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Customer", result.get(0).getCustomerName());
//        assertEquals("Product", result.get(0).getProductName());
//    }
}