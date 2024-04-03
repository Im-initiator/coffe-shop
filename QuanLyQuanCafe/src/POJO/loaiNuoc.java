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
public class loaiNuoc {
    String maLoaiNuoc,tenLoaiNuoc;

    public loaiNuoc() {
    }

    public loaiNuoc(String maLoaiNuoc, String tenLoaiNuoc) {
        this.maLoaiNuoc = maLoaiNuoc;
        this.tenLoaiNuoc = tenLoaiNuoc;
    }

    public String getMaLoaiNuoc() {
        return maLoaiNuoc;
    }

    public void setMaLoaiNuoc(String maLoaiNuoc) {
        this.maLoaiNuoc = maLoaiNuoc;
    }

    public String getTenLoaiNuoc() {
        return tenLoaiNuoc;
    }

    public void setTenLoaiNuoc(String tenLoaiNuoc) {
        this.tenLoaiNuoc = tenLoaiNuoc;
    }

    @Override
    public String toString() {
        return maLoaiNuoc+"_"+tenLoaiNuoc;
    }
     
}
