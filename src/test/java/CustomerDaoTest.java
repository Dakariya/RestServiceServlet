import com.zharnikova.example.dao.CustomerDao;
import com.zharnikova.example.model.Customer;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class CustomerDaoTest {
    @Test
    public void testConnection() throws SQLException {
        CustomerDao customerDao = new CustomerDao();
        List<Customer> customers = customerDao.getAll();
        if (!customers.isEmpty()) {
            System.out.println("Подключение к базе данных успешно");
        } else {
            System.out.println("Подключение к базе данных не удалось");
        }
    }

}