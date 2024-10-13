package main;

import org.junit.Test;
import top.mryan2005.managesysteminjava.SQLLinker;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SQLLinkerTest {

    @Test
    public void TestMethodOne() throws SQLException, ClassNotFoundException {
        SQLLinker mysql = new SQLLinker("MySQL", "127.0.0.1", "3800", "root", "123456", "testDatabase");
        assertTrue(mysql.testConnection());
    }
}
