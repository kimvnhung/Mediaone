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
public class NhanVienThuNgan extends NhanVien{
    private Account account;

    public NhanVienThuNgan(int id,String ten, int tuoi, boolean gioiTinh, String diaChi, String SDT,String loaiNhanVien, int luong, String username,String password) {
        super(id,ten,tuoi,gioiTinh,diaChi,SDT,loaiNhanVien,luong);
        this.account = new Account(id,username,password);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    
}
