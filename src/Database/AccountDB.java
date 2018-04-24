/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.Account;

/**
 *
 * @author h
 */
public class AccountDB {
    private Connection connection;
    public static final String TABLE_NV_LOGIN = "nv_login";
    public static final String COLUMN_NV_LOGIN_1 = "id";
    public static final String COLUMN_NV_LOGIN_2 = "username";
    public static final String COLUMN_NV_LOGIN_3 = "pass";

    public AccountDB() throws ClassNotFoundException, SQLException {
        this.connection = new MyConnection().getMyConnection();
    }
    
    public void addAccount(Account acc) throws SQLException{
        Statement st = connection.createStatement();
        String insert = "INSERT INTO "+TABLE_NV_LOGIN + " VALUES ("
                + acc.getId()+", \""
                + acc.getUsername()+"\" , \""
                + acc.getPassword()+"\")";
        int result  = st.executeUpdate(insert);
        
    }
    
    public void deleteAccount(Account acc) throws SQLException{
        Statement st = connection.createStatement();
        String delete = "DELETE FROM "+TABLE_NV_LOGIN +" WHERE "
                + COLUMN_NV_LOGIN_1 + " = "+acc.getId();
        int result = st.executeUpdate(delete);
    }
    
    public void updateAccount(Account acc) throws SQLException{
        Statement st = connection.createStatement();
        String update = "UPDATE "+TABLE_NV_LOGIN +" SET "
                +COLUMN_NV_LOGIN_2 + " = \""+acc.getUsername()+"\", \""
                + COLUMN_NV_LOGIN_3 + " = \""+acc.getPassword()+"\" WHERE "
                + COLUMN_NV_LOGIN_1 + " = "+acc.getId();
        int result = st.executeUpdate(update);
    }
    
    public ArrayList<Account> getListAccount() throws SQLException{
        ArrayList<Account> listAccount = new ArrayList<>();
        Statement st = connection.createStatement();
        String select = "SELECT * FROM "+TABLE_NV_LOGIN;
        ResultSet rs = st.executeQuery(select);//kiểu dữ liệu bảng 
        while(rs.next()){
            listAccount.add(new Account(rs.getInt(1),rs.getString(2),rs.getString(3)));
        }
        rs.close();
        return listAccount;
    }
    
}
