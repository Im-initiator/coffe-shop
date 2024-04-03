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
public class quanTri {
    String tenTk,matKhau;

    public quanTri() {
    }

    public quanTri(String tenTk, String matKhau) {
        this.tenTk = tenTk;
        this.matKhau = matKhau;
    }

    public String getTenTk() {
        return tenTk;
    }

    public void setTenTk(String tenTk) {
        this.tenTk = tenTk;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return "quanTri{" + "tenTk=" + tenTk + ", matKhau=" + matKhau + '}';
    }
    
}
