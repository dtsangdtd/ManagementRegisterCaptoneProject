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
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author mac
 */
public class UserDAO {

    public UserDTO checkLogin(String gmail, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT u.name, u.roleID, u.userID, s.statusID, u.photoUrl, u.phone "
                        + "FROM tblUser u, tblStatus s "
                        + "WHERE u.statusID = s.statusID AND gmail=? AND password=? AND s.statusID != 0";
                stm = conn.prepareStatement(sql);
                stm.setString(1, gmail);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String username = rs.getString("name");
                    String roleID = rs.getString("roleID");
                    String userID = rs.getString("userID");
                    String statusID = rs.getString("statusID");
                    String photo = rs.getString("photoUrl");
                    String phone = rs.getString("phone");
                    user = new UserDTO(userID, username, password, roleID, gmail, phone, statusID, photo);
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
        return user;
    }

    public UserDTO checkLoginGG(String gmail) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT u.name, u.password, u.roleID, u.userID, s.statusID, u.photoUrl, u.phone "
                        + "FROM tblUser u, tblStatus s "
                        + "WHERE u.statusID = s.statusID AND gmail=? AND s.statusID != 0 ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, gmail);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String username = rs.getString("name");
                    String password = rs.getString("password");
                    String roleID = rs.getString("roleID");
                    String userID = rs.getString("userID");
                    String statusID = rs.getString("statusID");
                    String photoUrl = rs.getString("photoUrl");
                    String phone = rs.getString("phone");
                    user = new UserDTO(userID, username, password, roleID, gmail, phone, statusID, photoUrl);
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
        return user;
    }

    public List<UserDTO> getListStudent() throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT userID, name, gmail, phone, photoUrl, statusID "
                        + " FROM tblUser "
                        + " WHERE [roleID] = 'US' ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String username = rs.getString("name");
                    String gmail = rs.getString("gmail");
                    String phone = rs.getString("phone");
                    String photoUrl = rs.getString("photoUrl");

                    String statusID = rs.getString("statusID");
                    list.add(new UserDTO(userID, username, "", "US", gmail, phone, statusID, photoUrl));
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
        System.out.println(list);
        return list;
    }

    public List<UserDTO> getListStudentSemeter() throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT tblUser.userID, tblUser.semeterID, tblSemeter.semeterName"
                        + " FROM tblSemeter, tblSemeter "
                        + " WHERE tblUser.semeterID = tblSemeter.SemeterName";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String semeterID = rs.getString("semeterID");
                    String semeterName = rs.getString("semeterName");
                    list.add(new UserDTO(semeterID, semeterName));
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
        System.out.println(list);
        return list;
    }

    public List<UserDTO> getListSupervisor() throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT userID, name, gmail, phone, photoUrl, statusID "
                        + " FROM tblUser "
                        + " WHERE [roleID] = 'MT' ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String username = rs.getString("name");
                    String gmail = rs.getString("gmail");
                    String phone = rs.getString("phone");
                    String photoUrl = rs.getString("photoUrl");

                    String statusID = rs.getString("statusID");
                    list.add(new UserDTO(userID, username, "", "MT", gmail, phone, statusID, photoUrl));
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

    public List<UserDTO> getListStudentNoGroup() throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT userID, name, gmail, phone, photoUrl, statusID "
                        + " FROM tblUser "
                        + " WHERE [statusID] = '2' ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String username = rs.getString("name");
                    String gmail = rs.getString("gmail");
                    String phone = rs.getString("phone");
                    String photoUrl = rs.getString("photoUrl");
                    String statusID = rs.getString("statusID");
                    list.add(new UserDTO(userID, username, "", "US", gmail, phone, statusID, photoUrl));
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

    public UserDTO getInforUser(String userIDValue) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT tblUser.userID, tblUser.name, tblUser.gmail, tblUser.phone,"
                        + " tblUser.photoUrl, tblSemester.semesterName,tblCapstone.capstoneName"
                        + " FROM tblUser Left Join tblUserCapstone ON tblUser.userID = tblUserCapstone.userID "
                        + "Left Join tblCapstone ON tblUserCapstone.capstoneID = tblCapstone.capstoneID  "
                        + "Left Join tblSemester ON tblUser.semesterID = tblSemester.semesterID where tblUser.userID = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userIDValue);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String userID = rs.getString("userID");
                    String name = rs.getString("name");
                    String gmail = rs.getString("gmail");
                    String phone = rs.getString("phone");
                    String photoUrl = rs.getString("photoUrl");
                    String semesterName = rs.getString("semesterName");
                    String capstoneName = rs.getString("capstoneName");
                    user = new UserDTO(userID, name, gmail, phone, photoUrl, semesterName, capstoneName);
                    if (user != null) {
                        return user;
                    }
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
        return null;

    }

    public boolean updateInfor(String name, String phone, String photoUrl, String userID) throws SQLException {
        int row = 0;
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "UPDATE tblUser \n"
                    + "SET name = ? , phone = ?, photoUrl = ? "
                    + "WHERE userID = ? ";
            stm = conn.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, phone);
            stm.setString(3, photoUrl);
            stm.setString(4, userID);
            row = stm.executeUpdate();
            if (row > 0) {
                return true;
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
        return false;
    }

    public int getNoOfRecordsSearchAdmin(int check) throws SQLException {
        int result = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = null;

                if (check == 1) {
                    sql = "SELECT count(*) as noRecord \n"
                            + "FROM tblUser \n"
                            + "WHERE  tblUser.roleID = 'US'";
                } else if (check == 0) {
                    sql = "SELECT count(*) as noRecord "
                            + "FROM tblUser\n"
                            + "LEFT JOIN tblUserGroup tblUserGroup ON tblUserGroup.userID = tblUser.userID\n"
                            + "WHERE tblUserGroup.userID IS NULL AND tblUser.roleID = 'US'";
                }
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getInt("noRecord");
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
        return result;
    }

    public List<UserDTO> getUserSearch(int pagesize, int pageNumber, int check) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = null;
                if (check == 1) {
                    sql = "SELECT tblUser.userID, tblUser.name, tblUser.gmail, tblUser.phone, tblUser.photoUrl, tblUser.statusID \n"
                            + "FROM tblUser\n"
                            + "WHERE tblUser.roleID = 'US'"
                            + "ORDER BY (SELECT NULL)"
                            + "OFFSET ? * (? - 1) ROWS "
                            + "FETCH NEXT ? ROWS ONLY ";
                } else if (check == 0) {
                    sql = "SELECT tblUser.userID, tblUser.name, tblUser.gmail, tblUser.phone, tblUser.photoUrl, tblUser.statusID \n"
                            + "FROM tblUser\n"
                            + "LEFT JOIN tblUserGroup tblUserGroup ON tblUserGroup.userID = tblUser.userID\n"
                            + "WHERE tblUserGroup.userID IS NULL AND tblUser.roleID = 'US'"
                            + "ORDER BY (SELECT NULL)"
                            + "OFFSET ? * (? - 1) ROWS "
                            + "FETCH NEXT ? ROWS ONLY ";
                }
                stm = conn.prepareStatement(sql);
                stm.setInt(1, pagesize);
                stm.setInt(2, pageNumber);
                stm.setInt(3, pagesize);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String username = rs.getString("name");
                    String gmail = rs.getString("gmail");
                    String phone = rs.getString("phone");
                    String photoUrl = rs.getString("photoUrl");
                    String statusID = rs.getString("statusID");
                    list.add(new UserDTO(userID, username, "", "US", gmail, phone, statusID, photoUrl));
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

    public UserDTO getUserByUserID(String userID) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT name, gmail, phone, roleID"
                        + " FROM tblUser"
                        + " WHERE userID like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userName = rs.getString("name");
                    String gmail = rs.getString("gmail");
                    String phone = rs.getString("phone");
                    String roleID = rs.getString("roleID");
                    user = new UserDTO(userID, userName, roleID, gmail, phone);
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
        return user;
    }

    public int getNoOfRecordsSupervisor(int check) throws SQLException {
        int result = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = null;

                if (check == 1) {
                    sql = "Select count(*) as noRecord from (SELECT tb1.userID, tb1.name,tb1.gmail, tb1.statusID,tb4.capstoneName,tb5.groupID, tb5.groupName\n"
                            + "FROM tblUser tb1 LEFT JOIN tblUserGroup tb2 ON tb1.userID = tb2.userID \n"
                            + "Left Join tblUserCapstone tb3 ON tb1.userID = tb3.userID \n"
                            + "Left Join tblCapstone tb4 ON tb3.capstoneID = tb4.capstoneID\n"
                            + "Left Join tblGroup tb5 ON tb4.groupID = tb5.groupID\n"
                            + "WHERE tb1.roleID = 'MT'\n"
                            + "GROUP BY tb1.userID, tb1.name,tb1.gmail,tb1.statusID, tb4.capstoneName,tb5.groupID,tb5.groupName\n"
                            + "HAVING COUNT (tb2.userID) = 5) tableCount";
                } else if (check == 0) {
                    sql = "Select count(*) as noRecord from (SELECT tb1.userID, tb1.name,tb1.gmail, tb1.statusID,tb4.capstoneName,tb5.groupID, tb5.groupName\n"
                            + "FROM tblUser tb1 LEFT JOIN tblUserGroup tb2 ON tb1.userID = tb2.userID \n"
                            + "Left Join tblUserCapstone tb3 ON tb1.userID = tb3.userID \n"
                            + "Left Join tblCapstone tb4 ON tb3.capstoneID = tb4.capstoneID\n"
                            + "Left Join tblGroup tb5 ON tb4.groupID = tb5.groupID\n"
                            + "WHERE tb1.roleID = 'MT'\n"
                            + "GROUP BY tb1.userID, tb1.name,tb1.gmail,tb1.statusID, tb4.capstoneName,tb5.groupID,tb5.groupName\n"
                            + "HAVING COUNT (tb2.userID) < 5) tableCount";
                }
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getInt("noRecord");
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
        return result;
    }

    public List<UserDTO> getSupervisorSearch(int pagesize, int pageNumber, int check) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = null;
                if (check == 1) {
                    sql = "SELECT  tb1.userID, tb1.name,tb1.gmail, tb1.statusID,tb4.capstoneName,tb5.groupID, tb5.groupName, COUNT (tb2.userID) AS AmountGroup\n"
                            + "FROM (tblUser tb1 LEFT JOIN tblUserGroup tb2 ON tb1.userID = tb2.userID \n"
                            + "Left Join tblUserCapstone tb3 ON tb1.userID = tb3.userID \n"
                            + "Left Join tblCapstone tb4 ON tb3.capstoneID = tb4.capstoneID\n"
                            + "Left Join tblGroup tb5 ON tb4.groupID = tb5.groupID\n"
                            + ")\n"
                            + "WHERE tb1.roleID = 'MT'\n"
                            + "GROUP BY tb1.userID, tb1.name,tb1.gmail,tb1.statusID, tb4.capstoneName,tb5.groupID,tb5.groupName HAVING COUNT (tb2.userID) = 5 "
                            + "ORDER BY (SELECT NULL)"
                            + "OFFSET ? * (? - 1) ROWS "
                            + "FETCH NEXT ? ROWS ONLY ";

                } else if (check == 0) {
                    sql = "SELECT  tb1.userID, tb1.name,tb1.gmail, tb1.statusID,tb4.capstoneName,tb5.groupID, tb5.groupName, COUNT (tb2.userID) AS AmountGroup\n"
                            + "FROM (tblUser tb1 LEFT JOIN tblUserGroup tb2 ON tb1.userID = tb2.userID \n"
                            + "Left Join tblUserCapstone tb3 ON tb1.userID = tb3.userID \n"
                            + "Left Join tblCapstone tb4 ON tb3.capstoneID = tb4.capstoneID\n"
                            + "Left Join tblGroup tb5 ON tb4.groupID = tb5.groupID\n"
                            + ")\n"
                            + "WHERE tb1.roleID = 'MT'\n"
                            + "GROUP BY tb1.userID, tb1.name,tb1.gmail,tb1.statusID, tb4.capstoneName,tb5.groupID,tb5.groupName HAVING COUNT (tb2.userID) < 5"
                            + "ORDER BY (SELECT NULL)"
                            + "OFFSET ? * (? - 1) ROWS "
                            + "FETCH NEXT ? ROWS ONLY ";

                }
                stm = conn.prepareStatement(sql);
                stm.setInt(1, pagesize);
                stm.setInt(2, pageNumber);
                stm.setInt(3, pagesize);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String username = rs.getString("name");
                    String gmail = rs.getString("gmail");
                    String statusID = rs.getString("statusID");
                    String capstoneName = rs.getString("capstoneName");
                    String groupID = rs.getString("groupID");
                    String groupName = rs.getString("groupName");
                    String amountGroup = rs.getString("AmountGroup");
                    list.add(new UserDTO(userID, username, "US", gmail, statusID, capstoneName, groupID, groupName, amountGroup));
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

    public boolean updateStudentRedundant(UserDTO user) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " UPDATE tblUser set sesmesterID=? "
                        + " WHERE userID=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getSemesterName());
                result = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

}
