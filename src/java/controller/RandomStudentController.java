/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import group.Cart;
import group.GroupDAO;
import group.UserGroup;
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
@WebServlet(name = "RandomStudentController", urlPatterns = {"/RandomStudentController"})
public class RandomStudentController extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String SUCCESS = "modStudentList.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            UserDAO dao = new UserDAO();
            HttpSession session = request.getSession();
            List<UserDTO> listStudentNoGroup = dao.getListStudentNoGroup();
            int n = listStudentNoGroup.size();

            if (n < 4) {

            } else {
                int num = n / 5;
                int mod = n % 5;
                GroupDAO daoGroup = new GroupDAO();
                int key = daoGroup.getMaxUserGroupID();
//                UserGroup map = (UserGroup) session.getAttribute("GROUP");
                Cart map = (Cart) session.getAttribute("GROUP");
                for (int i = 0; i < num; i++) {
                    map.add(key, listStudentNoGroup.subList(i, (i + 1) * 5));
                    key++;
                }
                List<UserDTO> list = null;
                switch (mod) {
                    case 1:
                        list.add(listStudentNoGroup.get(n)); // list dư
                        if (num < 3) {
                            // chuyển sang học kì sau

                        } else {
                            // lấy list group 5 mới tạo key lớn nhất
//                            list = map.getGroup(key);
                            list.add(map.getUser(key));
                            list.add(map.getUser(key - 1));
                            list.add(map.getUser(key - 2));
                            map.add(key+1, list);
                            // lưu trong database
                        }
                        break;
                    case 2:
                        list = listStudentNoGroup.subList(n - 1, n);
                        if (num < 2) {
                            // chuyển sang học kì sau
                        } else {
                            list.add(map.getUser(key));
                            list.add(map.getUser(key - 1));
                            map.add(key+1, list);
                        }
                        break;
                    case 3:
                        list = listStudentNoGroup.subList(n - 2, n);
                        if (num == 1) {
                            // chuyển sang học kì sau
                        } else {
                            list.add(map.getUser(key));
                            map.add(key+1, list);
                        }
                        break;
                }
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
