package com.zharnikova.example.dao;

import com.zharnikova.example.ConnectionUtil;
import com.zharnikova.example.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDao implements DAO<Customer> {
    private static final String GET_ALL_CUSTOMERS_QUERY = "SELECT * FROM customer";
    private static final String GET_CUSTOMER_BY_ID_QUERY = "SELECT * FROM customer WHERE id = ?";
    private static final String ADD_CUSTOMER_QUERY = "INSERT INTO customer (name, phone, email) VALUES (?, ?, ?)";
    private static final String UPDATE_CUSTOMER_QUERY = "UPDATE customer SET name = ?, phone = ?, email = ? WHERE id = ?";
    private static final String DELETE_CUSTOMER_QUERY = "DELETE FROM customer WHERE id = ?";

    private final Connection connection;

    public CustomerDao() {
        this.connection = ConnectionUtil.instance();
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CUSTOMERS_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setEmail(resultSet.getString("email"));
                customers.add(customer);
            }
        }
        return customers;
    }

    @Override
    public Optional<Customer> getById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                Customer customer;
                if (resultSet.next()) {
                    customer = new Customer();
                    customer.setId(resultSet.getInt("id"));
                    customer.setName(resultSet.getString("name"));
                    customer.setPhone(resultSet.getString("phone"));
                    customer.setEmail(resultSet.getString("email"));
                } else {
                    return Optional.empty();
                }
                return Optional.of(customer);
            }
        } catch (SQLException e) {
            return Optional.empty();
        }

    }

    @Override
    public void add(Customer customer) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_CUSTOMER_QUERY)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getPhone());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(Customer customer) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_QUERY)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getPhone());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setInt(4, customer.getId());
            preparedStatement.executeUpdate();
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_QUERY)) {
            preparedStatement.setInt(1, id);
            int updatedStrings = preparedStatement.executeUpdate();
            if (updatedStrings < 1) {
                throw new SQLException();
            }

        }
    }
}
