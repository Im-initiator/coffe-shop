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
import javax.swing.JOptionPane;

/**
 *
 * @author Duong Duy
 */
public class nhapKhoDAO {

    public static ArrayList<nhapKho> getdsNK() {
        ArrayList<nhapKho> ds = new ArrayList<>();
        try {
            ConnectDB.getConnection();
            String sql = "select *from nhapKho";
            ResultSet rs = ConnectDB.executeQuery(sql);
            while (rs.next()) {
                ds.add(new nhapKho(rs.getString("MANHAP").trim(), rs.getString("MANV").trim(), rs.getFloat("THANHTIEN"), rs.getDate("NGAYNHAP")));
            }
        } catch (Exception e) {
        }
        ConnectDB.close();
        return ds;
    }

    public static int insert(String maNhap, String manv, float thanhTien) {
        int i = -1;
        String sql = "insert into NHAPKHO values(?,getdate(),?,?)";
        try {
            ConnectDB.getConnection();
            PreparedStatement pre = ConnectDB.con.prepareStatement(sql);
            pre.setString(1,maNhap);
            pre.setString(2,manv);
            pre.setFloat(3,thanhTien);
            i=pre.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Trùng mã nhập kho","Thông báo",1);
        }
        ConnectDB.close();
        return i;
    }
    
    public static ArrayList<nhapKho> timKiem(String tuKhoa) {
        ArrayList<nhapKho> ds = new ArrayList();
        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyy");
        Date date=null;
        boolean check=true;
        try {
            date=df.parse(tuKhoa);
        } catch (Exception e) {
            check=false;
        }
        for (nhapKho nk : getdsNK()) {
            if(check&&nk.getNgayNhap().compareTo(date)==0)
                ds.add(nk);
            else                
            if(nk.getMaNhap().toUpperCase().equals(tuKhoa.trim().toUpperCase())               
               ||nhanVienDAO.timTenNVTheoMa(nk.getManv()).trim().toUpperCase().contains(tuKhoa.trim().toUpperCase()))
                ds.add(nk);
        }
        return ds;
    }
     public static int xoaPN(String maNhap) {
        int i=-1;
        String sql="delete nhapkho where manhap='"+maNhap+"'";
        try {
            ConnectDB.getConnection();
            i=ConnectDB.executeUpdate(sql);            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi","Thông báo",1);
        }
        ConnectDB.close();
        return i;
    }
}
