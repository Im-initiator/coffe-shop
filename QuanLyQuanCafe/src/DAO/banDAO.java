/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.ban;
import POJO.nhanVien;
//import com.sun.jmx.snmp.internal.SnmpTools;
import java.sql.ResultSet;
import java.util.ArrayList;
//import sun.security.rsa.RSASignature;

/**
 *
 * @author Duong Duy
 */
public class banDAO {

    public static ArrayList<ban> getdsban() {
        ArrayList<ban> ds = new ArrayList<>();
        try {
            ConnectDB.getConnection();
            String sql = "SELECT * FROM ban " +
             "ORDER BY CAST(SUBSTRING(RTRIM(maban), 2, LENGTH(RTRIM(maban))) AS UNSIGNED)";
            ResultSet rs = ConnectDB.executeQuery(sql);
            while (rs.next()) {
                ds.add(new ban(rs.getString("MABAN").trim(), rs.getString("TENBAN").trim(), Integer.parseInt(rs.getString("TINHTRANG").trim())));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi ban");
        }
        ConnectDB.close();
        return ds;
    }

    public static String layTenBanTheoMa(String ma) {
        String tenBan = "";
        try {
            for (ban b : getdsban()) {
                if (b.getMaBan().equals(ma.trim())) {
                    tenBan = b.getTenBan().trim();
                    break;
                }
            }
        } catch (Exception e) {
        }
        return tenBan;
    }

    public static int layTinhTrangTheoMa(String maBan) {
        int i = 0;
        for (ban b : getdsban()) 
            if (b.getMaBan().trim().equals(maBan.trim())) {
                i = b.getTinhTrang();
                break;                  
            }
        return i;
    }

    public static int updateTinhTrang(String maBan, boolean isStatus) {
        int i = -1;
        int tinhTrang = 0;
        if (isStatus) {
            tinhTrang = 1;
        }
        String sql = "update ban set tinhtrang=" + tinhTrang + " where maban='" + maBan + "'";
        try {
            ConnectDB.getConnection();
            i = ConnectDB.executeUpdate(sql);
        } catch (Exception e) {
        }
        ConnectDB.close();
        return i;
    }

    public static int updateTinhTrang() {
        int i = -1;

        String sql = "update ban set tinhtrang=0";
        try {
            ConnectDB.getConnection();
            i = ConnectDB.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ConnectDB.close();
        return i;
    }
    
    public static String layMaTheoTen(String tenBan)
    {
        String maBan="";
        for(ban b:getdsban())
        {
            if(b.getTenBan().trim().toUpperCase().equals(tenBan.trim().toUpperCase()))
            {
                maBan=b.getMaBan();
                break;
            }
        }
        return maBan;
    }
}
