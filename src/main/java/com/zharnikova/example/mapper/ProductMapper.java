package com.zharnikova.example.mapper;

import com.zharnikova.example.dto.CustomerDto;
import com.zharnikova.example.dto.ProductDto;
import com.zharnikova.example.model.Product;

import java.util.List;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());

        return dto;
    }

    public static Product mapToProduct(ProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        return product;
    }
    //
//        List<CustomerDto> customerDtos = product.getCustomers()
//                .stream()
//                .map(CustomerMapper::mapToCustomerDto)
//                .toList();
//
//        dto.setCustomers(customerDtos);


}
