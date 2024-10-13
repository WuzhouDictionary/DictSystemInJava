import org.junit.Test;
import top.mryan2005.managesysteminjava.SQLs.MySQL;

import static org.junit.Assert.assertTrue;

public class TestSQLLinker {
    @Test
    public void testMySQLLinker() {
        MySQL sql = new MySQL();
        assertTrue(sql.testConnection("127.0.0.1", "3307", "root", "123456", "testDatabase"));
    }
}
