package top.mryan2005.managesysteminjava;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import top.mryan2005.managesysteminjava.SQLs.MySQL;

public class TestSQLLinker {
    @Test
    public void testMySQLLinker() {
        assertTrue(MySQL.testConnection("127.0.0.1", "3307", "root", "123456", "testDatabase"));
    }
}
