/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author Duong Duy
 */
public class chiTietNK {
    String maNhap,maNuoc;
    int soLuong;
    float giaNhap,thanhTien;

    public chiTietNK() {
    }

    public chiTietNK(String maNhap, String maNuoc, int soLuong, float giaNhap, float thanhTien) {
        this.maNhap = maNhap;
        this.maNuoc = maNuoc;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.thanhTien = thanhTien;
    }

    public String getMaNhap() {
        return maNhap;
    }

    public void setMaNhap(String maNhap) {
        this.maNhap = maNhap;
    }

    public String getMaNuoc() {
        return maNuoc;
    }

    public void setMaNuoc(String maNuoc) {
        this.maNuoc = maNuoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "chiTietNK{" + "maNhap=" + maNhap + ", maNuoc=" + maNuoc + ", soLuong=" + soLuong + ", giaNhap=" + giaNhap + ", thanhTien=" + thanhTien + '}';
    }
    
}
