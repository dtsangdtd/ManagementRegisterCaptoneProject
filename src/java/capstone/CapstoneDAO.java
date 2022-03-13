/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author dtsang
 */
public class CapstoneDAO {

    public CapstoneDTO getCapstoneName(String groupID) throws SQLException {
        CapstoneDTO capstone = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT tblUser.name, tblCapstone.capstoneName FROM tblUser \n"
                        + "Left Join tblUserGroup ON tblUser.userID = tblUserGroup.userID \n"
                        + "Left Join tblCapstone ON tblUserGroup.groupID = tblCapstone.groupID\n"
                        + "WHERE tblUserGroup.isSupervisor = 'true' and tblUserGroup.groupID = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, groupID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    String capstoneName = rs.getString("capstoneName");
                    capstone = new CapstoneDTO(capstoneName, "", name, "", "");
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
        return capstone;
    }
    
    public List<String> getListCapsRandom(int n, String semesterID) throws SQLException {
        List<String> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT TOP ? capstoneID "
                        + " FROM tblCapstone"
                        + " WHERE semesterID = ? ";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, n);
                stm.setString(2, semesterID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String capstoneID = rs.getString("capstoneID");
                    list.add(capstoneID);
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

    public List<CapstoneDTO> getTopicSearch(String semesterID) throws SQLException {
        List<CapstoneDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                System.out.println(semesterID);
                String sql = " SELECT  c.capstoneID, c.capstoneName, c.groupID, c.statusID, u.name "
                        + " FROM tblCapstone c full join tblUserCapstone uc on c.capstoneID = uc.capstoneID full join tblUser u on u.userID = uc.userID  "
                        + " WHERE c.semesterID = ? AND u.roleID = 'MT'"
                        + " ORDER BY c.capstoneName DESC";
                stm = conn.prepareStatement(sql);
                stm.setString(1, semesterID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String capstoneID = rs.getString("capstoneID");
                    String capstoneName = rs.getString("capstoneName");
                    String userName = rs.getString("name");
                    String groupID = rs.getString("groupID");
                    String statusID = rs.getString("statusID");
                    list.add(new CapstoneDTO(capstoneID, capstoneName, groupID, semesterID, statusID, userName));
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
    
    public List<CapstoneDTO> getListCapstone (String semesterID) throws SQLException {
        List<CapstoneDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT capstoneID, capstoneName, startTime, endTime, userID, userName, statusID "
                        + " FROM tblCapstone c "
                        + " WHERE semesterID = ? AND roleID = 'MT' "
                        + " ORDER BY capstoneName DESC ";
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
    
//    public List<CapstoneDTO> getTopicSearchV2(String semesterID) throws SQLException {
//        List<CapstoneDTO> list = new ArrayList<>();
//        Connection conn = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                System.out.println(semesterID);
//                String sql = " SELECT u.name "
//                        + " FROM tblCapstone c full join tblUserCapstone uc on c.capstoneID = uc.capstoneID full join tblUser u on u.userID = uc.userID  "
//                        + " WHERE c.cName = ? AND u.roleID = 'MT'"
//                        + " ORDER BY c.capstoneName DESC";
//                stm = conn.prepareStatement(sql);
//                stm.setString(1, semesterID);
//                rs = stm.executeQuery();
//                while (rs.next()) {
//                    String userName = rs.getString("name");
//                    list.add(new CapstoneDTO(capstoneID, capstoneName, groupID, semesterID, statusID, userName));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (stm != null) {
//                stm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return list;
//    }
}
