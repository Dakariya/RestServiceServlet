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
    private static final String productQuery = "SELECT * FROM Product WHERE id = ?";
    private static final String customerQuery = "SELECT * FROM Customer WHERE product_id = ?";




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
    //    public Product getProductWithCustomer(Integer productId) {
//        Product product = null;
//        List<Customer> customers = new ArrayList<>();
//
//        try (
//                PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(productQuery);
//                PreparedStatement customerStatement = DataSource.getConnection().prepareStatement(customerQuery)) {
//
//            // Получение product
//            preparedStatement.setInt(1, productId);
//            try (ResultSet userResultSet = preparedStatement.executeQuery()) {
//                if (userResultSet.next()) {
//                    product = new Product();
//                    product.setId(userResultSet.getInt("id"));
//                    product.setName(userResultSet.getString("name"));
//                }
//            }
//
//            // Получение customers
//            if (product != null) {
//                customerStatement.setInt(1, productId);
//                try (ResultSet orderResultSet = customerStatement.executeQuery()) {
//                    while (orderResultSet.next()) {
//                        com.zharnikova.example.model.Customer customer = new Customer();
//                        customer.setId(orderResultSet.getInt("id"));
//                        customers.add(customer);
//                    }
//                }
//                product.setCustomers(customers);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return product;
//    }
}

