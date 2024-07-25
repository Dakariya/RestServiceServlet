import com.zharnikova.example.model.Customer;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CustomerTest {

        @Test
        public void testHashCode() {
            Customer customer1 = new Customer(1, "John Doe", "123-456-7890", "john.doe@example.com");
            Customer customer2 = new Customer(2, "Jane Doe", "987-654-3210", "jane.doe@example.com");

            assertNotEquals(customer1.hashCode(), customer2.hashCode()); // Должны иметь разные хэш-коды
        }

        @Test
        public void testToString() {
            Customer customer = new Customer(1, "John Doe", "123-456-7890", "john.doe@example.com");

            assertEquals("Customer{id=1, name='John Doe', phone='123-456-7890', email='john.doe@example.com'}", customer.toString());
        }
}