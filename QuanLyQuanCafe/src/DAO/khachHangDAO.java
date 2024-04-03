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
public class khachHangDAO {

    public static ArrayList<khachHang> getdsKH() {
        ArrayList<khachHang> ds = new ArrayList<>();
        try {
            ConnectDB.getConnection();
            String sql = "select *from khachHang";
            ResultSet rs = ConnectDB.executeQuery(sql);
            while (rs.next()) {
                ds.add(new khachHang(rs.getString("MAKH").trim(), rs.getString("TENKH".trim()), rs.getString("GIOITINH").trim(), rs.getString("DIACHI").trim(), rs.getString("SDT").trim(), rs.getString("MALOAIKH").trim()));
            }
        } catch (Exception e) {
        }
        ConnectDB.close();
        return ds;
    }

    public static ArrayList<khachHang> layTTKH(String maLoai) {
        ArrayList<khachHang> ds = new ArrayList<>();
        for (khachHang kh : getdsKH()) {
            if (kh.getMaLoaiKH().trim().toUpperCase().equals(maLoai.trim().toUpperCase())) {
                ds.add(kh);
            }
        }
        return ds;
    }

    public static khachHang layTTKH(String maLoai, String makh) {
        khachHang kh1 = null;
        for (khachHang kh : getdsKH()) {
            if (kh.getMaLoaiKH().trim().toUpperCase().equals(maLoai.trim().toUpperCase())
                    && kh.getMakh().trim().toUpperCase().equals(makh.trim().toUpperCase())) {
                kh1 = kh;
                break;
            }
        }
        return kh1;
    }

    public static int xoaKH(String makh) {
        int i = -1;
        String sql = "delete khachHang where makh='" + makh + "'";
        try {
            ConnectDB.getConnection();
            i = ConnectDB.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi", "Thông báo", 1);
        }
        ConnectDB.close();
        return i;
    }

    public static int themKH(String makh, String tenkh, String gioiTinh, String diaChi, String sdt, String maLoaiKH) {
        int i = -1;
        String sql = "insert into khachhang values(?,?,?,?,?,?)";
        try {
            ConnectDB.getConnection();
            PreparedStatement pre = ConnectDB.con.prepareStatement(sql);
            pre.setString(1, makh);
            pre.setString(2, tenkh);
            pre.setString(3, gioiTinh);
            pre.setString(4, diaChi);
            pre.setString(5, sdt);
            pre.setString(6, maLoaiKH);
            i = pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi", "Thông báo", 1);

        }
        ConnectDB.close();
        return i;
    }

    public static int suaKH(String makh, String tenkh, String gioiTinh, String diaChi, String sdt, String maLoaiKH) {
        int i = -1;
        String sql = "update khachhang set tenkh=?,gioitinh=?,diachi=?,sdt=?,maloaikh=? where makh=?";
        try {
            ConnectDB.getConnection();
            PreparedStatement pre = ConnectDB.con.prepareStatement(sql);
            pre.setString(6, makh);
            pre.setString(1, tenkh);
            pre.setString(2, gioiTinh);
            pre.setString(3, diaChi);
            pre.setString(4, sdt);
            pre.setString(5, maLoaiKH);
            i = pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi", "Thông báo", 1);

        }
        ConnectDB.close();
        return i;
    }

    public static ResultSet timTTKH(String makh) {
        String sql = "select *from khachHang,loaiKh where khachhang.maloaikh=loaikh.maloaikh and makh=?";
        ResultSet rs = null;
        try {
            ConnectDB.getConnection();
            PreparedStatement pre = ConnectDB.getCon().prepareStatement(sql);
            pre.setString(1, makh);
            rs = pre.executeQuery();
        } catch (Exception ex) {

        }
        return rs;
    }
}
