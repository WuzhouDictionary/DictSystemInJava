import org.junit.jupiter.api.Test;
import top.mryan2005.managesysteminjava.SQLs.MySQL;

import static org.junit.Assert.assertTrue;

public class SQLLinkerTest {
    @Test public void testMethodOne() {
        MySQL sql = new MySQL();
        assertTrue(sql.testConnection("127.0.0.1", "3307", "root", "123456", "testDatabase"));
    }
}