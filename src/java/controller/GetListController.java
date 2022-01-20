/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import user.UserDAO;
import user.UserDTO;

/**
 *
 * @author Mai
 */
@WebServlet(name = "GetListController", urlPatterns = {"/GetListController"})
public class GetListController extends HttpServlet {
    private static final String AD = "moderator.jsp";
    private static final String MT = "supervisor.jsp";
    private static final String US = "student.jsp";
    private static final String LOGIN = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN;
        try {
            UserDAO dao = new UserDAO();
            HttpSession session = request.getSession();
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            List<UserDTO> listStudent = dao.getListStudent();
            System.out.println(listStudent);
            session.setAttribute("LIST_STUDENT", listStudent);
            List<UserDTO> listSupervisor = dao.getListSupervisor();
            session.setAttribute("LIST_SUPERVISOR", listSupervisor);
            if (loginUser == null) {
                url = LOGIN;
            }else if ("AD".equals(loginUser.getRoleID())){
                url = AD;
            }else if ("MT".equals(loginUser.getRoleID())){
                url = MT;
            }else if ("US".equals(loginUser.getRoleID())){
                url = US;
            }
        } catch (Exception e) {
            log("Error at GetListController" + e.toString());
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
