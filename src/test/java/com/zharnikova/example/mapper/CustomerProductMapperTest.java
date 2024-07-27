package com.zharnikova.example.mapper;

import com.zharnikova.example.dto.CustomerProductDto;
import com.zharnikova.example.model.CustomersProducts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerProductMapperTest {

    @Test
    public void testMapToCustomerProductDto() {
        // Создаём объект CustomersProducts
        CustomersProducts customersProducts = new CustomersProducts();
        customersProducts.setCustomer_name("John Doe");
        customersProducts.setProduct_name("Product 1");

        // Преобразуем объект CustomersProducts в CustomerProductDto
        CustomerProductDto dto = CustomerProductMapper.mapToCustomerProductDto(customersProducts);

        // Проверяем результат преобразования
        assertEquals("John Doe", dto.getCustomer_name());
        assertEquals("Product 1", dto.getProduct_name());
    }

    @Test
    public void testMapToCustomerProduct() {
        // Создаём объект CustomerProductDto
        CustomerProductDto dto = new CustomerProductDto();
        dto.setCustomer_name("Jane Doe");
        dto.setProduct_name("Product 2");

        // Преобразуем объект CustomerProductDto в CustomersProducts
        CustomersProducts customersProducts = CustomerProductMapper.mapToCustomerProduct(dto);

        // Проверяем результат преобразования
        assertEquals("Jane Doe", customersProducts.getCustomer_name());
        assertEquals("Product 2", customersProducts.getProduct_name());
    }
}