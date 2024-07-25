import com.zharnikova.example.dto.CustomerDto;
import com.zharnikova.example.model.Customer;
import com.zharnikova.example.service.CustomerService;
import com.zharnikova.example.servlet.CustomerServlet;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class CustomerServletTest  {

    @Test
    public void testAddCustomer() throws Exception {
        // Инициализация сервлета и сервиса
        CustomerServlet servlet = new CustomerServlet();
        CustomerService service = new CustomerService();

        // Подготовка запроса
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Установка параметров запроса
        request.getParameter("name"); // Имя клиента
        request.getParameter("phone"); // Телефон клиента
        request.getParameter("email"); // Электронная почта клиента

        // Вызов метода doPost
        servlet.doPost(request, response);

        // Проверка результата
        assertEquals(1, service.getAll().size());
        CustomerDto customer = service.getAll().get(0);
        assertEquals("name", customer.getName());
        assertEquals("phone", customer.getPhone());
        assertEquals("email", customer.getEmail());
    }
}


