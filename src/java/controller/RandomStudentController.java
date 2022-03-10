/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import group.Cart;
import group.GroupDAO;
import group.GroupDTO;
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
            String semesterID = request.getParameter("semesterID");
            List<UserDTO> listStudentNoGroup = dao.getListStudentNoGroup(semesterID);
            int n = listStudentNoGroup.size();
            SemesterDAO daoSes = new SemesterDAO();
            int maxSesID = daoSes.getMaxSemesterNO();
            SemesterDTO sesmester = daoSes.getSemester(maxSesID);
            GroupDAO daoGroup = new GroupDAO();
            if (sesmester.getSemesterID().equalsIgnoreCase(semesterID)) {
                boolean check = daoSes.insertNewSesmester(semesterID);
            }
            boolean flag = true;
            //boolean check = (!semesterID.equalsIgnoreCase(sesmester.getSemesterID())) ? daoSes.insertNewSesmester(semesterID) : true;
            if (sesmester.getSemesterID().equalsIgnoreCase(semesterID)) {
                boolean check = daoSes.insertNewSesmester(semesterID);
            }
            GroupDAO daoGroup = new GroupDAO();
            if (n < 4) {
                System.out.println("case n<4");
                for (UserDTO userDTO : listStudentNoGroup) {
                    boolean check2 = dao.updateStudentRedundant(userDTO.getUserID(), sesmester.getSemesterID());
                    if (!check2) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    url = SUCCESS;
                }
            } else {
                System.out.println("case n>4");
                int num = n / 5;
                int mod = n % 5;
                GroupDAO daoGroup = new GroupDAO();
                int key = daoGroup.getMaxGroupID();
                Cart map = new Cart();
                for (int i = 0; i < num; i++) {
                    System.out.println(i + " " + num + " " + listStudentNoGroup.size());
                    map.add(key, listStudentNoGroup.subList(i, (i + 1) * 5));
                    key++;
                    String groupName = "Group" + String.valueOf(key);
                    int capstoneID = 0;
                    int numOfPer = 0;
                    int statusID = 5;
                    GroupDTO group = new GroupDTO(statusID, groupName, capstoneID, numOfPer, statusID);
                }
                List<UserDTO> list = null;
                switch (mod) {
                    case 1: // 1 stu doesn't have group
                        System.out.println("case mod5 = 1");
                        if (num < 3) {
                            boolean checkStu = dao.updateStudentRedundant(listStudentNoGroup.get(n).getUserID(), sesmester.getSemesterID());
                            if (checkStu) {
                                url = SUCCESS;
                            }
                        } else {
                            // lấy list group 5 mới tạo key lớn nhất
                            list.add(map.getUser(key));
                            list.add(map.getUser(key - 1));
                            list.add(map.getUser(key - 2));
                            map.add(key+1, list);
                            // lưu trong tblGroup
                            // update status User= 2 
                            for (UserDTO userDTO : listStudentNoGroup) {
                                userDTO.setStatusID("2");
                                boolean checkStatus = dao.updateStatusID(userDTO);
                                if (!checkStatus) {
                                    flag = false;
                                    break;
                                }
                            }

                        }
                        break;
                    case 2:
                        list = listStudentNoGroup.subList(n - 2, n);
                        if (num < 2) {
                            // chuyển sang học kì sau
                        } else {
                            list.add(map.getUser(key));
                            list.add(map.getUser(key - 1));
                            map.add(key+1, list);
                        }
                        break;
                    case 3:
                        list = listStudentNoGroup.subList(n - 3, n);
                        if (num == 1) {
                            // chuyển sang học kì sau
                        } else {
                            list.add(map.getUser(key));
                            map.add(key+1, list);
                            
                        }
                        break;
                }
                for (Map.Entry<Integer, List<UserDTO>> group : map.getCart().entrySet()) {
                    int groupID = group.getKey();
                    System.out.println("group: " + groupID);
                    List listUser = group.getValue();
                    System.out.println("list: " + listUser.size());
                    // set status User = 2
                    // insert tbl UserGroup
                    boolean insertUG = daoGroup.insertUserGroup(listUser, groupID);
                    if (!insertUG) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    url = SUCCESS;
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
