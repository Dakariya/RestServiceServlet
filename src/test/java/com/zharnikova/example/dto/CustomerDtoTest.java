package com.zharnikova.example.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerDtoTest {
    @Test
    public void testConstructorWithId() {

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
    public void testConstructorWithoutId() {

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
    public void testEquals() {

        CustomerDto customerDto1 = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");
        CustomerDto customerDto2 = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");
        CustomerDto customerDto3 = new CustomerDto(2, "Jane Doe", "234-567-8901", "jane.doe@example.com");


        assertThat(customerDto1).isEqualTo(customerDto2);
        assertThat(customerDto1).isNotEqualTo(customerDto3);
    }

    @Test
    public void testHashCode() {

        CustomerDto customerDto1 = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");
        CustomerDto customerDto2 = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");
        CustomerDto customerDto3 = new CustomerDto(2, "Jane Doe", "234-567-8901", "jane.doe@example.com");


        assertThat(customerDto1.hashCode()).isEqualTo(customerDto2.hashCode());
        assertThat(customerDto1.hashCode()).isNotEqualTo(customerDto3.hashCode());
    }

    @Test
    public void testToString() {

        CustomerDto customerDto = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");


        assertThat(customerDto.toString()).isEqualTo("CustomerDto{id=1, name='John Doe', phone='123-456-7890', email='john.doe@example.com'}");
    }


}