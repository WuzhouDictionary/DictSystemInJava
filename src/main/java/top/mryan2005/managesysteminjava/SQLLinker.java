package top.mryan2005.managesysteminjava;

import top.mryan2005.managesysteminjava.BasicClass.Entry;
import top.mryan2005.managesysteminjava.BasicClass.StringProcessed;
import top.mryan2005.managesysteminjava.SQLs.MySQL;
import top.mryan2005.managesysteminjava.SQLs.SQLServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLLinker {
    private Connection con;
    private SQLServer sql;
    private MySQL mysql;
    private String type;
    public SQLLinker(String type, String ip, String port, String username, String password, String databaseName) throws SQLException, ClassNotFoundException {
        this.type = type;
        if("SQL Server".matches(type)) {
            try {
                this.sql = new SQLServer(ip, port, username, password, databaseName);
                System.out.println("Connectted to SQL Server!");
                this.con = this.sql.getSQLer();
            } catch (SQLException e) {
                System.out.println("Connectting to SQL Server failed!");
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                System.out.println("Connectting to SQL Server failed!");
                throw new RuntimeException(e);
            }
        } else if("MySQL".matches(type)) {
            try {
                this.mysql = new MySQL(ip, port, username, password, databaseName);
                this.con = this.mysql.getSQLer();
                System.out.println("Connectted to MySQL!");
            } catch (SQLException e) {
                System.out.println("Connectting to MySQL failed!");
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                System.out.println("Connectting to MySQL failed!");
                throw new RuntimeException(e);
            }
        }
    }

    public SQLLinker(String type, String ip, String port, String username, String password) throws SQLException, ClassNotFoundException {
        this.type = type;
        if("SQL Server".matches(type)) {
            try {
                this.sql = new SQLServer(ip, port, username, password);
                System.out.println("Connectted to SQL Server!");
                this.con = this.sql.getSQLer();
            } catch (SQLException e) {
                System.out.println("Connectting to SQL Server failed!");
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if("MySQL".matches(type)) {
            try {
                this.mysql = new MySQL(ip, port, username, password);
                this.con = this.mysql.getSQLer();
                System.out.println("Connectted to MySQL!");
            } catch (SQLException e) {
                System.out.println("Connectting to MySQL failed!");
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean testConnection() {
        if(this.con != null) {
            return true;
        } else {
            return false;
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

    public boolean closeConnection() throws SQLException {
        this.con.close();
        return true;
    }

    public List<Entry> FindSomeThings(String query) throws SQLException {
        Statement stmt = this.con.createStatement();
        query = "SELECT * FROM aPart";
        ResultSet res = stmt.executeQuery(query);
        List<Entry> list = new ArrayList<>();
        while(res.next()) {
            Entry entry = new Entry();
            entry.id = res.getInt(1);
            entry.Radical_traditional = new StringProcessed(res.getString("Radical_traditional"));
            entry.Radical_simple = new StringProcessed(res.getString("Radical_simple"));
            entry.total_number_of_strokes_simplified = res.getInt("total_number_of_strokes_simplified");
            entry.total_number_of_strokes_traditional = res.getInt("total_number_of_strokes_traditional");
            entry.total_number_of_radical_strokes_simplified = res.getInt("total_number_of_radical_strokes_simplified");
            entry.total_number_of_radical_strokes_traditional = res.getInt("total_number_of_radical_strokes_traditional");
            entry.Pronunciation_of_Wuzhou = new StringProcessed(res.getString("Pronunciation_of_Wuzhou"));
            entry.Pronunciation_of_Mengshan = new StringProcessed(res.getString("Pronunciation_of_Mengshan"));
            entry.Pronunciation_of_Cangwu_Shiqiao = new StringProcessed(res.getString("Pronunciation_of_Cangwu_Shiqiao"));
            entry.Heterozygous_Ancient_Texts_of_the_Same_Type = new StringProcessed(res.getString("Heterozygous_Ancient_Texts_of_the_Same_Type"));
            entry.simplified_Chinese_character = new StringProcessed(res.getString("simplified_Chinese_character"));
            entry.traditional_Chinese_character = new StringProcessed(res.getString("traditional_Chinese_character"));
            list.add(entry);
        }
        return list;
    }
}
