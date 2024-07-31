package com.zharnikova.example.mapper;

import com.zharnikova.example.dto.CustomerDto;
import com.zharnikova.example.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CustomerMapperTest {

    @Test
     void testMapToCustomerDto() {
        Customer customer = new Customer(1, "John Doe", "123-456-7890", "john.doe@example.com");
        CustomerDto expectedDto = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");
        CustomerDto actualDto = CustomerMapper.mapToCustomerDto(customer);

        assertEquals(expectedDto, actualDto);
    }

    @Test
     void testMapToCustomer() {
        CustomerDto dto = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");
        Customer expectedCustomer = new Customer(1, "John Doe", "123-456-7890", "john.doe@example.com");
        Customer actualCustomer = CustomerMapper.mapToCustomer(dto);

        assertEquals(expectedCustomer, actualCustomer);
    }


}