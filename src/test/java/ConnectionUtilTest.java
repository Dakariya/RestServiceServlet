import com.zharnikova.example.ConnectionUtil;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConnectionUtilTest {
    @Test
    public void testInstance() {
        ConnectionUtil connectionUtil = new ConnectionUtil();
        Connection connection = connectionUtil.instance();

        assertNotNull(connection);
    }
}