package top.mryan2005.managesysteminjava;

import top.mryan2005.managesysteminjava.SQLs.SQLServer;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLLinker {
    private Connection con;
    private String type;
    public SQLLinker(String type, String ip, String port, String username, String password, String databaseName) {
        this.type = type;
        if(type == "SQL Server") {
            try {
                SQLServer sql = new SQLServer("127.0.0.1", "1433", "sa", "A123456", "abc");
                System.out.println("连接成功！");
                con = sql.getSQLer();
            } catch (SQLException e) {
                System.out.println("连接数据库时发生错误！");
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addEntry() {
        if(this.type == "SQL Server") {
            try {
                ;
            } finally {

            }
        }
    }
}