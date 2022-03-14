/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upload;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import user.UserDTO;
import utils.DBUtils;

/**
 *
 * @author Mai
 */
public class UploadDAO {

    public List<UserDTO> listUser;

    public List<UserDTO> getListUser() {
        return listUser;
    }

    public int readFile_Student(String filename) throws FileNotFoundException, IOException {
        FileInputStream excelFile = new FileInputStream(new File(filename));
        Workbook workBook = null;
        if (filename.endsWith("xlsx")) {
            workBook = new XSSFWorkbook(excelFile);
        } else if (filename.endsWith("xls")) {
            workBook = new HSSFWorkbook(excelFile);
        }
        Sheet datatypeSheet = workBook.getSheetAt(0);
        DataFormatter fmt = new DataFormatter();
        Iterator<Row> iterator = datatypeSheet.iterator();
        Row firstRow = iterator.next();
        Cell firstCell = firstRow.getCell(0);
        try {
            int count = 0;
            while (iterator.hasNext()) {
                UserDTO user = new UserDTO();
                Row currentRow = iterator.next();
                String userID = currentRow.getCell(0).getStringCellValue();
                user.setUserID(userID);
                String userName = currentRow.getCell(1).getStringCellValue();
                user.setUsername(userName);
                String gmail = currentRow.getCell(2).getStringCellValue();
                user.setGmail(gmail);
                String semesterID = currentRow.getCell(3).getStringCellValue();
                user.setSemesterName(semesterID);
                if (this.listUser == null) {
                    this.listUser = new ArrayList<>();
                }
                this.listUser.add(user);
                count++;
            }
            if (count == 0) {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (workBook != null) {
                workBook.close();
            }
            if (excelFile != null) {
                excelFile.close();
            }
        }
        return 1;
    }

    public boolean pushExcelList(List<UserDTO> list) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {  
                String sql = " INSERT INTO tblUser(userID, name, gmail, statusID, semesterID)"
                        + " VALUES(?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                for (UserDTO user : list) {
                    stm.setString(1, user.getUserID());
                    stm.setString(2, user.getUsername());
                    stm.setString(3, user.getGmail());
                    stm.setInt(4, 2);
                    stm.setString(5, user.getSemesterName());
                    check = stm.executeUpdate() > 0 ? true : false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                stm.close();
            }
        }
        return check;
    }
}
