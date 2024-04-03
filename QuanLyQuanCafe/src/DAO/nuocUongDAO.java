/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.loaiNuocDAO.getdsLoaiNuoc;
import POJO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Duong Duy
 */
public class nuocUongDAO {

    public static ArrayList<nuocUong> getdsNuocUong() {
        ArrayList<nuocUong> ds = new ArrayList<>();
        try {
            ConnectDB.getConnection();
            String sql = "select *from nuocUong";
            ResultSet rs = ConnectDB.executeQuery(sql);
            while (rs.next()) {
                ds.add(new nuocUong(rs.getString("MANUOCUONG").trim(), rs.getString("TENNUOCUONG").trim(), rs.getString("MALOAINUOC").trim(), rs.getFloat("DONGIA")));
            }
        } catch (Exception e) {
        }
        ConnectDB.close();
        return ds;
    }

    public static String timTenNuocTheoMa(String ma) {
        String tenNuoc = "";
        for (nuocUong n : getdsNuocUong()) {
            if (n.getMaNuoc().trim().toUpperCase().equals(ma.toUpperCase().trim())) {
                tenNuoc = n.getTenNuoc().trim().toUpperCase();
                break;
            }
        }
        return tenNuoc;
    }

    public static Vector timTenNuocHD(String tenNuoc, int soLuong) {
        Vector r = new Vector();
        try {
            for (nuocUong n : getdsNuocUong()) {
                if (n.getTenNuoc().equals(tenNuoc)) {
                    r.add(n.getMaNuoc());
                    r.add(tenNuoc);
                    r.add(n.getDonGia());
                    r.add(soLuong);
                    r.add(soLuong * n.getDonGia());
                    return r;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<nuocUong> dsNuocTheoTenLoaiNuoc(String tenLoai) {
        ArrayList<nuocUong> ds1 = new ArrayList<>();
        String sql = "select nuocuong.* from nuocuong,loainuoc where nuocuong.maloainuoc=loainuoc.maloainuoc and tenloainuoc=N'" + tenLoai + "'";
        try {
            ConnectDB.getConnection();
            ResultSet rs = ConnectDB.executeQuery(sql);
            while (rs.next()) {
                ds1.add(new nuocUong(rs.getString("MANUOCUONG").trim(), rs.getString("TENNUOCUONG").trim(), rs.getString("MALOAINUOC").trim(), rs.getFloat("DONGIA")));
            }
        } catch (Exception e) {
        }
        ConnectDB.close();
        return ds1;
    }

    public static int themNuocUong(String maNuoc, String tenNuoc, String maLoai, float donGia) {
        int i = -1;
        String sql = "insert into nuocuong values(?,?,?,?)";
        try {
            ConnectDB.getConnection();
            PreparedStatement pre = ConnectDB.con.prepareStatement(sql);
            pre.setString(1, maNuoc);
            pre.setString(2, tenNuoc);
            pre.setString(3, maLoai);
            pre.setFloat(4, donGia);
            i = pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi", "Thông báo", 1);
        }
        ConnectDB.close();
        return i;
    }

    public static int xoaNuocUong(String maNuoc)  {
        int i = -1;
        String sql = "delete nuocuong where manuocuong='" + maNuoc + "'";

        try {
            ConnectDB.getConnection();
            i = ConnectDB.executeUpdate(sql);
        } catch (Exception e) {            
        }
        ConnectDB.close();
        return i;
    }

    public static int updateNuocUong(String maNuoc, String tenNuoc, String maLoai, float donGia) {
        int i = -1;
        System.out.println(maLoai);
        String sql = "update nuocuong set tenNuocUong=?,maLoaiNuoc=?,DONGIA=? where maNuocUong=?";
        try {
            ConnectDB.getConnection();
            PreparedStatement pre = ConnectDB.con.prepareStatement(sql);
            pre.setString(4, maNuoc);
            pre.setString(1, tenNuoc);
            pre.setString(2, maLoai);
            pre.setFloat(3, donGia);
            i = pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi", "Thông báo", 1);
        }
        return i;
    }

    public static String timMaNuoc(String tenNuoc) {
        for (nuocUong n : getdsNuocUong()) {
            if (n.getTenNuoc().equals(tenNuoc)) {
                return n.getMaNuoc();
            }
        }
        return "";
    }

    public static ArrayList<nuocUong> layTTNuoc(String maLoai) {
        ArrayList<nuocUong> ds = new ArrayList<>();
        for (nuocUong kh : getdsNuocUong()) {
            if (kh.getMaLoaiNuoc().trim().toUpperCase().equals(maLoai.trim().toUpperCase())) {
                ds.add(kh);
            }
        }
        return ds;
    }

    public static nuocUong layTTNuoc(String maLoai, String makh) {
        nuocUong n1 = null;
        for (nuocUong n : getdsNuocUong()) {
            if (n.getMaLoaiNuoc().trim().toUpperCase().equals(maLoai.trim().toUpperCase())
                    && n.getMaNuoc().trim().toUpperCase().equals(makh.trim().toUpperCase())) {
                n1 = n;
                break;
            }
        }
        return n1;
    }
}
