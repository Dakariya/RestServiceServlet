package com.zharnikova.example.mapper;


import com.zharnikova.example.dto.CustomerDto;
import com.zharnikova.example.model.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer){
        CustomerDto dto = new CustomerDto();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setPhone(customer.getPhone());
        dto.setEmail(customer.getEmail());
        return dto;
    }
    public static Customer mapToCustomer(CustomerDto dto){
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setPhone(dto.getPhone());
        customer.setEmail(dto.getEmail());
        return customer;
    }
}
