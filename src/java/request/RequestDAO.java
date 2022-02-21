/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import user.UserDTO;
import utils.DBUtils;

/**
 *
 * @author ASUS
 */
public class RequestDAO {
    public int getMaxRequestID () throws SQLException {
        int requestID = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql =" SELECT MAX(requestID) AS MAXREQUESTID "
                        + " FROM tblRequest ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    requestID = rs.getInt("MAXREQUESTID");
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
        return requestID;
    }
    
        public boolean inviteGroup (RequestDTO reqDTO) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " INSERT INTO tblRequest(requestID, requestDetail, isSupervisor, userID) "
                        + " VALUES(?,?,?,?) ";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, reqDTO.getRequestID());
                stm.setString(2, reqDTO.getRequestDetail());
                stm.setInt(3, reqDTO.getIsSupervisor());
                stm.setString(4, reqDTO.getUserID());
                check = stm.executeUpdate()>0?true:false;
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
