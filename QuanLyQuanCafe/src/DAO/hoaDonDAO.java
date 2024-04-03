/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.vm.ci.meta.Local;
import java.time.LocalDateTime;


/**
 *
 * @author Duong Duy
 */
public class hoaDonDAO {

    public static ArrayList<hoaDon> getDSHD() {
        ArrayList<hoaDon> ds = new ArrayList<>();
        try {
            ConnectDB.getConnection();
            String sql = "select * from hoaDon";
            ResultSet rs = ConnectDB.executeQuery(sql);
            while (rs.next()) {
                ds.add(new hoaDon(rs.getString("MAHD").trim(), rs.getDate("NGAYRAHD"), rs.getString("MANV").trim(), rs.getFloat("THANHTOAN"), rs.getFloat("giamgia"), rs.getString("maban")));
            }
        } catch (Exception e) {
        }
        ConnectDB.close();
        return ds;
    }

    public static int insert(String mahd, float thanhToan, String manv, float giamGia, String maban) {
        int i = -1;
        String sql = "insert into hoadon values(?,?,?,?,?,?)";
        try {
//            LocalDateTime  localDate = LocalDateTime .now();
//            DateTimeFormatter fomat = DateTimeFormatter.ofPattern("dd/mm/yyyy");
//            String fomatDate = localDate.format(fomat);
//            java.sql.Date date = java.sql.Date.valueOf(fomatDate);

            Date currentDate = new Date();

            // Chuyển đổi java.util.Date thành java.sql.Date
            java.sql.Date date = new java.sql.Date(currentDate.getTime());
            PreparedStatement pre = ConnectDB.getConnection().prepareStatement(sql);
            
            pre.setString(1, mahd);
            pre.setDate(2,date);
            pre.setFloat(3, thanhToan);
            pre.setString(4, manv);
            pre.setFloat(5, giamGia);
            pre.setString(6, maban);
            i = pre.executeUpdate();
            pre.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Trùng mã hoá đơn", "Thông báo", 1);
        }
        ConnectDB.close();

        return i;
    }

    public static int xoaHD(String mahd) {
        int i = -1;
        String sql = "delete hoadon where mahd='" + mahd + "'";
        try {
            ConnectDB.getConnection();
            i = ConnectDB.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi", "Thông báo", 1);
        }
        ConnectDB.close();
        return i;
    }

    public static ArrayList<hoaDon> timKiem(String tuKhoa) {
        ArrayList<hoaDon> ds = new ArrayList();
        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyy");
        Date date=null;
        boolean check=true;
        try {
            date=df.parse(tuKhoa);
        } catch (Exception e) {
            check=false;
        }
        for (hoaDon hd : getDSHD()) {
            if(check&&hd.getNgayRaHD().compareTo(date)==0)
                ds.add(hd);
            else                
            if(hd.getMahd().toUpperCase().equals(tuKhoa.trim().toUpperCase())
               ||hd.getMaBan().toUpperCase().trim().equals(banDAO.layMaTheoTen(tuKhoa).trim())               
               ||nhanVienDAO.timTenNVTheoMa(hd.getManv()).trim().toUpperCase().contains(tuKhoa.trim().toUpperCase()))
                ds.add(hd);
        }
        return ds;
    }
}
