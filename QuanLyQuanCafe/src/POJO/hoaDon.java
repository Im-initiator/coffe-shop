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
public class hoaDon {
   String mahd;
      Date ngayRaHD;
      String manv;      
   float thanhToan;
   float giamGia;
   String maban;
    public hoaDon() {
    }

    public hoaDon(String mahd, Date ngayRaHD, String manv, float thanhToan, float giamGia,String maban) {
        this.mahd = mahd;
        this.ngayRaHD = ngayRaHD;
        this.manv = manv;
        this.thanhToan = thanhToan;
        this.giamGia = giamGia;
        this.maban=maban;
    }
 public String getMaBan() {
        return maban;
    }

    public void getMaBan(String maban) {
        this.maban = maban;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public Date getNgayRaHD() {
        return ngayRaHD;
    }

    public void setNgayRaHD(Date ngayRaHD) {
        this.ngayRaHD = ngayRaHD;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public float getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(float thanhToan) {
        this.thanhToan = thanhToan;
    }

    public float getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(float giamGia) {
        this.giamGia = giamGia;
    }


    @Override
    public String toString() {
        return "hoaDon{" + "mahd=" + mahd + ", ngayRaHD=" + ngayRaHD + ", manv=" + manv + ", thanhToan=" + thanhToan + ", giamGia=" + giamGia + ", maban=" + maban + '}';
    }
   
    
  
}
