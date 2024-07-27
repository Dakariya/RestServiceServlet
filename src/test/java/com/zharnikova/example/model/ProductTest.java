package com.zharnikova.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void testConstructorWithAllParameters() {
        Product product = new Product(1, "name", "description", 10.0, 10);
        assertEquals(1, product.getId());
        assertEquals("name", product.getName());
        assertEquals("description", product.getDescription());
        assertEquals(10.0, product.getPrice(), 0.01);
        assertEquals(10, product.getStock());
    }

    @Test
    void testConstructorWithNameAndDescriptionParameters() {
        Product product = new Product("name", "description", 10.0, 10);
        assertEquals("name", product.getName());
        assertEquals("description", product.getDescription());
        assertEquals(10.0, product.getPrice(), 0.01);
        assertEquals(10, product.getStock());
    }

    @Test
    void testEqualsMethod() {
        Product product1 = new Product(1, "name", "description", 10.0, 10);
        Product product2 = new Product(1, "name", "description", 10.0, 10);
        assertEquals(product1, product2);

        Product product3 = new Product(2, "name", "description", 10.0, 10);
        assertNotEquals(product1, product3);
    }

    @Test
    void testHashCodeMethod() {
        Product product1 = new Product(1, "name", "description", 10.0, 10);
        Product product2 = new Product(1, "name", "description", 10.0, 10);
        assertEquals(product1.hashCode(), product2.hashCode());

        Product product3 = new Product(2, "name", "description", 10.0, 10);
        assertNotEquals(product1.hashCode(), product3.hashCode());
    }

    @Test
    void testToStringMethod() {
        Product product = new Product(1, "name", "description", 10.0, 10);
        assertEquals("Product{id=1, name='name', description='description', price=10.0, stock=10}", product.toString());
    }



}