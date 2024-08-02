package com.zharnikova.example.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerDtoTest {
    @Test
    public void testNoArgsConstructor() {
        CustomerDto customer = new CustomerDto();
        assertNotNull(customer);
    }

    @Test
    public void testAllArgsConstructor() {
        CustomerDto customer = new CustomerDto(1, "John Doe", "1234567890", "john.doe@example.com");
        assertEquals(1, customer.getId());
        assertEquals("John Doe", customer.getName());
        assertEquals("1234567890", customer.getPhone());
        assertEquals("john.doe@example.com", customer.getEmail());
    }

    @Test
    public void testPartialArgsConstructor() {
        CustomerDto customer = new CustomerDto("Jane Doe", "0987654321", "jane.doe@example.com");
        assertEquals("Jane Doe", customer.getName());
        assertEquals("0987654321", customer.getPhone());
        assertEquals("jane.doe@example.com", customer.getEmail());
    }

    @Test
    public void testSettersAndGetters() {
        CustomerDto customer = new CustomerDto();
        customer.setId(2);
        customer.setName("Alice");
        customer.setPhone("1112223333");
        customer.setEmail("alice@example.com");

        assertEquals(2, customer.getId());
        assertEquals("Alice", customer.getName());
        assertEquals("1112223333", customer.getPhone());
        assertEquals("alice@example.com", customer.getEmail());
    }

    @Test
     void testConstructorWithId() {

        int id = 1;
        String name = "John Doe";
        String phone = "123-456-7890";
        String email = "john.doe@example.com";


        CustomerDto customerDto = new CustomerDto(id, name, phone, email);


        assertEquals(id, customerDto.getId());
        assertEquals(name, customerDto.getName());
        assertEquals(phone, customerDto.getPhone());
        assertEquals(email, customerDto.getEmail());
    }

    @Test
     void testConstructorWithoutId() {

        String name = "John Doe";
        String phone = "123-456-7890";
        String email = "john.doe@example.com";


        CustomerDto customerDto = new CustomerDto(name, phone, email);


        assertEquals(0, customerDto.getId());
        assertEquals(name, customerDto.getName());
        assertEquals(phone, customerDto.getPhone());
        assertEquals(email, customerDto.getEmail());
    }
    @Test
     void testEquals() {

        CustomerDto customerDto1 = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");
        CustomerDto customerDto2 = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");
        CustomerDto customerDto3 = new CustomerDto(2, "Jane Doe", "234-567-8901", "jane.doe@example.com");


        assertThat(customerDto1).isEqualTo(customerDto2);
        assertThat(customerDto1).isNotEqualTo(customerDto3);
    }

    @Test
     void testHashCode() {

        CustomerDto customerDto1 = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");
        CustomerDto customerDto2 = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");
        CustomerDto customerDto3 = new CustomerDto(2, "Jane Doe", "234-567-8901", "jane.doe@example.com");


        assertThat(customerDto1.hashCode()).isEqualTo(customerDto2.hashCode());
        assertThat(customerDto1.hashCode()).isNotEqualTo(customerDto3.hashCode());
    }

    @Test
     void testToString() {

        CustomerDto customerDto = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");


        assertThat(customerDto.toString()).isEqualTo("CustomerDto{id=1, name='John Doe', phone='123-456-7890', email='john.doe@example.com'}");
    }


}