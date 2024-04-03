/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import java.sql.Connection;

/**
 *
 * @author Duong Duy
 */
public class nhanVienDAO {

    public static ArrayList<nhanVien> getdsnv() {
        ArrayList<nhanVien> ds = new ArrayList<>();
        try {
            try {
               ConnectDB.getConnection();
            } catch (Exception e) {
                System.out.println(" Lôi connect ");
            }
            String sql = "select * from nhanvien";
            ResultSet rs = ConnectDB.executeQuery(sql);
            while (rs.next()) {
                ds.add(new nhanVien(rs.getString("MANV").trim(), rs.getString("MATKHAU").trim(), rs.getString("TENNV").trim(), rs.getString("GIOITINH").trim(), rs.getString("DIACHI").trim(), rs.getString("SODT").trim(), rs.getDate("NAMSINH"), rs.getDate("NGAYVL"), rs.getFloat("LUONG")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ConnectDB.close();
        return ds;
    }

    public static String dangNhap(String taikhoan, String matKhau) {
        for (nhanVien nv : getdsnv()) {
            if (nv.getManv().equals(taikhoan) && nv.getMatkhau().equals(matKhau)) {
                return nv.getManv();
            }
        }
        return "";
    }

    public static String timTenNVTheoMa(String manv) {
        for (nhanVien nv : getdsnv()) {
            if (nv.getManv().toUpperCase().equals(manv.trim().toUpperCase())) {
                return nv.getTennv();
            }
        }
        return "";
    }

    public static int doiMatKhau(String manv, String matKhauMoi) {
        String sql = "update nhanvien set matkhau='" + matKhauMoi + "' where manv='" + manv + "'";
        System.out.println(sql);
        int i=-1;
        try {
            ConnectDB.getConnection();
            i=ConnectDB.executeUpdate(sql);
        } catch (Exception e) {
        }
        ConnectDB.close();
        return i;
    }

    public static String timMKTheoMa(String manv) {
        for (nhanVien nv : getdsnv()) {
            if (nv.getManv().equals(manv)) {
                return nv.getMatkhau();
            }
        }
        return "";
    }
    public static int xoa1NhanVien(String manv) {
        int i = -1;
        String sql = "delete nhanvien where manv='" + manv + "'";
        System.out.println(sql);
        try {
            ConnectDB.getConnection();
            i = ConnectDB.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
        ConnectDB.close();
        return i;
    }

    public static int themNV(String manv, String matKhau, String hoTen, String gioiTinh, String diaChi, String namSinh, String ngayVL, String sdt, float luong) {
        int i = -1;
        String sql = "set dateFormat DMY;insert into nhanvien values(?,?,?,?,?,?,?,?,?)";
        try {
            ConnectDB.getConnection();
            PreparedStatement pre = ConnectDB.con.prepareStatement(sql);
            pre.setString(1,manv);
            pre.setString(2,matKhau);
            pre.setString(3,hoTen);
            pre.setString(4,gioiTinh);
            pre.setString(5,diaChi);
            pre.setString(6,namSinh);
            pre.setString(7,ngayVL);
            pre.setString(8,sdt);
            pre.setFloat(9,luong);
            i=pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi","Thông báo",1);
        }
        ConnectDB.close();
        return i;
    }
    public static int suaNV(String manv, String hoTen, String gioiTinh, String diaChi, String namSinh, String ngayVL, String sdt, float luong) {
        int i = -1;
        String sql = "set dateFormat DMY;update nhanvien set tennv=?,gioiTinh=?,diaChi=?,namsinh=?,ngayvl=?,sodt=?,luong=? where manv=?";
        try {
            ConnectDB.getConnection();
            PreparedStatement pre = ConnectDB.con.prepareStatement(sql);
            pre.setString(8,manv);
            pre.setString(1,hoTen);
            pre.setString(2,gioiTinh);
            pre.setString(3,diaChi);
            pre.setString(4,namSinh);
            pre.setString(5,ngayVL);
            pre.setString(6,sdt);
            pre.setFloat(7,luong);
            i=pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi","Thông báo",1);
        }
        ConnectDB.close();
        return i;
    }
    public static int resetPW(String maNV,String matKhau)
    {
        int i=-1;
        String sql="update nhanvien set matkhau='"+matKhau+"' where manv='"+maNV+"'";
        try {
            ConnectDB.getConnection();
            i=ConnectDB.executeUpdate(sql);
        } catch (Exception e) {
        }
        ConnectDB.close();
        return i;
    }
            
}
