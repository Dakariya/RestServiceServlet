package com.zharnikova.example.repository;

import com.zharnikova.example.model.CustomersProducts;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    void testGetCustomerProductNames() {
        // Arrange: Create an instance of ProductRepository (assuming it's properly initialized)
        ProductRepository productRepository = new ProductRepository();

        // Act: Call the method
        List<CustomersProducts> result;
        try {
            result = productRepository.getCustomerProductNames();
        } catch (SQLException e) {
            // Handle any exceptions (e.g., log or fail the test)
            fail("Exception occurred: " + e.getMessage());
            return;
        }

        // Assert: Verify the expected behavior
        assertNotNull(result, "Result should not be null");
        // Add more assertions based on your specific requirements

        // Optional: Print the results for debugging
        result.forEach(cp -> System.out.println(cp.getCustomer_name() + " - " + cp.getProduct_name()));
    }

}