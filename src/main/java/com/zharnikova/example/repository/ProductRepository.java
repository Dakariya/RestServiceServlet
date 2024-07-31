package com.zharnikova.example.repository;

import com.zharnikova.example.DataSource;
import com.zharnikova.example.model.Customer;
import com.zharnikova.example.model.CustomersProducts;
import com.zharnikova.example.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private static final String query = "SELECT customer.name, product.name FROM customer_products JOIN Product ON customer_products.product_id = product.id  JOIN customer ON customer_products.customer_id = customer.id;";

    public ProductRepository() {
    }

    public List<CustomersProducts> getCustomerProductNames() throws SQLException {
        List<CustomersProducts> customersProducts1 = new ArrayList<>();
        try (PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                CustomersProducts customersProducts = new CustomersProducts();
                customersProducts.setCustomer_name(resultSet.getString("customer.name"));
                customersProducts.setProduct_name(resultSet.getString("product.name"));
                customersProducts1.add(customersProducts);

            }
        }return customersProducts1;

    }
}

