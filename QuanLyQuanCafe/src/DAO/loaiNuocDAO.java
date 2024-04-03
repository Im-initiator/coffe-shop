/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.loaiKHDAO.getdsLoaiKH;
import POJO.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Duong Duy
 */
public class loaiNuocDAO {

    public static ArrayList<loaiNuoc> getdsLoaiNuoc() {
        ArrayList<loaiNuoc> ds = new ArrayList<>();
        try {
            ConnectDB.getConnection();
            String sql = "select *from loaiNuoc";
            ResultSet rs = ConnectDB.executeQuery(sql);
            while (rs.next()) {
                ds.add(new loaiNuoc(rs.getString("MALOAINUOC").trim(), rs.getString("TENLOAINUOC").trim()));
            }
        } catch (Exception e) {
        }
        ConnectDB.close();
        return ds;
    }

    public static int xoaLN(String maLoai) {
        String sql = "delete loainuoc where maloainuoc='" + maLoai + "'";
        System.out.println(sql);
        int i = -1;
        try {
            ConnectDB.getConnection();
            i = ConnectDB.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ConnectDB.close();
        return i;
    }

    public static int updateLN(String maloai, String tenLoai) {
        int i = -1;
        String sql = "update loainuoc set tenloainuoc=N'" + tenLoai + "' where maloainuoc='" + maloai + "'";
        try {
            ConnectDB.getConnection();
            i = ConnectDB.executeUpdate(sql);
        } catch (Exception e) {
        }
        ConnectDB.close();
        return i;
    }

    public static int themLN(String maloai, String tenLoai) {
        int i = -1;
        String sql = "insert into loainuoc values('" + maloai + "',N'" + tenLoai + "')";
        try {
            ConnectDB.getConnection();
            i = ConnectDB.executeUpdate(sql);
        } catch (Exception e) {
        }
        ConnectDB.close();
        return i;
    }

    public static loaiNuoc timLoaiNuoc(String tuKhoa) {
        loaiNuoc ln1 = null;
        for (loaiNuoc ln : getdsLoaiNuoc()) {
            if (ln.getMaLoaiNuoc().toUpperCase().trim().equals(tuKhoa.toUpperCase().trim())
                    || ln.getTenLoaiNuoc().toUpperCase().trim().equals(tuKhoa.toUpperCase().trim())) {
                ln1 = ln;
                break;
            }
        }
        return ln1;
    }

    public static int xoaLN() {
        int i = -1;
        String sql = "delete loainuoc";
        try {
            ConnectDB.getConnection();
            i = ConnectDB.executeUpdate(sql);
        } catch (Exception e) {
        }
        ConnectDB.close();
        return i;
    }
}
