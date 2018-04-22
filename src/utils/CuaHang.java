/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Database.MyConnection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author h
 */
public class CuaHang {
    private final String tenCuaHang = "MediaOne";
    private MyConnection connection ;
    
    private String chuCuaHang;
    private ArrayList<NhanVien> listNhanVienBanHang;
    private ArrayList<NhanVienThuNgan> listNhanVienThuNgan;
    private ArrayList<DiaNhac> listDiaNhac;
    private ArrayList<DiaPhim> listDiaPhim;
    private ArrayList<Sach> listSach;
    private ArrayList<ChiPhiKhac> listChiPhiKhac;

    public CuaHang(String admin,
            ArrayList<NhanVien> listNhanVien, ArrayList<NhanVienThuNgan> listNhanVienThuNgan,
            ArrayList<DiaNhac> listDiaNhac, ArrayList<DiaPhim> listDiaPhim, ArrayList<Sach> listSach, 
            ArrayList<ChiPhiKhac> listChiPhiKhac) throws SQLException, ClassNotFoundException {
        this.chuCuaHang = admin;
        this.listNhanVienBanHang = listNhanVien;
        this.listNhanVienThuNgan = listNhanVienThuNgan;
        this.listDiaNhac = listDiaNhac;
        this.listDiaPhim = listDiaPhim;
        this.listSach = listSach;
        this.listChiPhiKhac = listChiPhiKhac;
        
        connection = new MyConnection();
    }
    
    public void themNhanVien(NhanVien nhanVienMoi) throws SQLException{
        connection.insertIntoNhanVien(nhanVienMoi);
    }
    
    public void nhapKhoHang(){
        
    }
    
    public void thongKeDoanhThu(){
        
    }
    
    public void thongKeLoiNhuan(){
        
    }
    
    public boolean isAdmin(String username){
        if(username.equals(chuCuaHang)){
            return true;
        }
        
        return false;
    }

    public void updateData(){
        
    }
    
    
    //setter and getter
    
    public String getTenCuaHang() {
        return tenCuaHang;
    }

    public MyConnection getConnection() {
        return connection;
    }

    public String getChuCuaHang() {
        return chuCuaHang;
    }

    public ArrayList<NhanVien> getListNhanVienBanHang() {
        return listNhanVienBanHang;
    }

    public ArrayList<DiaNhac> getListDiaNhac() {
        return listDiaNhac;
    }

    public ArrayList<DiaPhim> getListDiaPhim() {
        return listDiaPhim;
    }

    public ArrayList<Sach> getListSach() {
        return listSach;
    }

    public ArrayList<ChiPhiKhac> getListChiPhiKhac() {
        return listChiPhiKhac;
    }

    public ArrayList<NhanVienThuNgan> getListNhanVienThuNgan() {
        return listNhanVienThuNgan;
    }

    public void setListNhanVienThuNgan(ArrayList<NhanVienThuNgan> listNhanVienThuNgan) {
        this.listNhanVienThuNgan = listNhanVienThuNgan;
    }
    
    
    
}
