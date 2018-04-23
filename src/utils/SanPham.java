/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author h
 */
public class SanPham {
    private String maSanPham;
    private String ten;
    private String loaiMatHang;
    private String theLoai;
    
    private int soLuong;
    private int giaMua;
    private int giaBan;

    public SanPham(String maSanPham, String ten, String loaiMatHang, String theLoai, int soLuong, int giaMua, int giaBan) {
        this.maSanPham = maSanPham;
        this.ten = ten;
        this.loaiMatHang = loaiMatHang;
        this.theLoai = theLoai;
        this.soLuong = soLuong;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getLoaiMatHang() {
        return loaiMatHang;
    }

    public void setLoaiMatHang(String loaiMatHang) {
        this.loaiMatHang = loaiMatHang;
    }

    
    
    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    
    
    
    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    
    
    public String getTen() {
        return ten;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public int getGiaBan() {
        return giaBan;
    }
    
    
}
