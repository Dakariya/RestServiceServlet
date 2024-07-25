import com.zharnikova.example.model.Product;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ProductTest {
    @Test
    public void testConstructorWithAllParams() {
        Product product = new Product(1, "Книга", "Описание книги", 10.0, 10);

        assertThat(product.getId()).isEqualTo(1);
        assertThat(product.getName()).isEqualTo("Книга");
        assertThat(product.getDescription()).isEqualTo("Описание книги");
        assertThat(product.getPrice()).isEqualTo(10.0);
        assertThat(product.getStock()).isEqualTo(10);
    }

    @Test
    public void testConstructorWithFourParams() {
        Product product = new Product("Книга", "Описание книги", 10.0, 10);

        assertThat(product.getId()).isNull();
        assertThat(product.getName()).isEqualTo("Книга");
        assertThat(product.getDescription()).isEqualTo("Описание книги");
        assertThat(product.getPrice()).isEqualTo(10.0);
        assertThat(product.getStock()).isEqualTo(10);
    }

    @Test
    public void testEquals() {
        Product product1 = new Product(1, "Книга", "Описание книги", 10.0, 10);
        Product product2 = new Product(1, "Книга", "Описание книги", 10.0, 10);

        assertThat(product1).isEqualTo(product2);
    }

    @Test
    public void testHashCode() {
        Product product1 = new Product(1, "Книга", "Описание книги", 10.0, 10);
        Product product2 = new Product(1, "Книга", "Описание книги", 10.0, 10);

        assertThat(product1.hashCode()).isEqualTo(product2.hashCode());
    }

    @Test
    public void testToString() {
        Product product = new Product(1, "Книга", "Описание книги", 10.0, 10);

        assertThat(product.toString()).isEqualTo("Product{id=1, name='Книга', description='Описание книги', price=10.0, stock=10}");
    }
}
