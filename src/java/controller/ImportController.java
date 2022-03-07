/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.DBUtils;

/**
 *
 * @author denwi
 */
@WebServlet(name = "ImportController", urlPatterns = {"/ImportController"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class ImportController extends HttpServlet {

    private static String SUCCESS = "modStudentList.jsp";
    private static String ERROR = "modStudentList.jsp";
    private final String UPLOAD_DIRECTORY = "C:\\demo";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = ERROR;
        ArrayList cellArrayListHolder = new ArrayList();
        String btn = request.getParameter("action");
        try {
            if (btn != null) {
                if (btn.equals("Import Excel")) {
                    Connection conn = DBUtils.getConnection();
                    String Path = "upload";
                    String absolutepath = getServletContext().getRealPath(Path);
                    MultipartRequest mr = new MultipartRequest(request, absolutepath);
                    String filename = mr.getOriginalFileName("filename");
//                    MultipartRequest mr = new MultipartRequest(request, UPLOAD_DIRECTORY);
//                    File filename = mr.getFile("filename");
//                    String uploadedfilename = mr.getFilesystemName("filename");
                    FileInputStream myinput = new FileInputStream(new File(absolutepath + "/" + filename));
//                    File newfileloc = new File(UPLOAD_DIRECTORY + "/" + uploadedfilename);
//                    FileInputStream myinput = new FileInputStream(new File("C:\\demo\\test.xlsx"));
                    Workbook workbook = new XSSFWorkbook(myinput);
//                    FileInputStream myinput = new FileInputStream("E:\\stu.xlsx");
                    Sheet firstSheet = workbook.getSheetAt(0);
                    Iterator<Row> iterator = firstSheet.iterator();
                    while (iterator.hasNext()) {
                        XSSFRow nextRow = (XSSFRow) iterator.next();
                        ArrayList rowarrylist = new ArrayList();
                        Iterator<Cell> cellIterator = nextRow.cellIterator();

                        while (cellIterator.hasNext()) {
                            XSSFCell cell = (XSSFCell) cellIterator.next();
                            rowarrylist.add(cell);
                        }
                        cellArrayListHolder.add(rowarrylist);
                    }
                    out.println(cellArrayListHolder);
                    ArrayList rowarrylist = null;
                    PreparedStatement stm = conn.prepareStatement("INSERT INTO  tblUser(userID, name, gmail, statusID, roleID, semesterID) VALUES (?,?,?,?,?,?)");
                    for (int i = 1; i < cellArrayListHolder.size(); i++) {
                        rowarrylist = (ArrayList) cellArrayListHolder.get(i);
                        stm.setString(1, rowarrylist.get(0)
                                .toString());
                        stm.setString(2, rowarrylist.get(1).toString());
                        stm.setString(3, rowarrylist.get(2).toString());
                        stm.setString(4, rowarrylist.get(3).toString());
                        stm.setString(5, rowarrylist.get(4).toString());
                        stm.setString(6, rowarrylist.get(5).toString());
                        stm.executeUpdate();
                    }
                }
            }

        } catch (Exception e) {
            log("Error at ImportController" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
