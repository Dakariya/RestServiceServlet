package com.zharnikova.example.repository;

import com.zharnikova.example.ConnectionUtil;
import com.zharnikova.example.model.Customer;
import com.zharnikova.example.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final String productQuery = "SELECT * FROM Product WHERE id = ?";
    private static final String customerQuery = "SELECT * FROM Customer WHERE product_id = ?";

    public Product getProductWithCustomer(Integer productId) {
        Product product = null;
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = ConnectionUtil.instance();
             PreparedStatement preparedStatement = connection.prepareStatement(productQuery);
             PreparedStatement customerStatement = connection.prepareStatement(customerQuery)) {

            // Получение product
            preparedStatement.setInt(1, productId);
            try (ResultSet userResultSet = preparedStatement.executeQuery()) {
                if (userResultSet.next()) {
                    product = new Product();
                    product.setId(userResultSet.getInt("id"));
                    product.setName(userResultSet.getString("name"));
                }
            }

            // Получение customers
            if (product != null) {
                customerStatement.setInt(1, productId);
                try (ResultSet orderResultSet = customerStatement.executeQuery()) {
                    while (orderResultSet.next()) {
                        com.zharnikova.example.model.Customer customer = new Customer();
                        customer.setId(orderResultSet.getInt("id"));
                        customers.add(customer);
                    }
                }
                product.setCustomers(customers);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
}
