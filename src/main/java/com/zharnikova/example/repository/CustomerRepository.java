package com.zharnikova.example.repository;

import com.zharnikova.example.dao.CustomerDao;
import com.zharnikova.example.dto.CustomerDto;

import java.util.Collections;
import java.util.List;

public class CustomerRepository {
    private final CustomerDao customerDao = new CustomerDao();

}
