/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhanVien;

import Main.HomeFrame;
import javax.swing.table.DefaultTableModel;
import utils.NhanVien;
import utils.NhanVienThuNgan;

/**
 *
 * @author h
 */
public class NvThuNgan extends NvBanHang {
    public NvThuNgan(){
        super();
        DefaultTableModel tm = new DefaultTableModel(
                new Object[][]{},new String[]{
                    "STT","Tên nhân viên","Tuổi","Giới tính","Địa chỉ","SĐT","Lương (VND/Tháng)","Username","Password"
                }
        );
        getTbDsNv().setModel(tm);
        getScrPDsNv().setViewportView(this.getTbDsNv());
        getLbTitleDsNv().setText("Danh sách nhân viên thu ngân");
        
        tm = (DefaultTableModel) getTbDsNv().getModel();
        
        for(NhanVienThuNgan x: HomeFrame.cuaHang.getListNhanVienThuNgan()){
            Object[] newRow = {HomeFrame.cuaHang.getListNhanVienThuNgan().indexOf(x)+1,
                x.getTen(),x.getTuoi(),
                x.getGioiTinh()==1?"Nam":"Nữ",x.getDiaChi(),x.getSDT(),
                x.getLuong(),x.getAccount().getUsername(),x.getAccount().getPassword()
            };
            tm.addRow(newRow);
        }
    }
    
    
}
