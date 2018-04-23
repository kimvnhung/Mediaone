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

    public CuaHang() throws SQLException, ClassNotFoundException {
        connection = new MyConnection();
        updateData();
    }
    
    public void themNhanVien(NhanVien nhanVienMoi) throws SQLException{
        connection.insertIntoNhanVien(nhanVienMoi);
        
        
        if(nhanVienMoi.getLoaiNhanVien().equals("Nhân Viên Thu Ngân")){
            getListNhanVienThuNgan().add((NhanVienThuNgan) nhanVienMoi);
        }else{
            getListNhanVienBanHang().add(nhanVienMoi);
        }
    }
    
    public void updateNhanVien(){
        
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

    
    
    public void updateData() throws SQLException{
        this.setChuCuaHang(connection.getAdminAcount().getUsername());
        this.setListNhanVienBanHang(connection.getListNhanVienBanHang());
        this.setListNhanVienThuNgan(connection.getListNhanVienThuNgan());
        this.setListDiaNhac(new ArrayList<DiaNhac>());
        this.setListDiaPhim(new ArrayList<DiaPhim>());
        this.setListSach(new ArrayList<Sach>());
        this.setListChiPhiKhac(new ArrayList<ChiPhiKhac>());
        
        
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

    public void setChuCuaHang(String chuCuaHang) {
        this.chuCuaHang = chuCuaHang;
    }

    public void setListNhanVienBanHang(ArrayList<NhanVien> listNhanVienBanHang) {
        this.listNhanVienBanHang = listNhanVienBanHang;
    }

    public void setListDiaNhac(ArrayList<DiaNhac> listDiaNhac) {
        this.listDiaNhac = listDiaNhac;
    }

    public void setListDiaPhim(ArrayList<DiaPhim> listDiaPhim) {
        this.listDiaPhim = listDiaPhim;
    }

    public void setListSach(ArrayList<Sach> listSach) {
        this.listSach = listSach;
    }

    public void setListChiPhiKhac(ArrayList<ChiPhiKhac> listChiPhiKhac) {
        this.listChiPhiKhac = listChiPhiKhac;
    }
    
    
    
}
