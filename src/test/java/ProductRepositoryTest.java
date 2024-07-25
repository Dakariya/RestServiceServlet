import com.zharnikova.example.model.Product;
import com.zharnikova.example.repository.ProductRepository;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    @Test
    public void testGetProductWithCustomer() {
        // Подготовка тестовых данных
        // Создание экземпляра ProductRepository
        ProductRepository productRepository = new ProductRepository();

        // Вызов метода с ожидаемым productId
        Integer productId = 1;
        Product product = productRepository.getProductWithCustomer(productId);

        // Проверка результатов
        assertNotNull(product);
        assertEquals(productId, product.getId());
        assertEquals("Название продукта", product.getName());
        assertNotNull(product.getCustomers());
        assertEquals(1, product.getCustomers().size());

        // Обработка исключений
        try {
            productRepository.getProductWithCustomer(-1);
            fail("Должно было возникнуть исключение");
        } catch (RuntimeException e) {
            // Исключение должно содержать сообщение об ошибке
            assertTrue(e.getMessage().contains("Не найден продукт с ID -1"));
        }
    }
}
