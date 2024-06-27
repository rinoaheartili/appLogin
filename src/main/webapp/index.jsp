<%-- 
    Document   : index
    Created on : 26 jun 2024, 9:18:55
    Author     : alberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Bienvenido al sistema login</h1>
        <%@ page import="controller.Login" %>
        <form name="loginForm" method="post" action="login">
            Username: <input type="text" name="username"/> <br/>
            Password: <input type="password" name="password"/> <br/>
            <input type="reset" value="Borrar"/>
            <input type="submit" value="Ingresar"/>
        </form>
        <form action="llenaRegistro.jsp" method="post">
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>
