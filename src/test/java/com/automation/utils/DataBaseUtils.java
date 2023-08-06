package com.automation.utils;

import java.sql.*;

public class DataBaseUtils {

    private static Connection con;
    private static Statement stmt;
    private static ResultSet res;

    private static final String host = ConfigFileReaderUtils.getProperty("db.host");
    private static final String userName = ConfigFileReaderUtils.getProperty("db.username");
    private static final String password = ConfigFileReaderUtils.getProperty("db.password");

    public static void initDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(host, userName, password);
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static ResultSet executeQuery(String query) {
        try {
            res = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return res;
    }

    public static void closeDatabase () {
        try {
            con.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
