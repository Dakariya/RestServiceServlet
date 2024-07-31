package com.zharnikova.example.service;

import com.zharnikova.example.dao.ProductDao;

import com.zharnikova.example.dto.CustomerProductDto;
import com.zharnikova.example.dto.ProductDto;
import com.zharnikova.example.model.CustomersProducts;
import com.zharnikova.example.model.Product;
import com.zharnikova.example.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.when;


@ExtendWith(MockitoExtension.class)
 class ProductServiceTest {
    @Mock
    private ProductDao productDao;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
     void testGetAll_Success() throws SQLException {
        // Arrange
        List<Product> products = List.of(new Product(1, "Product1","Description",23.5,20), new Product(2, "Product2","Description2",20.8,10));
        when(productDao.getAll()).thenReturn(products);

        // Act
        List<ProductDto> result = productService.getAll();

        // Assert
        assertEquals(2, result.size());
        verify(productDao, times(1)).getAll();
    }

    @Test
     void testGetAll_Exception() throws SQLException {
        // Arrange
        when(productDao.getAll()).thenThrow(new SQLException("Database error"));

        // Act
        List<ProductDto> result = productService.getAll();

        // Assert
        assertTrue(result.isEmpty());
        verify(productDao, times(1)).getAll();
    }

    @Test
     void testDelete() throws SQLException {
        int productId = 1;

        // No exception should be thrown
        productService.delete(productId);

        // Verify that the delete method was called with the correct parameter
        verify(productDao, times(1)).delete(productId);
    }

    @Test
     void testDeleteThrowsRuntimeException() throws SQLException {
        int productId = 1;
        doThrow(new SQLException()).when(productDao).delete(productId);

        // Assert that a RuntimeException is thrown
        assertThrows(RuntimeException.class, () -> productService.delete(productId));
    }

    @Test
     void testAddProductSuccess() throws SQLException {
        Product product = new Product();
        productService.add(product);
        verify(productDao).add(product);
    }

    @Test
     void testAddProductThrowsException() throws SQLException {
        Product product = new Product();
        doThrow(new SQLException()).when(productDao).add(product);
        assertThrows(RuntimeException.class, () -> productService.add(product));
    }

    @Test
    public void testUpdateProductSuccess() throws SQLException {
        Product product = new Product();
        productService.update(product);
        verify(productDao).update(product);
    }

    @Test
    public void testUpdateProductThrowsException() throws SQLException {
        Product product = new Product();
        doThrow(new SQLException()).when(productDao).update(product);
        assertThrows(RuntimeException.class, () -> productService.update(product));
    }

    @Test
     void testGetById() {
        Product product = new Product(1, "Product1","Description",23.5,20);
        when(productDao.getById(1)).thenReturn(Optional.of(product));

        Optional<Product> result = productService.getById(1);
        assertTrue(result.isPresent());
        assertEquals("Product1", result.get().getName());
    }

    @Test
     void testGetCustomerProductNamesAll() throws SQLException {
        List<CustomersProducts> mockList = List.of(new CustomersProducts( "Customer1", "Product1"));
        when(productRepository.getCustomerProductNames()).thenReturn(mockList);

        List<CustomerProductDto> result = productService.getCustomerProductNamesAll();
        assertFalse(result.isEmpty());
        assertEquals("Customer1", result.get(0).getCustomer_name());
        assertEquals("Product1", result.get(0).getProduct_name());
    }

    @Test
     void testGetCustomerProductNamesAllEmptyList() throws SQLException {
        when(productRepository.getCustomerProductNames()).thenReturn(Collections.emptyList());

        List<CustomerProductDto> result = productService.getCustomerProductNamesAll();
        assertTrue(result.isEmpty());
    }

    @Test
     void testGetCustomerProductNamesAllSQLException() throws SQLException {
        when(productRepository.getCustomerProductNames()).thenThrow(new SQLException("Database error"));

        List<CustomerProductDto> result = productService.getCustomerProductNamesAll();
        assertTrue(result.isEmpty());
    }

}
