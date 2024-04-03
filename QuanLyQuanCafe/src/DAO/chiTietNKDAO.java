/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.chiTietHDDAO.getdsCTHD;
import POJO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Duong Duy
 */
public class chiTietNKDAO {

    public static ArrayList<chiTietNK> getdsCTNK() {
        ArrayList<chiTietNK> ds = new ArrayList<>();
        try {
            ConnectDB.getConnection();
            String sql = "select *from chiTietNK";
            ResultSet rs = ConnectDB.executeQuery(sql);
            while (rs.next()) {
                System.out.println("khihihi");
                ds.add(new chiTietNK(rs.getString("MANHAP").trim(), rs.getString("manuocuong").trim(), rs.getInt("SOLUONG"), rs.getFloat("GIANHAP"), rs.getFloat("thanhtien")));
            }
        } catch (Exception e) {
        }
        ConnectDB.close();
        return ds;
    }

    public static ArrayList<chiTietNK> timKiem(String tuKhoa) {
        ArrayList<chiTietNK> ds = new ArrayList<>();
        for (chiTietNK ct : getdsCTNK()) {
            if (ct.getMaNhap().toUpperCase().trim().equals(tuKhoa.trim().toUpperCase())
                    || nuocUongDAO.timTenNuocTheoMa(ct.getMaNuoc().trim().toUpperCase()).trim().toUpperCase().contains(tuKhoa.trim().toUpperCase())) {
                ds.add(ct);
            }
        }
        return ds;
    }

    public static ArrayList<chiTietNK> timKiem(String tuKhoa,String maNhap) {
        ArrayList<chiTietNK> ds = new ArrayList<>();
        for (chiTietNK ct : getdsCTNK()) {
            if (ct.getMaNhap().toUpperCase().trim().equals(maNhap.trim().toUpperCase())
                    && nuocUongDAO.timTenNuocTheoMa(ct.getMaNuoc().trim().toUpperCase()).trim().toUpperCase().contains(tuKhoa.trim().toUpperCase())) {
                ds.add(ct);
            }
        }
        return ds;
    }

    public static int insert(String maNhap, String maNuoc, int soLuong, float giaNhap, float thanhTien) {
        int i = -1;
        String sql = "insert into chitietnk values(?,?,?,?,?)";
        try {
            ConnectDB.getConnection();
            PreparedStatement pre = ConnectDB.con.prepareStatement(sql);
            pre.setString(1, maNhap);
            pre.setString(2, maNuoc);
            pre.setInt(3, soLuong);
            pre.setFloat(4, giaNhap);
            pre.setFloat(5, thanhTien);
            i = pre.executeUpdate();
        } catch (Exception e) {
        }
        ConnectDB.close();
        return i;
    }

}
