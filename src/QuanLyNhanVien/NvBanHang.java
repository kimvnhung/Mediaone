/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhanVien;

import Main.HomeFrame;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import utils.NhanVien;

/**
 *
 * @author h
 */
public class NvBanHang extends javax.swing.JPanel {
    private ArrayList<Integer> listRowBeChanged;
    /**
     * Creates new form NvThuNgan
     */
    public NvBanHang() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) tbDsNv.getModel();
        model.setNumRows(0);
        
        for(NhanVien x: HomeFrame.cuaHang.getListNhanVienBanHang()){
            Object[] newRow = {HomeFrame.cuaHang.getListNhanVienBanHang().indexOf(x)+1,x.getTen(),x.getTuoi(),
                x.getGioiTinh()==1?"Nam":"Nữ",x.getDiaChi(),x.getSDT(),x.getLuong()
            };
            model.addRow(newRow);
        }
        listRowBeChanged = new ArrayList<>();
        model.addTableModelListener(
                new TableModelListener(){
                    @Override
                    public void tableChanged(TableModelEvent tme) {
                        if(tme.getType() == TableModelEvent.UPDATE){
                            listRowBeChanged.add(tme.getFirstRow());
                        }
                    }
                    
                }
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrPDsNv = new javax.swing.JScrollPane();
        tbDsNv = new javax.swing.JTable();
        lbTitleDsNv = new javax.swing.JLabel();
        btLuuNv = new javax.swing.JButton();
        btXoaNv = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 500));

        tbDsNv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên nhân viên", "Tuổi", "Giới tính", "Địa chỉ", "SĐT", "Lương(VND/Tháng)"
            }
        ));
        ScrPDsNv.setViewportView(tbDsNv);

        lbTitleDsNv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbTitleDsNv.setText("Danh sách nhân viên bán hàng");

        btLuuNv.setText("Lưu");
        btLuuNv.setPreferredSize(new java.awt.Dimension(85, 23));
        btLuuNv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLuuNvActionPerformed(evt);
            }
        });

        btXoaNv.setText("Xóa");
        btXoaNv.setPreferredSize(new java.awt.Dimension(85, 23));
        btXoaNv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaNvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ScrPDsNv))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(252, 252, 252)
                                .addComponent(btLuuNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(btXoaNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(323, 323, 323)
                                .addComponent(lbTitleDsNv)))
                        .addGap(0, 242, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lbTitleDsNv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrPDsNv, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLuuNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXoaNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btLuuNvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLuuNvActionPerformed
        // TODO add your handling code here:
        ArrayList<NhanVien> updateList = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tbDsNv.getModel();
        int rowRange = model.getRowCount();
        for(int i = 0; i <  rowRange; i++){
            int id = HomeFrame.cuaHang.getListNhanVienBanHang().get(i).getId();
            String loaiNhanVien = HomeFrame.cuaHang.getListNhanVienBanHang().get(i).getLoaiNhanVien();
            NhanVien rowItem = new NhanVien(
                    id,(String)model.getValueAt(i, 1),(int)model.getValueAt(i, 2), model.getValueAt(i, 3).equals("Nam")?true:false,
                    (String)model.getValueAt(i, 4),(String)model.getValueAt(i, 5),loaiNhanVien,(int)model.getValueAt(i, 6)
            );
            updateList.add(rowItem);
        }
        HomeFrame.cuaHang.setListNhanVienBanHang(updateList);
        
        
        
    }//GEN-LAST:event_btLuuNvActionPerformed

    private void btXoaNvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaNvActionPerformed
        // TODO add your handling code here:
        int position = tbDsNv.getSelectedRow();
        
        HomeFrame.cuaHang.getListNhanVienBanHang().remove(position);
        
        
    }//GEN-LAST:event_btXoaNvActionPerformed
    
    public JTable getTbDsNv() {
        return tbDsNv;
    }

    public JScrollPane getScrPDsNv() {
        return ScrPDsNv;
    }

    public JLabel getLbTitleDsNv() {
        return lbTitleDsNv;
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrPDsNv;
    private javax.swing.JButton btLuuNv;
    private javax.swing.JButton btXoaNv;
    private javax.swing.JLabel lbTitleDsNv;
    private javax.swing.JTable tbDsNv;
    // End of variables declaration//GEN-END:variables
}
