/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import group.GroupDAO;
import group.UserGroup;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import request.RequestDAO;
import request.RequestDTO;
import user.UserDAO;
import user.UserDTO;
import utils.EmailUtils;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "InviteController", urlPatterns = {"/InviteController"})
public class InviteController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final String SUCCESS = "studentList.jsp";
    private static final String ERROR = "student.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String email = request.getParameter("email");
            String userID = request.getParameter("userID");//userID của người dc mời
            HttpSession session = request.getSession();
            UserDTO loginUser =  (UserDTO) session.getAttribute("LOGIN_USER");  
            String loginUserID = loginUser.getUserID();//lấy userID của người mời
            RequestDAO reqDAO = new RequestDAO();
            int requestID = reqDAO.getMaxRequestID() + 1;//Tạo RequestID mới
            UserDAO usDAO = new UserDAO();
            UserDTO invitedUser =  usDAO.getUserByUserID(userID);
            if ("US".equals(invitedUser.getRoleID())) {
                int isSupervior = 0;
                RequestDTO reqDTO = new RequestDTO(requestID, userID, loginUserID, isSupervior);//Lấy thông tin cho request
                boolean check = reqDAO.inviteGroup(reqDTO); //Insert param vào request 
                if (check) url = SUCCESS;
            } 
            if ("MT".equals(invitedUser.getRoleID())) {
                int isSupervior = 1;
                RequestDTO reqDTO = new RequestDTO(requestID, userID, loginUserID, isSupervior);//Lấy thông tin cho request
                boolean check = reqDAO.inviteGroup(reqDTO); //Insert param vào request 
//                if (check) url = SUCCESS;
            } 
            new Thread(() -> {
                EmailUtils.send(email);
            }).start();
        } catch (Exception e) {
            log ("Error at InviteController" + e.toString());
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
