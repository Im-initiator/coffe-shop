/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Duong Duy
 */
public class nhanVien {
    String manv,matkhau,tennv,gioiTinh,diaChi,sdt;
    Date namSinh,ngayVL;
    float luong;
    
    public nhanVien() {
    }

    public nhanVien(String manv, String matkhau, String tennv, String gioiTinh, String diaChi, String sdt, Date namSinh, Date ngayVL, float luong) {
        this.manv = manv;
        this.matkhau = matkhau;
        this.tennv = tennv;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.namSinh = namSinh;
        this.ngayVL = ngayVL;
        this.luong = luong;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public Date getNgayVL() {
        return ngayVL;
    }

    public void setNgayVL(Date ngayVL) {
        this.ngayVL = ngayVL;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return "nhanVien{" + "manv=" + manv + ", matkhau=" + matkhau + ", tennv=" + tennv + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", sdt=" + sdt + ", namSinh=" + namSinh + ", ngayVL=" + ngayVL + ", luong=" + luong + '}';
    }
    
}
