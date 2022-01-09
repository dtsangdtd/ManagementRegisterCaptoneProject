<%-- 
    Document   : login
    Created on : Dec 15, 2021, 8:08:39 PM
    Author     : mac
--%>
        
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>login</h1>
        <form action="MainController" method="POST" >
            <input type="text" name="userID" placeholder="Username" />
            <input type="password" name="password" placeholder="Password" />
            <input type="submit" name="action" value="Login"/>
        </form>
        <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/LoginGG/login-google&response_type=code
           &client_id=130712381079-lsfn0bj6q55gicpnofp13tbaa5jh59ra.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>
    </body>
</html>
