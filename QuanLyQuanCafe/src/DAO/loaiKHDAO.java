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
public class loaiKHDAO {

    public static ArrayList<loaiKH> getdsLoaiKH() {
        ArrayList<loaiKH> ds = new ArrayList<>();
        try {
            ConnectDB.getConnection();
            String sql = "select *from loaiKH";
            ResultSet rs = ConnectDB.executeQuery(sql);
            while (rs.next()) {
                ds.add(new loaiKH(rs.getString("MALOAIKH").trim(), rs.getString("TENLOAIKH").trim(), rs.getFloat("GIAMGIA")));
            }
        } catch (Exception e) {
        }
        ConnectDB.close();
        return ds;
    }

    public static int themLoaiKH(String maloai, String tenLoai, float giamGia) {
        int i = -1;
        String sql = "INSERT INTO LOAIKH VALUES(?,?,?)";
        try {
            ConnectDB.getConnection();
            PreparedStatement pre = ConnectDB.con.prepareStatement(sql);
            pre.setString(1, maloai);
            pre.setString(2, tenLoai);
            pre.setFloat(3, giamGia);
            i = pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi thêm loại khách hàng", "Thông báo", 1);
        }
        ConnectDB.close();
        return i;
    }

    public static int xoaLoaiKH(String maloai) {
        int i = -1;
        String sql = "delete loaikh where maloaikh='" + maloai + "'";
        try {
            ConnectDB.getConnection();
            i = ConnectDB.executeUpdate(sql);
        } catch (Exception e) {
        }
        ConnectDB.close();
        return i;
    }
    public static int xoaLoaiKH() {
        int i = -1;
        String sql = "delete loaikh";
        try {
            ConnectDB.getConnection();
            i = ConnectDB.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Lỗi","Thông báo",1);
        }
        ConnectDB.close();
        return i;
    }

    public static int suaLoaiKH(String maloai, String tenLoai, float giamGia) {
        int i = -1;
        String sql = "update loaikh set tenLoaikh=?,giamgia=? where maloaikh=?";
        try {
            ConnectDB.getConnection();
            PreparedStatement pre = ConnectDB.con.prepareStatement(sql);
            pre.setString(3, maloai);
            pre.setString(1, tenLoai);
            pre.setFloat(2, giamGia);
            i = pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗ", "Thông báo", 1);
        }
        ConnectDB.close();
        return i;
    }

    public static loaiKH timLoaiKH(String tuKhoa) {
        loaiKH lkh1 = null;
        for (loaiKH lkh : getdsLoaiKH()) {
            if (lkh.getMaLoaiKH().toUpperCase().trim().equals(tuKhoa.toUpperCase().trim())
                    || lkh.getTenLoaiKH().toUpperCase().trim().equals(tuKhoa.toUpperCase().trim())) {
                lkh1 = lkh;
                break;
            }
        }
        return lkh1;
    }
}
