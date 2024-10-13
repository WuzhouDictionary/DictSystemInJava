import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static top.mryan2005.managesysteminjava.SQLs.MySQL.testConnection;

public class TestSQLLinker {
    @Test
    public void testMySQLLinker() {
        assertTrue(testConnection("127.0.0.1", "3307", "root", "123456", "testDatabase"));
    }
}
