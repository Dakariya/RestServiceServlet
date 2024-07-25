package com.zharnikova.example.service;

import com.zharnikova.example.dao.ProductDao;
import com.zharnikova.example.dto.ProductDto;
import com.zharnikova.example.mapper.ProductMapper;
import com.zharnikova.example.model.Product;
import com.zharnikova.example.repository.ProductRepository;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private ProductDao productDao;
    private ProductRepository productRepository;

    public ProductService(){this.productDao=new ProductDao();}

    public List<ProductDto> getAll() {
        List<Product> all = null;
        try {
            all = productDao.getAll();
        } catch (SQLException e) {
            return Collections.emptyList();
        }
        return all.stream().map(ProductMapper::mapToProductDto).toList();
    }
    public void delete(int id) {
        try {
            productDao.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void add(Product product) {
        try {
            productDao.add(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(Product product) {
        try {
            productDao.update(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Optional<Product> getById(int id) {
        return productDao.getById(id);
    }
    public ProductDto getProductWitsCustomers(Integer productId) {
        Product productWithCustomer = productRepository.getProductWithCustomer(productId);
        return ProductMapper.mapToProductDto(productWithCustomer);
    }
}
