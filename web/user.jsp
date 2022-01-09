<%-- 
    Document   : user
    Created on : Dec 16, 2021, 9:01:40 AM
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
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null) {
                return;
            }
        %>
        <h1>Welcome user: <%= user.getUsername()%> </h1>   
        <form action="MainController">          
            <input  type="submit" name="action" value="Logout"/>
        </form>
    </body>
</html>
