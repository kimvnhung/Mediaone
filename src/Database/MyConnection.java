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
import utils.NhanVien;
import utils.NhanVienThuNgan;

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
    
    //thêm dữ liệu vào bảng nhan_vien và nv_login
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
           insert = "INSERT INTO " + TABLE_NV_LOGIN + " VALUES ( DEFAULT ,\""
                   + ((NhanVienThuNgan) nhanVienMoi).getAccount().getUsername() + "\" , \""
                   + ((NhanVienThuNgan) nhanVienMoi).getAccount().getUsername() + "\" )";
           result = st.executeUpdate(insert);
        }
        
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
        Account admin = new Account(rs.getString(1),rs.getString(2));
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
            result.add(new Account(rs.getString(2),rs.getString(3)));
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
