/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import group.GroupDAO;
import group.GroupDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import request.RequestDAO;
import user.UserDAO;
import user.UserDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "AcceptInviteController", urlPatterns = {"/AcceptInviteController"})
public class AcceptInviteController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final String SUCCESS = "student.jsp";
    private static final String ERROR = "studentRequest.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String leaderID = request.getParameter("leaderID");
            UserDAO uDao = new UserDAO();
            GroupDAO gDao = new GroupDAO();
            UserDTO leader = uDao.getUserByUserID(leaderID);
            UserDTO user = uDao.getUserByUserID(userID);
            String leaderStatus = leader.getStatusID();
            int groupID = Integer.parseInt(leader.getGroupID());
            if (leaderStatus.equals("3")) {
                groupID = gDao.getMaxGroupID() + 1;
                leader.setStatusID("2");
                leader.setGroupID(String.valueOf(groupID));
                user.setStatusID("2");
                user.setGroupID(String.valueOf(groupID));
            }
            if (leader.getGroupID().equals(user.getGroupID())) {
                RequestDAO reqDao = new RequestDAO();
                reqDao.removeRequest(userID, leaderID);
                url = SUCCESS;
            } else {
                //SET ATRIBUTE RỒI BÁO LỖI
            }
        } catch (Exception e) {
            log ("Error at AcceptInviteController" + e.toString());
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
