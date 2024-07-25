import com.zharnikova.example.dto.ProductDto;
import com.zharnikova.example.mapper.ProductMapper;
import com.zharnikova.example.model.Product;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ProductMapperTest {
    @Test
    public void testMapToProductDto() {
        // Подготовка данных
        Product product = new Product();
        product.setId(1);
        product.setName("Смартфон");
        product.setDescription("Современный смартфон с большим экраном.");
        product.setPrice(599.99);
        product.setStock(100);

        // Вызов тестируемого метода
        ProductDto dto = ProductMapper.mapToProductDto(product);

        // Проверка результата
        assertEquals(Optional.of(1), Optional.of(dto.getId()));
        assertEquals("Смартфон", dto.getName());
        assertEquals("Современный смартфон с большим экраном.", dto.getDescription());
        assertEquals(599.99, dto.getPrice(), 0.01);
        assertEquals(Optional.of(100), Optional.of(dto.getStock()));
    }

    @Test
    public void testMapToProduct() {
        // Подготовка данных
        ProductDto dto = new ProductDto();
        dto.setId(1);
        dto.setName("Смартфон");
        dto.setDescription("Современный смартфон с большим экраном.");
        dto.setPrice(599.99);
        dto.setStock(100);

        // Вызов тестируемого метода
        Product product = ProductMapper.mapToProduct(dto);

        // Проверка результата
        assertEquals(Optional.of(1), Optional.ofNullable(product.getId()));
        assertEquals("Смартфон", product.getName());
        assertEquals("Современный смартфон с большим экраном.", product.getDescription());
        assertEquals(599.99, product.getPrice(), 0.01);
        assertEquals(Optional.of(100), Optional.ofNullable(product.getStock()));
    }
}
