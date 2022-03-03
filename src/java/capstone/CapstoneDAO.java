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

}
