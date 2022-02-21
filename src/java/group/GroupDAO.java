/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import request.RequestDTO;
import utils.DBUtils;

/**
 *
 * @author Mai
 */
public class GroupDAO {

    public int getMaxUserGroupID() throws SQLException {
        int userGroupID = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT MAX(userGroupID) AS MAXUSERGROUPID "
                        + " FROM tblUserGroup ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    userGroupID = rs.getInt("MAXUSERGROUPID");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return userGroupID;
    }
    

    
    public boolean acceptInviteGroup (String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT into tblUserGroup (userGroupID, userID, groupID, isSupervisor)"
                        + "VALUES (?,?,?,0)";
                stm = conn.prepareStatement(sql);
                stm.setString(0, "userGroupID");
                stm.setString(1, "userID");
                stm.setString(2, "groupID");
                stm.setString(3, "isSupervisor");
                check = stm.executeUpdate() > 0 ? true : false; 
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
