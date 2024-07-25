import com.zharnikova.example.dto.ProductDto;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProductDtoTest {
    @Test
    public void testEquals() {
        ProductDto product1 = new ProductDto(1, "Книга", "Описание книги", 100.0, 10);
        ProductDto product2 = new ProductDto(1, "Книга", "Описание книги", 100.0, 10);
        ProductDto product3 = new ProductDto(2, "Книга 2", "Описание книги 2", 200.0, 20);

        assertEquals(product1, product2); // Должны быть равны
        assertNotEquals(product1, product3); // Должны быть не равны
    }

    @Test
    public void testHashCode() {
        ProductDto product1 = new ProductDto(1, "Книга", "Описание книги", 100.0, 10);
        ProductDto product2 = new ProductDto(1, "Книга", "Описание книги", 100.0, 10);
        ProductDto product3 = new ProductDto(2, "Книга 2", "Описание книги 2", 200.0, 20);

        assertEquals(product1.hashCode(), product2.hashCode()); // Должны иметь одинаковый хэш-код
        assertNotEquals(product1.hashCode(), product3.hashCode()); // Должны иметь разные хэш-коды
    }

    @Test
    public void testToString() {
        ProductDto product = new ProductDto(1, "Книга", "Описание книги", 100.0, 10);

        assertEquals("ProductDto{id=1, name='Книга', description='Описание книги', price=100.0, stock=10}", product.toString());
    }
}