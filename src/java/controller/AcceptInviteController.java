/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import group.GroupDAO;
import group.GroupDTO;
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
            String leaderID = request.getParameter("leaderID"); //lấy ID của leader
            String userID = request.getParameter("userID"); //Lấy ID của người được mời
            UserDAO uDao = new UserDAO();
            UserDTO leader = uDao.getUserByUserID(leaderID); //lấy thông tin leader
            String leaderStatus = leader.getStatusID();
            if (leaderStatus.equals("3")) { //check status của Leader nếu chưa có nhóm
                GroupDAO gDao = new GroupDAO();
                int groupID = gDao.getMaxGroupID() + 1; //Tạo groupID mới -> tạo group mới
                leader.setStatusID("2"); //chuyển vể trạng thái đã có nhóm
                uDao.updateStatusID(leader); //Cập nhật lại User statusID trên sql

                int userGroupID = gDao.getMaxUserGroupID() + 1;
                int isSupervisor = 0;
                UserGroup leaderGroup = new UserGroup(userGroupID, leaderID, groupID, isSupervisor);
                boolean check1 = gDao.acceptInviteGroup(leaderGroup); //Cập nhật userGroup mới trên sql
                if (check1) {
                    String groupName = "Group " + String.valueOf(groupID); //Tên nhóm mới
                    int numOfPer = 1; //Vì là group mới nên hiện tại thành viên chỉ có 1 là leader
                    int capstoneID = 0; //Vì chưa đăng ký đề tài nên để = 0, sau này đăng ký sẽ có chức năng cập nhật lại
                    int groupStatusID = 1;
                    GroupDTO group1 = new GroupDTO(groupID, groupName, capstoneID, numOfPer, groupStatusID);
                    boolean check2 = gDao.addToGroup(group1); //Cập nhật group mới trên sql

                    if (check2) { //Kiemr tra đã cập nhật nhóm mới thành công hay không
                        UserDTO user = uDao.getUserByUserID(userID);
                        user.setStatusID("2"); //Chuyển về trạng thái đã có nhóm
                        uDao.updateStatusID(user); // Cập nhật lại User statusID trên sql

                        userGroupID += 1;
                        UserGroup userGroup = new UserGroup(userGroupID, userID, groupID, isSupervisor);
                        boolean check3 = gDao.acceptInviteGroup(userGroup); //Cập nhật userGroup trên sql

                        if (check3) {
                            numOfPer += 1;
                            GroupDTO group2 = new GroupDTO(groupID, groupName, capstoneID, numOfPer, groupStatusID);
                            boolean check4 = gDao.updateNumberOfPerson(group2); //Tăng số lượng thành viên trong Group trên sql

                            if (check4) {
                                RequestDAO reqDao = new RequestDAO();
                                boolean check5 = reqDao.removeRequest(userID, leaderID); //Xóa request 
                                if (check5) {
                                    url = SUCCESS;
                                }
                            }
                        }
                    }
                }
            } else if (leaderStatus.equals("2")) { //check status của Leader nếu đã có nhóm
                UserDTO user = uDao.getUserByUserID(userID);
                user.setStatusID("2"); //Chuyển về trạng thái đã có nhóm
                uDao.updateStatusID(user); // Cập nhật lại User statusID trên sql

                GroupDAO gDao = new GroupDAO();
                int userGroupID = gDao.getMaxUserGroupID() + 1;
                int isSupervisor = 0;
                int groupID = gDao.getGroupIDByUserID(leaderID); //Lấy groupID của leader
                UserGroup userGroup = new UserGroup(userGroupID, userID, groupID, isSupervisor);
                boolean check1 = gDao.acceptInviteGroup(userGroup); //Cập nhật userGroup trên sql

                if (check1) {
                    GroupDTO group = gDao.getGroupByGroupID(groupID);
                    int numOfPer = group.getNumOfPer() + 1;
                    GroupDTO group2 = new GroupDTO(numOfPer, groupID);
                    boolean check2 = gDao.updateNumberOfPerson(group2); //Tăng số lượng thành viên trong Group trên sql

                    if (check2) {
                        RequestDAO reqDao = new RequestDAO();
                        boolean check3 = reqDao.removeRequest(userID, leaderID); // Xóa request
                        if (check3) url = SUCCESS;
                    }
                }
            }
        } catch (Exception e) {
            log("Error at AcceptInviteController" + e.toString());
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
