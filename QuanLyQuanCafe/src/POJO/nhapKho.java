/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.Date;

/**
 *
 * @author Duong Duy
 */
public class nhapKho {
    String maNhap,manv;
    float thanhTien;
    Date ngayNhap;

    public nhapKho() {
    }

    public nhapKho(String maNhap, String manv, float thanhTien, Date ngayNhap) {
        this.maNhap = maNhap;
        this.manv = manv;
        this.thanhTien = thanhTien;
        this.ngayNhap = ngayNhap;
    }

    public String getMaNhap() {
        return maNhap;
    }

    public void setMaNhap(String maNhap) {
        this.maNhap = maNhap;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    @Override
    public String toString() {
        return "nhapKho{" + "maNhap=" + maNhap + ", manv=" + manv + ", thanhTien=" + thanhTien + ", ngayNhap=" + ngayNhap + '}';
    }
    
}
