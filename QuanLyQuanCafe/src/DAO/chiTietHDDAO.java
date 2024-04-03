/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Duong Duy
 */
public class chiTietHDDAO {

    public static ArrayList<chiTietHD> getdsCTHD() {
        ArrayList<chiTietHD> ds = new ArrayList<>();
        try {
            ConnectDB.getConnection();
            String sql = "select *from CHITIETHD";
            ResultSet rs = ConnectDB.executeQuery(sql);
            while (rs.next()) {
                ds.add(new chiTietHD(rs.getString("MAHD").trim(), rs.getString("MANUOCUONG").trim(), rs.getInt("SOLUONG"), rs.getFloat("dongia"), rs.getFloat("THANHTIEN")));
            }
        } catch (Exception e) {
        }
        ConnectDB.close();
        return ds;
    }
    public static void insert(String mahd, String manuoc, int soluong, float dongia, float thanhTien) {
        try {
            ConnectDB.getConnection();
            String sql = "insert chitiethd values(?,?,?,?,?)";
            PreparedStatement pre = ConnectDB.con.prepareStatement(sql);
            pre.setString(1, mahd);
            pre.setString(2, manuoc);
            pre.setInt(3, soluong);
            pre.setFloat(4, dongia);
            pre.setFloat(5, thanhTien);
            pre.executeUpdate();
            pre.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        ConnectDB.close();
    }  
    public static ArrayList<chiTietHD> timKiem(String tuKhoa) {
        ArrayList<chiTietHD> ds = new ArrayList<>();
        for (chiTietHD ct : getdsCTHD()) {
            if (ct.getMaHD().toUpperCase().trim().equals(tuKhoa.trim().toUpperCase())
                ||nuocUongDAO.timTenNuocTheoMa(ct.getMaNuocUong().trim().toUpperCase()).trim().toUpperCase().contains(tuKhoa.trim().toUpperCase())){
                ds.add(ct);
            }
        }
        return ds;
    }   
    public static ArrayList<chiTietHD> timKiem(String tuKhoa,String mahd) {
        ArrayList<chiTietHD> ds = new ArrayList<>();
        for (chiTietHD ct : getdsCTHD()) {
            if (ct.getMaHD().toUpperCase().trim().equals(mahd.trim().toUpperCase())
                &&nuocUongDAO.timTenNuocTheoMa(ct.getMaNuocUong().trim().toUpperCase()).trim().toUpperCase().contains(tuKhoa.trim().toUpperCase())){
                ds.add(ct);
            }
        }
        return ds;
    }   
}