/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.*;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Duong Duy
 */
public class quanTriADO {
    public static ArrayList<quanTri> getdsQuanTri() {
        ArrayList<quanTri> ds = new ArrayList<>();
        try {
            ConnectDB.getConnection();
            String sql = "select *from quanTri";
            ResultSet rs = ConnectDB.executeQuery(sql);
            while (rs.next()) {
                ds.add(new quanTri(rs.getString("tentk").trim(),rs.getString("matkhau").trim()));
            }
        } catch (Exception e) {
        }
        ConnectDB.close();
        return ds;
    }
    public static boolean dangNhap(String tentk,String matKhau)
    {
        for(quanTri qt:getdsQuanTri())
            if(qt.getTenTk().equals(tentk)&&qt.getMatKhau().equals(matKhau))
                return true;
        return false;
    }
}
