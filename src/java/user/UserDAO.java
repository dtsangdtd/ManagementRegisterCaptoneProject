/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author mac
 */
public class UserDAO {
    public UserDTO checkLogin(String userID, String password) throws SQLException{
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn != null){
                String sql = "SELECT username, roleID, email "
                        + "FROM tbl_User "
                        + "WHERE  userID=? AND password=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if(rs.next()){
                    String username = rs.getString("username");
                    String roleID = rs.getString("roleID");
                    String email = rs.getString("email");
                    user = new UserDTO(userID, username, password, roleID, email);
                }
            }   
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs != null) rs.close();
            if(stm != null) stm.close();
            if(conn != null) conn.close();
        }
        return user;
    }
    
    public UserDTO checkLoginGG(String userID) throws SQLException{
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn != null){
                String sql = "SELECT username, password, roleID, email "
                        + "FROM tbl_User "
                        + "WHERE  userID=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                if(rs.next()){
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String roleID = rs.getString("roleID");
                    String email = rs.getString("email");
                    user = new UserDTO(userID, username, password, roleID, email);
                }
            }   
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs != null) rs.close();
            if(stm != null) stm.close();
            if(conn != null) conn.close();
        }
        return user;
    }
    
    public boolean insertUser(UserDTO user) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try{
            conn = DBUtils.getConnection();
            if(conn != null){
                String sql = "INSERT INTO tbl_User(username, email, password, userID, roleID) "
                        + " VALUES(?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getUsername());
                stm.setString(2, user.getEmail());
                stm.setString(3, user.getPassword());
                stm.setString(4, user.getUserID());
                stm.setString(5, user.getRoleID());
                check = stm.executeUpdate()>0?true:false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(stm != null) stm.close();
            if(conn != null) conn.close();
        }
        return check;
    }
}
