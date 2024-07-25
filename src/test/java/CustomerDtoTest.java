import com.zharnikova.example.dto.CustomerDto;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

public class CustomerDtoTest {
    @Test
    public void testConstructorWithId() {
        // Подготовка тестовых данных
        int id = 1;
        String name = "John Doe";
        String phone = "123-456-7890";
        String email = "john.doe@example.com";

        // Создание мок-объекта
        CustomerDto customerDto = new CustomerDto(id, name, phone, email);

        // Проверка результатов
        assertEquals(id, customerDto.getId());
        assertEquals(name, customerDto.getName());
        assertEquals(phone, customerDto.getPhone());
        assertEquals(email, customerDto.getEmail());
    }

    @Test
    public void testConstructorWithoutId() {
        // Подготовка тестовых данных
        String name = "John Doe";
        String phone = "123-456-7890";
        String email = "john.doe@example.com";

        // Создание мок-объекта
        CustomerDto customerDto = new CustomerDto(name, phone, email);

        // Проверка результатов
        assertEquals(0, customerDto.getId());
        assertEquals(name, customerDto.getName());
        assertEquals(phone, customerDto.getPhone());
        assertEquals(email, customerDto.getEmail());
    }
    @Test
    public void testEquals() {
        // Подготовка тестовых данных
        CustomerDto customerDto1 = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");
        CustomerDto customerDto2 = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");
        CustomerDto customerDto3 = new CustomerDto(2, "Jane Doe", "234-567-8901", "jane.doe@example.com");

        // Тестирование равенства
        assertThat(customerDto1).isEqualTo(customerDto2);
        assertThat(customerDto1).isNotEqualTo(customerDto3);
    }

    @Test
    public void testHashCode() {
        // Подготовка тестовых данных
        CustomerDto customerDto1 = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");
        CustomerDto customerDto2 = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");
        CustomerDto customerDto3 = new CustomerDto(2, "Jane Doe", "234-567-8901", "jane.doe@example.com");

        // Тестирование равенства хэш-кодов
        assertThat(customerDto1.hashCode()).isEqualTo(customerDto2.hashCode());
        assertThat(customerDto1.hashCode()).isNotEqualTo(customerDto3.hashCode());
    }

    @Test
    public void testToString() {
        // Подготовка тестовых данных
        CustomerDto customerDto = new CustomerDto(1, "John Doe", "123-456-7890", "john.doe@example.com");

        // Тестирование метода toString
        assertThat(customerDto.toString()).isEqualTo("CustomerDto{id=1, name='John Doe', phone='123-456-7890', email='john.doe@example.com'}");
    }

}
