package com.zharnikova.example.dao;

import com.zharnikova.example.ConnectionUtil;
import com.zharnikova.example.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDao implements DAO<Product> {
    private static final String GET_ALL_PRODUCTS_QUERY = "SELECT * FROM product";
    private static final String GET_PRODUCT_BY_ID_QUERY = "SELECT * FROM product WHERE id = ?";
    private static final String ADD_PRODUCT_QUERY = "INSERT INTO product (name, description, price, stock) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_PRODUCT_QUERY = "UPDATE product SET name = ?, description = ?, price = ?, stock = ? WHERE id = ?";
    private static final String DELETE_PRODUCT_QUERY = "DELETE FROM product WHERE id = ?";

    private final Connection connection;

    public ProductDao() {
        this.connection = ConnectionUtil.instance();
    }

    @Override
    public List<Product> getAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getDouble("price"));
                product.setStock(resultSet.getInt("stock"));
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public Optional<Product> getById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                Product product;
                if (resultSet.next()) {
                    product = new Product();
                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setDescription(resultSet.getString("description"));
                    product.setPrice(resultSet.getDouble("price"));
                    product.setStock(resultSet.getInt("stock"));
                } else {
                    return Optional.empty();
                }
                return Optional.of(product);
            }
        } catch (SQLException e) {
            return Optional.empty();
        }

    }

    @Override
    public void add(Product product) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT_QUERY)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getStock());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(Product product) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_QUERY)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getStock());
            preparedStatement.setInt(5, product.getId());
            preparedStatement.executeUpdate();
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_QUERY)) {
            preparedStatement.setInt(1, id);
            int updatedStrings = preparedStatement.executeUpdate();
            if (updatedStrings < 1) {
                throw new SQLException();
            }

        }
    }

}
