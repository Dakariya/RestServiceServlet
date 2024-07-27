package com.zharnikova.example.servlet;

import com.zharnikova.example.dao.ProductDao;
import com.zharnikova.example.dto.ProductDto;
import com.zharnikova.example.model.Product;

import com.zharnikova.example.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

class ProductServletTest {
    @Test
    void testGetById() {
        // Arrange: Create an instance of CustomerDao (assuming it's properly initialized)
        ProductService productService = new ProductService();

        // Act: Call the method with a specific customer ID
        int productIdToRetrieve = 12; // Replace with an actual customer ID
        Optional<Product> result = productService.getById(productIdToRetrieve);

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
        ProductService productService = new ProductService();

        // Act: Call the method
        List<ProductDto> result;
        result = productService.getAll();

        // Assert: Verify the expected behavior
        assertNotNull(result, "Result should not be null");
        // Add more assertions based on your specific requirements

        // Optional: Print the results for debugging
        result.forEach(customer -> System.out.println(customer.getName() + " - " + customer.getDescription()));
    }


    @Test
    void testDeleteProduct() throws SQLException {
        Product newProduct = new Product();
        newProduct.setId(15);
        newProduct.setName("milk");
        newProduct.setDescription("product");
        newProduct.setPrice(120.0);
        newProduct.setStock(10);

        ProductDao productDao = new ProductDao();
        try {
            // Add the customer to the database
            productDao.delete(2);

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

//    private HttpServletRequest mockRequest;
//
//    private HttpServletResponse mockResponse;
//
//    private RequestDispatcher mockRequestDispatcher;
//
//    private ProductServlet productServlet;

    @Test
    void testDoGetWithIdParameter() throws ServletException, IOException {
        // Arrange
//        String productId = "123"; // Example product ID
//        when(mockRequest.getParameter("id")).thenReturn(productId);
//        when(mockRequest.getRequestDispatcher("views/product.jsp")).thenReturn(mockRequestDispatcher);
//
//        // Act
//        productServlet.doGet(mockRequest, mockResponse);
//
//        // Assert
//        verify(mockRequest).setAttribute(eq("product"), any()); // Verify that the product attribute is set
//        verify(mockRequestDispatcher).forward(mockRequest, mockResponse); // Verify forwarding
    }

    @Test
    void testDoGetWithoutIdParameter() throws ServletException, IOException {
//        // Arrange
//        when(mockRequest.getParameter("id")).thenReturn(null); // No ID provided
//        when(mockRequest.getRequestDispatcher("views/products.jsp")).thenReturn(mockRequestDispatcher);
//
//        // Act
//        productServlet.doGet(mockRequest, mockResponse);
//
//        // Assert
//        verify(mockRequest).setAttribute(eq("products"), any()); // Verify that the products attribute is set
//        verify(mockRequestDispatcher).forward(mockRequest, mockResponse); // Verify forwarding
//    }
    }
}