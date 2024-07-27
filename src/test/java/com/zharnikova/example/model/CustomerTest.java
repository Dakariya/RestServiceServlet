package com.zharnikova.example.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    void testConstructorWithIdParameter() {
        Customer customer = new Customer(1, "name", "phone", "email");
        assertEquals(1, customer.getId());
        assertEquals("name", customer.getName());
        assertEquals("phone", customer.getPhone());
        assertEquals("email", customer.getEmail());
    }

    @Test
    void testConstructorWithoutIdParameter() {
        Customer customer = new Customer("name", "phone", "email");
        assertEquals("name", customer.getName());
        assertEquals("phone", customer.getPhone());
        assertEquals("email", customer.getEmail());
    }

    @Test
    void testEqualsMethod() {
        Customer customer1 = new Customer(1, "name", "phone", "email");
        Customer customer2 = new Customer(1, "name", "phone", "email");
        assertEquals(customer1, customer2);

        Customer customer3 = new Customer(2, "name", "phone", "email");
        assertNotEquals(customer1, customer3);
    }

    @Test
    void testHashCodeMethod() {
        Customer customer1 = new Customer(1, "name", "phone", "email");
        Customer customer2 = new Customer(1, "name", "phone", "email");
        assertEquals(customer1.hashCode(), customer2.hashCode());

        Customer customer3 = new Customer(2, "name", "phone", "email");
        assertNotEquals(customer1.hashCode(), customer3.hashCode());
    }

    @Test
    void testToStringMethod() {
        Customer customer = new Customer(1, "name", "phone", "email");
        assertEquals("Customer{id=1, name='name', phone='phone', email='email'}", customer.toString());
    }

    @Test
    void testGetProductsMethod() {
        Customer customer = new Customer();

        Product product1 = new Product(1,"sugar","brown sugar",45.5,10);
        Product product2 = new Product(2,"milk","cow's milk",70.0,10);
        // Добавляем продукты в список
        customer.setProducts(Arrays.asList(product1, product2));
        List<Product> actualProducts = customer.getProducts();
        assertEquals(2, actualProducts.size());
        assertNotEquals(3,actualProducts.size());
        assertEquals("sugar", actualProducts.get(0).getName());
        assertEquals("milk", actualProducts.get(1).getName());
    }

    @Test
    void testSetProductsMethod() {
        Customer customer = new Customer();
        Product product1 = new Product(1,"sugar","brown sugar",45.5,10);
        Product product2 = new Product(2,"milk","cow's milk",70.0,10);
        List<Product> products = Arrays.asList(product1, product2);
        customer.setProducts(products);
        List<Product> actualProducts = customer.getProducts();
        assertEquals(2, actualProducts.size());
        assertNotEquals(3,actualProducts.size());
        assertEquals("sugar", actualProducts.get(0).getName());
        assertEquals("milk", actualProducts.get(1).getName());
    }
}

