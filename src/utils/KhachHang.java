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
    private ArrayList<HoaDon> listHoaDon;
    private String SDT;

    public KhachHang(String tenKhachHang, ArrayList<HoaDon> listHoaDon, String SDT) {
        this.tenKhachHang = tenKhachHang;
        this.listHoaDon = listHoaDon;
        this.SDT = SDT;
    }
    
    public void thanhToan(){
        
    }
}
