/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author PNKV
 */
public class TopicDAO {
    public List<TopicDTO> getTopicSearch(String semesterID) throws SQLException {
        List<TopicDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT  c.capstoneID, c.capstoneName, u.name, c.groupID, c.statusID " 
                        + " FROM tblCapstone c full join tblUserCapstone uc on c.capstoneID = uc.capstoneID full join tblUser u on u.userID = uc.userID  "
                        + " WHERE u.semesterID = ? AND u.roleID = 'MT'";
                stm = conn.prepareStatement(sql);
                stm.setString(1, semesterID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int capstoneID = rs.getInt("capstoneID");
                    String capstoneName = rs.getString("capstoneName");
                    String name = rs.getString("name");
                    int groupID = rs.getInt("groupID");
                    int statusID = rs.getInt("statusID");
                    list.add(new TopicDTO(capstoneID, capstoneName, groupID, semesterID, statusID, name));
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
}
