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
public class HoaDon {
    private String maHoaDon;
    private String tenNguoiBan;
    private String ngayBan;
    private String tenKhachHang;
    private String SDTKhachHang;
    private ArrayList<SanPham> listSanPham;

    public HoaDon(String maHoaDon, String tenNguoiBan, String ngayBan, String tenKhachHang, String SDTKhachHang, ArrayList<SanPham> listSanPham) {
        this.maHoaDon = maHoaDon;
        this.tenNguoiBan = tenNguoiBan;
        this.ngayBan = ngayBan;
        this.tenKhachHang = tenKhachHang;
        this.SDTKhachHang = SDTKhachHang;
        this.listSanPham = listSanPham;
    }

    

    

    public int getTongSoTien(){
        int tongSoTien = 0;
        for(SanPham x:listSanPham){
            tongSoTien += x.getGiaBan()*x.getSoLuong();
        }
        return tongSoTien;
    }
    
    public int getTongSoLuong(){
        int tongSoLuong = 0;
        for(SanPham x: listSanPham){
            tongSoLuong += x.getSoLuong();
        }
        return tongSoLuong;
    }
    
    //setter and getter
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenNguoiBan() {
        return tenNguoiBan;
    }

    public void setTenNguoiBan(String tenNguoiBan) {
        this.tenNguoiBan = tenNguoiBan;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public ArrayList<SanPham> getListSanPham() {
        return listSanPham;
    }

    public void setListSanPham(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public String getSDTKhachHang() {
        return SDTKhachHang;
    }

    public void setSDTKhachHang(String SDTKhachHang) {
        this.SDTKhachHang = SDTKhachHang;
    }
    
    
    
    
}
