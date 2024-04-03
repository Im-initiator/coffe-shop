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
public class chiTietHD {

    String maHD, maNuocUong;
    int soLuong;
    float donGia, thanhTien;

    public chiTietHD(String maHD, String maNuocUong, int soLuong, float donGia, float thanhTien) {
        this.maHD = maHD;
        this.maNuocUong = maNuocUong;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public chiTietHD() {
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNuocUong() {
        return maNuocUong;
    }

    public void setMaNuocUong(String maNuocUong) {
        this.maNuocUong = maNuocUong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "chiTietHD{" + "maHD=" + maHD + ", maNuocUong=" + maNuocUong + ", soLuong=" + soLuong + ", donGia=" + donGia + ", thanhTien=" + thanhTien + '}';
    }

}
