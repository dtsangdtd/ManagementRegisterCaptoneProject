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
import java.util.ArrayList;
import java.util.List;
import request.RequestDTO;
import user.UserDTO;
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

    public int getMaxGroupID() throws SQLException {
        int userGroupID = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT MAX(groupID) AS MAXGROUPID "
                        + " FROM tblGroup ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    userGroupID = rs.getInt("MAXGROUPID");
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

    public boolean acceptInviteGroup(UserGroup user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " INSERT INTO tblUserGroup (userGroupID, userID, groupID, isSupervisor) "
                        + " VALUES (?,?,?,?) ";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, user.getUserGroupID());
                stm.setString(2, user.getUserID());
                stm.setInt(3, user.getGroupID());
                stm.setInt(4, user.getIsSupervisor());
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

    public boolean addToGroup(GroupDTO group) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " INSERT INTO tblGroup(groupID, groupName, capstoneID, numberOfPerson, statusID) "
                        + " VALUES(?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, group.getGroupID1());
                stm.setString(2, group.getGroupName());
                stm.setInt(3, group.getCapstoneID());
                stm.setInt(4, group.getNumOfPer());
                stm.setInt(5, group.getStatusID1());
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

    public boolean updateNumberOfPerson(GroupDTO group) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " UPDATE tblGroup set numberOfPerson = ? "
                        + " WHERE groupID like ? ";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, group.getNumOfPer());
                stm.setInt(2, group.getGroupID1());
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

    public String getGroupID(String userID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String groupID = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT top 1 groupID FROM tblUserGroup \n"
                        + "Where tblUserGroup.userID = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    groupID = rs.getString("groupID");
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
        return groupID;
    }

    public List<GroupDTO> getListStudentInGroup(String groupIdSearch) throws SQLException {
        List<GroupDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT tb2.userID,tb2.roleID,tb2.name,tb2.phone, tb2.gmail, tb2.statusID,tb2.photoUrl,tb1.groupID, tb3.groupName\n"
                        + "FROM (tblUserGroup tb1 INNER JOIN tblUser tb2 ON tb1.userID = tb2.userID \n"
                        + "Left Join tblGroup tb3 ON tb1.groupID = tb3.groupID)\n"
                        + "WHERE tb1.userID IS NOT NULL AND (tb2.roleID = 'US' OR tb2.roleID = 'LD') AND tb1.groupID = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, groupIdSearch);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String username = rs.getString("name");
                    String phone = rs.getString("phone");
                    String gmail = rs.getString("gmail");
                    String role = rs.getString("roleID");
                    String statusID = rs.getString("statusID");
                    String photoUrl = rs.getString("photoUrl");
                    String groupID = rs.getString("groupID");
                    String groupName = rs.getString("groupName");
                    list.add(new GroupDTO(groupID, groupName, userID, username, "", role, gmail, phone, statusID, photoUrl));
                }
            }
        } catch (Exception e) {
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

    public int getGroupIDByUserID(String userID) throws SQLException {
        int groupID = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT groupID "
                        + " FROM tblUserGroup "
                        + " WHERE userID = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    groupID = rs.getInt("groupID");
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
        return groupID;
    }

    public GroupDTO getGroupByGroupID(int groupID) throws SQLException {
        GroupDTO group = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT groupName, capstoneID, numberOfPerson, statusID "
                        + " FROM tblGroup "
                        + " WHERE groupID like ? ";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, groupID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String groupName = rs.getString("groupName");
                    int capstoneID = rs.getInt("capstoneID");
                    int numOfPer = rs.getInt("numberOfPerson");
                    int groupStatus = rs.getInt("statusID");
                    group = new GroupDTO(groupID, groupName, capstoneID, numOfPer, groupStatus);
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
        return group;
    }

    public boolean insertUserGroup(List<UserDTO> list, int groupID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " INSERT INTO tblUserGroup(userGroupID, userID, groupID, isSupervisor) "
                        + " VALUES ";
                for (UserDTO user : list) {
                    sql += "(?,?,?,?),";
                }
                sql = sql.substring(0, sql.length() - 1);
                stm = conn.prepareStatement(sql);
                int count = 1;
                int maxUGID = getMaxUserGroupID() + 1;
                for (UserDTO user : list) {
                    stm.setInt(count++, maxUGID++);
                    stm.setString(count++, user.getUserID());
                    stm.setInt(count++, groupID);
                    stm.setInt(count++, 0);
                }
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
