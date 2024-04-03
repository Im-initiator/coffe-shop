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
public class nuocUong {
   String maNuoc,tenNuoc,maLoaiNuoc;
   float donGia;

    public nuocUong() {
    }

    public nuocUong(String maNuoc, String tenNuoc, String maLoaiNuoc, float donGia) {
        this.maNuoc = maNuoc;
        this.tenNuoc = tenNuoc;
        this.maLoaiNuoc = maLoaiNuoc;
        this.donGia = donGia;
    }

    public String getMaNuoc() {
        return maNuoc;
    }

    public void setMaNuoc(String maNuoc) {
        this.maNuoc = maNuoc;
    }

    public String getTenNuoc() {
        return tenNuoc;
    }

    public void setTenNuoc(String tenNuoc) {
        this.tenNuoc = tenNuoc;
    }

    public String getMaLoaiNuoc() {
        return maLoaiNuoc;
    }

    public void setMaLoaiNuoc(String maLoaiNuoc) {
        this.maLoaiNuoc = maLoaiNuoc;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return maNuoc+"_"+tenNuoc;
    }
   
}
