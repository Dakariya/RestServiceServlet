package com.zharnikova.example.mapper;

import com.zharnikova.example.dto.ProductDto;
import com.zharnikova.example.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {
    @Test
    void MapProductToProductDto() {
        Product product = new Product(1, "Product Name", "Product Description", 100.0, 10);
        ProductDto productDto = ProductMapper.mapToProductDto(product);

        assertEquals(1, productDto.getId());
        assertEquals("Product Name", productDto.getName());
        assertEquals("Product Description", productDto.getDescription());
        assertEquals(100.0, productDto.getPrice(), 0.01);
        assertEquals(10, productDto.getStock());
    }

    @Test
    void shouldMapProductDtoToProduct() {
        ProductDto productDto = new ProductDto(1, "Product Name", "Product Description", 100.0, 10);
        Product product = ProductMapper.mapToProduct(productDto);

        assertEquals(1, product.getId());
        assertEquals("Product Name", product.getName());
        assertEquals("Product Description", product.getDescription());
        assertEquals(100.0, product.getPrice(), 0.01);
        assertEquals(10, product.getStock());
    }
}