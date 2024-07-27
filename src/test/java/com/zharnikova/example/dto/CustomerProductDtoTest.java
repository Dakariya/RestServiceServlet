package com.zharnikova.example.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerProductDtoTest {
    @Test
    void testConstructor() {
        CustomerProductDto customerProductDto = new CustomerProductDto("John Doe", "Product A");
        assertEquals("John Doe", customerProductDto.getCustomer_name());
        assertEquals("Product A", customerProductDto.getProduct_name());
    }

    @Test
    public void testEquals() {
        CustomerProductDto cp1 = new CustomerProductDto("John Doe", "Product A");
        CustomerProductDto cp2 = new CustomerProductDto("John Doe", "Product A");
        CustomerProductDto cp3 = new CustomerProductDto("Jane Doe", "Product B");

        assertTrue(cp1.equals(cp2)); // одинаковые объекты равны
        assertFalse(cp1.equals(cp3)); // разные объекты не равны
    }

    @Test
    public void testHashCode() {
        CustomerProductDto cp1 = new CustomerProductDto("John Doe", "Product A");
        CustomerProductDto cp2 = new CustomerProductDto("Jane Doe", "Product B");

        assertNotSame(cp1.hashCode(), cp2.hashCode()); // разные объекты имеют разные хеш-коды
    }

    @Test
    public void testToString() {
        CustomerProductDto cp = new CustomerProductDto("John Doe", "Product A");

        assertEquals("CustomerProductDto{customer_name='John Doe', product_name='Product A'}", cp.toString());
    }

}