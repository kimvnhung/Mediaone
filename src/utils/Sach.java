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
public class Sach extends SanPham{
    private String tacGia;
    private String nxb;
    private String ngonNgu;

    public Sach(String maSanPham, String ten, String tacGia, String nxb, String ngonNgu, String theLoai, int soLuong, int giaMua, int giaBan) {
        super(maSanPham,ten, theLoai, soLuong, giaMua, giaBan);
        this.tacGia = tacGia;
        this.nxb = nxb;
        this.ngonNgu = ngonNgu;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }
    
    
}
