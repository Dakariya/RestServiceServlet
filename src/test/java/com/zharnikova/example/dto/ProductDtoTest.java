package com.zharnikova.example.dto;

import com.zharnikova.example.service.CustomerService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductDtoTest {
    @Test
    void constructorSetAllFields() {
        ProductDto productDto = new ProductDto(1, "Product Name", "Product Description", 100.0, 10);

        assertEquals(1, productDto.getId());
        assertEquals("Product Name", productDto.getName());
        assertEquals("Product Description", productDto.getDescription());
        assertEquals(100.0, productDto.getPrice(), 0.01);
        assertEquals(10, productDto.getStock());
    }

    @Test
     void testEquals() {
        ProductDto product1 = new ProductDto(1, "milk°", "cow's milk", 100.0, 10);
        ProductDto product2 = new ProductDto(1, "milk°", "cow's milk", 100.0, 10);
        ProductDto product3 = new ProductDto(2, "sugar° 2", "brown sugar", 200.0, 20);

        assertEquals(product1, product2);
        assertNotEquals(product1, product3);
    }

    @Test
     void testHashCode() {
        ProductDto product1 = new ProductDto(1, "milk°", "cow's milk", 100.0, 10);
        ProductDto product2 = new ProductDto(1, "milk°", "cow's milk", 100.0, 10);
        ProductDto product3 = new ProductDto(2, "sugar° 2", "brown sugar", 200.0, 20);

        assertEquals(product1.hashCode(), product2.hashCode());
        assertNotEquals(product1.hashCode(), product3.hashCode());
    }

    @Test
     void testToString() {
        ProductDto product = new ProductDto(1, "milk°", "cow's milk", 100.0, 10);

        assertEquals("ProductDto{id=1, name='milk°', description='cow's milk', price=100.0, stock=10}", product.toString());
    }


}