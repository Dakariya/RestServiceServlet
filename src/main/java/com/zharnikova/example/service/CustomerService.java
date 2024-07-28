package com.zharnikova.example.service;

import com.zharnikova.example.dao.CustomerDao;
import com.zharnikova.example.dto.CustomerDto;
import com.zharnikova.example.mapper.CustomerMapper;
import com.zharnikova.example.model.Customer;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CustomerService {
    private final CustomerDao customerDao;

    public CustomerService() {
        this.customerDao = new CustomerDao();
    }




    public List<CustomerDto> getAll() {
        List<Customer> all = null;
        try {
            all = customerDao.getAll();
        } catch (SQLException e) {
            return Collections.emptyList();
        }
        return all.stream().map(CustomerMapper::mapToCustomerDto).toList();
    }

    public Optional<Customer> getById(int id) {
        return customerDao.getById(id);
    }


    public void add(Customer customer) {
        try {
            customerDao.add(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void update(Customer customer) {
        try {
            customerDao.update(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteCustomer(int id) {
        try {
            customerDao.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
