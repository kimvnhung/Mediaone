/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;

/**
 *
 * @author h
 */
public class KhachHang {
    private String tenKhachHang;
    private String SDT;

    public KhachHang(String tenKhachHang, String SDT) {
        this.tenKhachHang = tenKhachHang;
        this.SDT = SDT;
    }
    
    public void thanhToan(HoaDon hd){
        
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    
}
