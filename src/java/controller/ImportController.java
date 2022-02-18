/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Part;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import utils.DBUtils;

/**
 *
 * @author mac
 */
@WebServlet(name = "ImportController", urlPatterns = {"/ImportController"})
public class ImportController extends HttpServlet {

    public static final String ERROR = "modStudentList.jsp";
    public static final String SUCCESS = "modStudentList.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public class ImportExcel{
        private String userID;
        private String name;
        private String gmail;
        private String phone;
        private int statusID;
        private String roleID;
        private String semesterID;

        public ImportExcel() {
            super();
        }

        public ImportExcel(String userID, String name, String gmail, String phone, int statusID, String roleID, String semesterID) {
            super();
            this.userID = userID;
            this.name = name;
            this.gmail = gmail;
            this.phone = phone;
            this.statusID = statusID;
            this.roleID = roleID;
            this.semesterID = semesterID;
        }

        @Override
        public String toString() {
            return "ImportExcel{" + "userID=" + userID + ", name=" + name + ", gmail=" + gmail + ", phone=" + phone + ", statusID=" + statusID + ", roleID=" + roleID + ", semesterID=" + semesterID + '}';
        }
        

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGmail() {
            return gmail;
        }

        public void setGmail(String gmail) {
            this.gmail = gmail;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getStatusID() {
            return statusID;
        }

        public void setStatusID(int statusID) {
            this.statusID = statusID;
        }

        public String getRoleID() {
            return roleID;
        }

        public void setRoleID(String roleID) {
            this.roleID = roleID;
        }

        public String getSemesterID() {
            return semesterID;
        }

        public void setSemesterID(String semesterID) {
            this.semesterID = semesterID;
        }
        
    }
    
    private static List<ImportExcel> getExcel(){
        List<ImportExcel> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            ImportExcel imp;
            imp = new ImportExcel(i, "Import " + i, i * 2, i * 1000);
            list.add(imp);
        }
        return list;
    }
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
                    String Path = "upload";
                    String absolutepath = getServletContext().getRealPath(Path);
                    MultipartRequest mr = new MultipartRequest(request, absolutepath);
                    String filename = mr.getOriginalFileName("filename");
                    FileInputStream myinput = new FileInputStream(new File(absolutepath + "/" + filename));
                     
                }
            }
        } catch (Exception e) {
            log("Error at ImportController" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            out.close();
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
