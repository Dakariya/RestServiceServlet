package com.zharnikova.example.repository;

import com.zharnikova.example.model.CustomersProducts;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductRepositoryTest {
    @Test
     void testGetCustomerProductNames() throws Exception {
        // Подготавливаем данные для теста
        List<CustomersProducts> expectedResult =List.of(new CustomersProducts("Ivan","sweets"), new CustomersProducts("Ivan","sweets"), new CustomersProducts("Svetlana","sweets"), new CustomersProducts("Ivan", "watermelon"));// Заполняем список ожидаемыми данными

        // Вызываем тестируемый метод
        ProductRepository productRepository = new ProductRepository();
        List<CustomersProducts> actualResult = productRepository.getCustomerProductNames();

        // Сравниваем результаты
        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult.get(1).getCustomer_name(), actualResult.get(1).getCustomer_name());
        assertEquals(expectedResult.get(1).getProduct_name(), actualResult.get(1).getProduct_name());
        assertEquals(expectedResult.get(2).getCustomer_name(), actualResult.get(2).getCustomer_name());
        assertEquals(expectedResult.get(2).getProduct_name(), actualResult.get(2).getProduct_name());
        assertEquals(expectedResult.get(3).getCustomer_name(), actualResult.get(3).getCustomer_name());
        assertEquals(expectedResult.get(3).getProduct_name(), actualResult.get(3).getProduct_name());
    }

    }