package com.zharnikova.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomersProductsTest {
    @Test
    void testConstructor() {
        CustomersProducts customersProducts = new CustomersProducts("John Doe", "Product A");
        assertEquals("John Doe", customersProducts.getCustomer_name());
        assertEquals("Product A", customersProducts.getProduct_name());
    }

    @Test
     void testEquals() {
        CustomersProducts cp1 = new CustomersProducts("John Doe", "Product A");
        CustomersProducts cp2 = new CustomersProducts("John Doe", "Product A");
        CustomersProducts cp3 = new CustomersProducts("Jane Doe", "Product B");

        assertTrue(cp1.equals(cp2)); // одинаковые объекты равны
        assertFalse(cp1.equals(cp3)); // разные объекты не равны
    }

    @Test
     void testHashCode() {
        CustomersProducts cp1 = new CustomersProducts("John Doe", "Product A");
        CustomersProducts cp2 = new CustomersProducts("Jane Doe", "Product B");

        assertNotSame(cp1.hashCode(), cp2.hashCode()); // разные объекты имеют разные хеш-коды
    }

    @Test
     void testToString() {
        CustomersProducts cp = new CustomersProducts("John Doe", "Product A");

        assertEquals("CustomersProducts{customer_name='John Doe', product_name='Product A'}", cp.toString());
    }
}