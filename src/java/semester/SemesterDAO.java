/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semester;

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
public class SemesterDAO {
     public List<SemesterDTO> getListSemester() throws SQLException {
        List<SemesterDTO> list = new ArrayList<>();
         Connection conn = null;
         PreparedStatement stm = null;
         ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT tblSemester.semesterID, tblSemester.semesterName FROM tblSemester ORDER BY tblSemester.NO DESC ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String semesterID = rs.getString("semesterID");
                    String semesterName = rs.getString("semesterName");
                    list.add(new SemesterDTO(semesterID, semesterName));
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
//        System.out.println(list);
        return list;
    }

}
