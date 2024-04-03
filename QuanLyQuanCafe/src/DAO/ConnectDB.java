/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Duong Duy
 */
public class ConnectDB {

    static Connection con;

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        ConnectDB.con = con;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String passWord = "123456";
        try{
            Class.forName(driver);
        }catch(Exception e){
            e.printStackTrace();
        }
        String databaseName = "QUAN_LY_QUAN_CAFE";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;
        try {
             con = DriverManager.getConnection(url,userName,passWord);  
             System.out.println(con);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("nỗi kết nối CSDL");
        }
        return con;
    }

   

    public static void close() {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi rồi anh", "Thông báo", 2);

        }
        return rs;
    }

    public static int executeUpdate(String sql) {
        int i = -1;
        try {

            Statement stm = con.createStatement();
            i = stm.executeUpdate(sql);
        } catch (Exception e) {
        }
        return i;
    }
}
