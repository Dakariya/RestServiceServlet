package com.zharnikova.example.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    List<T> getAll() throws SQLException;

    void add(T t) throws SQLException;

    void update(T t) throws SQLException;


    void delete(int id) throws SQLException;

    Optional<T> getById(int id) throws SQLException;
}
