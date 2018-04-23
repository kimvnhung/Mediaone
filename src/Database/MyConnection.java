/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Account;
import utils.ChiPhiKhac;
import utils.DiaNhac;
import utils.DiaPhim;
import utils.HoaDon;
import utils.NhanVien;
import utils.NhanVienThuNgan;
import utils.Sach;
import utils.SanPham;

/**
 *
 * @author h
 */
public class MyConnection {
    private final String className = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost/mediaone?useSSL=no&useUnicode=true";
    private final String username = "root";
    private final String password = "123456";
    private final boolean connectable;
    
    public static final String TABLE_ADMIN = "admin";
    public static final String COLUMN_ADMIN_1 = "username";
    public static final String COLUMN_ADMIN_2 = "pass";
    
    public static final String TABLE_NHAN_VIEN = "nhan_vien";
    public static final String COLUMN_NHAN_VIEN_1 = "id";
    public static final String COLUMN_NHAN_VIEN_2 = "ten_nv";
    public static final String COLUMN_NHAN_VIEN_3 = "tuoi";
    public static final String COLUMN_NHAN_VIEN_4 = "gioi_tinh";
    public static final String COLUMN_NHAN_VIEN_5 = "dia_chi";
    public static final String COLUMN_NHAN_VIEN_6 = "sdt";
    public static final String COLUMN_NHAN_VIEN_7 = "loai_nhan_vien";
    public static final String COLUMN_NHAN_VIEN_8 = "luong";
    
    public static final String TABLE_NV_LOGIN = "nv_login";
    public static final String COLUMN_NV_LOGIN_1 = "id";
    public static final String COLUMN_NV_LOGIN_2 = "username";
    public static final String COLUMN_NV_LOGIN_3 = "pass";
    
    public static final String TABLE_DS_SP = "ds_san_pham";
    public static final String COLUMN_DS_SP_1 = "ma_mh";
    public static final String COLUMN_DS_SP_2 = "ten_mh";
    public static final String COLUMN_DS_SP_3 = "loai_mh";
    public static final String COLUMN_DS_SP_4 = "ton_kho";
    public static final String COLUMN_DS_SP_5 = "gia_mua";
    public static final String COLUMN_DS_SP_6 = "gia_ban";
    
    public static final String TABLE_CT_SP = "chi_tiet_sp";
    public static final String COLUMN_CT_SP_1 = "ma_mh";
    public static final String COLUMN_CT_SP_2 = "ref1";
    public static final String COLUMN_CT_SP_3 = "ref2";
    public static final String COLUMN_CT_SP_4 = "ref3";
    public static final String COLUMN_CT_SP_5 = "the_loai";
    
    public static final String TABLE_HOA_DON = "hoa_don";
    public static final String COLUMN_HOA_DON_1 = "ma_hd";
    public static final String COLUMN_HOA_DON_2 = "nguoi_ban";
    public static final String COLUMN_HOA_DON_3 = "ngay_ban";
    public static final String COLUMN_HOA_DON_4 = "ten_khach_hang";
    public static final String COLUMN_HOA_DON_5 = "sdt";
    
    public static final String TABLE_CT_HD = "chi_tiet_hd";
    public static final String COLUMN_CT_HD_1 = "ma_hd";
    public static final String COLUMN_CT_HD_2 = "nguoi_mh";
    public static final String COLUMN_CT_HD_3 = "so_luong";
    
    public static final String TABLE_CPPS = "chi_phi_phat_sinh";
    public static final String COLUMN_CPPS_1 = "ten_chi_phi";
    public static final String COLUMN_CPPS_2 = "so_tien";
    public static final String COLUMN_CPPS_3 = "tren_don_vi";
    
    public MyConnection() throws ClassNotFoundException, SQLException{
        connect();
        connectable = true;
    }
    
    private Connection myConnection;
    
    private void connect() throws ClassNotFoundException, SQLException {
        Class.forName(className);
        myConnection = DriverManager.getConnection(url, username, password);
    }
    
    //thực thi 1 query bất kì
    public void executeQuery(String query) throws SQLException,Exception{
        Statement st;
        st = myConnection.createStatement();
        int result = st.executeUpdate(query);
    }    
    
    //thêm dữ liệu vào bảng admin
    public void insertIntoAdmin(String user,String pass) throws SQLException{
        Statement st = myConnection.createStatement();
        String insert = "INSERT INTO " + TABLE_ADMIN + " VALUES (\""
                + user + "\" , \"" + pass + "\" )";
        int result = st.executeUpdate(insert);
    }
    
    //thêm dữ liệu vào bảng nhan_vien  
    public void insertIntoNhanVien(NhanVien nhanVienMoi) throws SQLException{
        Statement st = myConnection.createStatement();
        String insert = "INSERT INTO " + TABLE_NHAN_VIEN + " VALUES ( DEFAULT ,\""
                + nhanVienMoi.getTen() + "\" ,"
                + nhanVienMoi.getTuoi() + " , "
                + nhanVienMoi.getGioiTinh() + " , \""
                + nhanVienMoi.getDiaChi() + "\" , \""
                + nhanVienMoi.getSDT() + "\" , \""
                + nhanVienMoi.getLoaiNhanVien() + "\" , "
                + nhanVienMoi.getLuong() + " )";
        int result = st.executeUpdate(insert);
        if(nhanVienMoi.getLoaiNhanVien().equals("Nhân Viên Thu Ngân")){
           insertIntoNvLogin(((NhanVienThuNgan) nhanVienMoi).getAccount());
        }
        
    }
    
    //thêm dữ liệu vào bảng nv_login
    public void insertIntoNvLogin(Account acc) throws SQLException{
        Statement st = myConnection.createStatement();
        
        String insert = "INSERT INTO " + TABLE_NV_LOGIN + " VALUES ( "
                + acc.getId()+" ,\""
                + acc.getUsername() + "\" , \""
                + acc.getUsername() + "\" )";
        int result = st.executeUpdate(insert);
    }
    
    //thêm dữ liệu vào bảng ds_san_pham
    public void insertIntoDsSanPham(SanPham sanPhamMoi) throws SQLException{
        Statement st = myConnection.createStatement();
        
        String insert = "INSERT INTO " + TABLE_DS_SP + " VALUES ( "
                + sanPhamMoi.getMaSanPham() +" ,\""
                + sanPhamMoi.getTen() + "\" , \""
                + sanPhamMoi.getLoaiMatHang() + "\", "
                + sanPhamMoi.getSoLuong() + " , "
                + sanPhamMoi.getGiaMua() + " , "
                + sanPhamMoi.getGiaBan()+ " )";
        int result = st.executeUpdate(insert);
        switch(sanPhamMoi.getLoaiMatHang()){
            case "Đĩa Nhạc":
                DiaNhac sp1 = (DiaNhac) sanPhamMoi;
                insert = "INSERT INTO " + TABLE_CT_SP + " VALUES ("
                        + sp1.getMaSanPham() +" , \" "
                        + sp1.getNhacSi() +"\" , \""
                        + sp1.getCaSi() + "\" , \""
                        + sp1.getAlbumn() + "\" , \""
                        + sp1.getTheLoai() +"\" )";
                result = st.executeUpdate(insert);
                break;
            case "Đĩa Phim":
                DiaPhim sp2 = (DiaPhim) sanPhamMoi;
                insert = "INSERT INTO " + TABLE_CT_SP + " VALUES ("
                        + sp2.getMaSanPham() +" , \" "
                        + sp2.getDaoDien()+"\" , \""
                        + sp2.getDienVien()+ "\" , \""
                        + sp2.getChatLuong()+ "\" , \""
                        + sp2.getTheLoai() +"\" )";
                result = st.executeUpdate(insert);
                break;
            default:
                Sach sp3 = (Sach) sanPhamMoi;
                insert = "INSERT INTO " + TABLE_CT_SP + " VALUES ("
                        + sp3.getMaSanPham() +" , \" "
                        + sp3.getTacGia()+"\" , \""
                        + sp3.getNxb()+ "\" , \""
                        + sp3.getNgonNgu()+ "\" , \""
                        + sp3.getTheLoai() +"\" )";
                result = st.executeUpdate(insert);
                break;
        }
    }
    
    //thêm thông tin bảng hoa_don và chi tiết hóa đơn
    public void insertIntoHoaDon(HoaDon hd) throws SQLException{
        Statement st = myConnection.createStatement();
        String insert = "INSERT INTO "+TABLE_HOA_DON + " VALUES ("
                +"DEFAULT , \""
                + hd.getTenNguoiBan() + "\", \""
                + hd.getNgayBan() +"\" , \""
                + hd.getKhachHang().getTenKhachHang() + "\", \""
                + hd.getKhachHang().getSDT()+ "\")";
        int result = st.executeUpdate(insert);
        
        int soLuong = hd.getListSanPham().size();
        for(int i = 0; i < soLuong; i++){
            insert = "INSERT INTO "+TABLE_CT_HD +" VALUES ("
                + hd.getMaHoaDon() +" , "
                + hd.getListSanPham().get(i).getMaSanPham() +" , "
                + hd.getListSanPham().get(i).getSoLuong() + " )";
            result = st.executeUpdate(insert);
        }
    }
    
    //thêm thông tin bảng chi phi phát sinh
    public void insertIntoChiPhiPhatSinh(ChiPhiKhac cp) throws SQLException{
        Statement st = myConnection.createStatement();
        String insert = "INSERT INTO "+TABLE_CPPS +" VALUES (\""
                + cp.getTenChiPhi() + "\" , "
                + cp.getSoTien() +" , \""
                + cp.getTrenDonVi()+"\" )";
        int result = st.executeUpdate(insert);
    }
    
    //Cập nhật thông tin nhân viên
    public void updateToNhanVien(NhanVien nvUpdate) throws SQLException{
        Statement st = myConnection.createStatement();
        String update = "UPDATE "+TABLE_NHAN_VIEN + " SET "
                + COLUMN_NHAN_VIEN_2 +" = \""+nvUpdate.getTen()+"\" , "
                + COLUMN_NHAN_VIEN_3 +" = "+nvUpdate.getTuoi()+" , "
                + COLUMN_NHAN_VIEN_4 +" = "+nvUpdate.getGioiTinh()+" , "
                + COLUMN_NHAN_VIEN_5 +" = \""+nvUpdate.getDiaChi()+" , "
                + COLUMN_NHAN_VIEN_6 +" = \""+nvUpdate.getSDT()+"\" , "
                + COLUMN_NHAN_VIEN_7 +" = \""+nvUpdate.getLoaiNhanVien()+"\" , "
                + COLUMN_NHAN_VIEN_8 +" = "+nvUpdate.getLuong()+" WHERE "
                + COLUMN_NHAN_VIEN_1 +" = "+nvUpdate.getId();
        int result = st.executeUpdate(update);
        if(nvUpdate.getLoaiNhanVien().equals("Nhân Viên Thu Ngân")){
            updateToNvLogin(((NhanVienThuNgan) nvUpdate).getAccount());
        }
    }
    //Cập nhật thông tin nv_login
    public void updateToNvLogin(Account acc) throws SQLException{
        Statement st = myConnection.createStatement();
        String update = "UPDATE "+TABLE_NV_LOGIN + " SET "
                + COLUMN_NV_LOGIN_2 + " = \""+acc.getUsername()+"\", "
                + COLUMN_NV_LOGIN_3 + " = \""+acc.getPassword()+"\" WHERE "
                + COLUMN_NV_LOGIN_1 + " = "+acc.getId();
        
        int result = st.executeUpdate(update);
    }
    
    //đếm số hàng bảng admin
    public int getCountOfAdmin() throws SQLException{
        Statement st = myConnection.createStatement();
        String select = "SELECT count(*) FROM " + TABLE_ADMIN;
        int count = 0;
        ResultSet result = st.executeQuery(select);
        result.first();
        count = result.getInt(1);
        result.close();
        return count;
    }
    
    //lấy tài khoản admin
    public Account getAdminAcount() throws SQLException{
        Statement st = myConnection.createStatement();
        String select = "SELECT * FROM "+TABLE_ADMIN;
        ResultSet rs = st.executeQuery(select);
        rs.first();
        Account admin = new Account(0,rs.getString(1),rs.getString(2));
        rs.close();
        return admin;
    }
    
    //lấy tài khoản nhân viên
    public ArrayList<Account> getNhanVienAccount() throws SQLException{
        Statement st = myConnection.createStatement();
        String select = "SELECT * FROM "+TABLE_NV_LOGIN;
        ResultSet rs = st.executeQuery(select);
        //rs.first();
        ArrayList<Account> result = new ArrayList<>();
        while(rs.next()){
            result.add(new Account(rs.getInt(1),rs.getString(2),rs.getString(3)));
        }
        rs.close();
        return result;
    }
    
    //lấy danh sách nhân viên
    public ArrayList<NhanVienThuNgan> getListNhanVienThuNgan() throws SQLException{
        ArrayList<NhanVienThuNgan> listNhanVienThuNgan = new ArrayList<>();
        Statement st = myConnection.createStatement();
        String select = "SELECT * FROM "+TABLE_NHAN_VIEN +" INNER JOIN "
                + TABLE_NV_LOGIN + " ON "+TABLE_NHAN_VIEN +"."+COLUMN_NHAN_VIEN_1+" = "
                + TABLE_NV_LOGIN +"."+COLUMN_NV_LOGIN_1;
        ResultSet rs = st.executeQuery(select);
        while(rs.next()){
            listNhanVienThuNgan.add(new NhanVienThuNgan(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)==1?true:false,rs.getString(5),
                    rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(10),rs.getString(11)
            ));
        }
        return listNhanVienThuNgan;
    }
    
    //lấy danh sách nhân viên
    public ArrayList<NhanVien> getListNhanVienBanHang() throws SQLException{
        ArrayList<NhanVien> listNhanVienBanHang = new ArrayList<>();
        Statement st = myConnection.createStatement();
        String select = "SELECT * FROM "+TABLE_NHAN_VIEN +" WHERE " +COLUMN_NHAN_VIEN_1 +" NOT IN ("
                + "SELECT "+COLUMN_NV_LOGIN_1 +" FROM "+TABLE_NV_LOGIN
                + ")";
        ResultSet rs = st.executeQuery(select);
        while(rs.next()){
            listNhanVienBanHang.add(new NhanVien(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)==1?true:false,rs.getString(5),
                    rs.getString(6),rs.getString(7),rs.getInt(8)
            ));
        }
        return listNhanVienBanHang;
    }
    //kiểm tra xem có thể connect tới database
    public boolean isConnectable() {
        return connectable;
    }
    
}
