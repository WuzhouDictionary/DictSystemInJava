package top.mryan2005.managesysteminjava;

import java.sql.*;
import java.util.Properties;

public class SQLServer {
    private String username, password, databaseName, connectionUrl;
    private Connection con;

    public SQLServer(String username, String password, String databaseName) throws SQLException {
        connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName="+databaseName+";user="+username+";password="+password+";encrypt=false;";
        con = DriverManager.getConnection(connectionUrl);
    }

    public static void main(String args[]) throws SQLException {
        try {
            SQLServer sql = new SQLServer("sa", "A123456", "abc");
            System.out.println("连接成功！");
        } catch (SQLException e) {
            System.out.println("连接数据库时发生错误！");
            System.out.println(e);
        }
    }
}
