import com.zharnikova.example.dao.ProductDao;

import com.zharnikova.example.model.Product;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoTest {
    @Test
    public void testConnection() throws SQLException {
        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.getAll();
        if (!products.isEmpty()) {
            System.out.println("Подключение к базе данных успешно");
        } else {
            System.out.println("Подключение к базе данных не удалось");
        }
    }
}