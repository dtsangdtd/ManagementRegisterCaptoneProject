<%-- 
    Document   : admin
    Created on : Dec 16, 2021, 9:01:20 AM
    Author     : mac
--%>

<%@page import="user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"AD".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        <h1>Welcome AD</h1>
        <form action="MainController">          
            <input  type="submit" name="action" value="Logout"/>
        </form>
    </body>
</html>
