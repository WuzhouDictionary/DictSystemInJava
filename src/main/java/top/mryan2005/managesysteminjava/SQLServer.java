package top.mryan2005.managesysteminjava;

import java.sql.*;
import java.util.Properties;

public class SQLServer {
    private String username, password, databaseName, ip, port, connectionUrl;
    private Connection con;

    public SQLServer(String ip, String port, String username, String password, String databaseName) throws SQLException {
        this.username = username;
        this.password = password;
        this.databaseName = databaseName;
        this.ip = ip;
        this.port = port;
        connectionUrl = "jdbc:sqlserver://"+ip+":"+port+";databaseName="+databaseName+";user="+username+";password="+password+";encrypt=false;";
        con = DriverManager.getConnection(connectionUrl);
    }

    public static void main(String args[]) throws SQLException {
        try {
            SQLServer sql = new SQLServer("127.0.0.1", "1433", "sa", "A123456", "abc");
            System.out.println("连接成功！");
        } catch (SQLException e) {
            System.out.println("连接数据库时发生错误！");
            System.out.println(e);
        }
    }
}