package com.zharnikova.example.mapper;

import com.zharnikova.example.dto.CustomerDto;
import com.zharnikova.example.dto.CustomerProductDto;
import com.zharnikova.example.model.Customer;
import com.zharnikova.example.model.CustomersProducts;

public class CustomerProductMapper {
    public static CustomerProductDto mapToCustomerProductDto(CustomersProducts customersProducts){
        CustomerProductDto dto = new CustomerProductDto();
        dto.setCustomer_name(customersProducts.getCustomer_name());
        dto.setProduct_name(customersProducts.getProduct_name());
        return dto;
    }
    public static CustomersProducts mapToCustomerProduct(CustomerProductDto dto){
        CustomersProducts customersProducts = new CustomersProducts();
        customersProducts.setCustomer_name(dto.getCustomer_name());
        customersProducts.setProduct_name(dto.getProduct_name());
        return customersProducts;
    }
}
