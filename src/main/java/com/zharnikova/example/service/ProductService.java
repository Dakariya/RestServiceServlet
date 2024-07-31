package com.zharnikova.example.service;

import com.zharnikova.example.dao.ProductDao;
import com.zharnikova.example.dto.CustomerProductDto;
import com.zharnikova.example.dto.ProductDto;
import com.zharnikova.example.mapper.CustomerProductMapper;
import com.zharnikova.example.mapper.ProductMapper;
import com.zharnikova.example.model.CustomersProducts;
import com.zharnikova.example.model.Product;
import com.zharnikova.example.repository.ProductRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private ProductDao productDao;

    public ProductService() {
        this.productDao = new ProductDao();
    }

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

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


    public List<CustomerProductDto> getCustomerProductNamesAll() {
        List<CustomersProducts> all = null;
        try {
            all = productRepository.getCustomerProductNames();
        } catch (SQLException e) {
            return Collections.emptyList();
        } return all.stream().map(CustomerProductMapper::mapToCustomerProductDto).toList();
    }


}
