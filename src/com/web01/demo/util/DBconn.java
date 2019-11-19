package com.web01.demo.util;

import java.sql.*;

public class DBconn {
    static String driverClassName= "com.mysql.cj.jdbc.Driver";
    //static String url = "jdbc:mysql://localhost:3306/demo?useunicuee=true&characterEncoding=utf8";
    //static String url = "jdbc:mysql://localhost:3306/test";
    static String url= "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
    static String username = "root";
    static String password = "root";
    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;
    public static void init(){
        try {
            Class.forName(driverClassName);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("DBConn.init - SQL driver initialization failed!");
            e.printStackTrace();
        }
    }
    public static int executeSql(String sql){
        int i = 0;
        try {
            PreparedStatement ps =  conn.prepareStatement(sql);
            i =  ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql execute failed!");
            e.printStackTrace();
        }
        return i;
    }
    public static ResultSet selectSql(String sql){
        try {
            System.out.println(sql);
            ps =  conn.prepareStatement(sql);
            rs =  ps.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("sql select failed!");
            e.printStackTrace();
        }
        return rs;
    }
    public static void closeConn(){
        try {
            conn.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("sql connection close failed!");
            e.printStackTrace();
        }
    }
}
