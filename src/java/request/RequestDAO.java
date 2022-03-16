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
import java.util.ArrayList;
import java.util.List;
import user.UserDTO;
import utils.DBUtils;

/**
 *
 * @author ASUS
 */
public class RequestDAO {

    public int getMaxRequestID() throws SQLException {
        int requestID = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT MAX(requestID) AS MAXREQUESTID "
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

    public boolean inviteGroup(RequestDTO reqDTO) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " INSERT INTO tblRequest(requestID, requestDetail, isSupervisor, userID, invitedID) "
                        + " VALUES(?,?,?,?,?) ";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, reqDTO.getRequestID());
                stm.setString(2, reqDTO.getRequestDetail());
                stm.setInt(3, reqDTO.getIsSupervisor());
                stm.setString(4, reqDTO.getUserID());
                stm.setString(5, reqDTO.getInvitedID());
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

    public List<UserDTO> getRequestList(String requestDetail) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT r.requestDetail, u.userID, u.name, u.gmail, u.phone "
                        + " FROM tblUser u left join tblRequest r on u.userID = r.userID "
                        + " WHERE r.requestDetail = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, requestDetail);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String userName = rs.getString("name");
                    String phone = rs.getString("phone");
                    String gmail = rs.getString("gmail");
                    list.add(new UserDTO(userID, userName, gmail, phone));
                    System.out.println(list);
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
        return list;
    }
    
    public List<UserDTO> getRegistRequestList (String invitedID) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
         Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql =  " SELECT r.requestDetail, r.userID, u.userID, u.name, u.gmail, u.phone "
                        + " FROM tblRequest r , tblUser u "
                        + " WHERE r.userID = u.userID AND requestDetail like ? ";
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
        return list;
    }

    //Xóa request sau khi chấp nhận lời mời
    public boolean removeRequest(String requestDetail, String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " DELETE tblRequest "
                        + " where requestDetail like ? and userID like ? "; //ID của người dc mời và ID của người mời
                stm = conn.prepareStatement(sql);
                stm.setString(1, requestDetail); //lấy ID của người dc mời
                stm.setString(2, userID); //lấy ID của người mời
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
