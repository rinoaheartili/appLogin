<%-- 
    Document   : llenaRegistro
    Created on : 27 jun 2024, 15:43:53
    Author     : alberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Llena Registro</title>
    </head>
    <body>
        <%@ page import="controller.Registro" %>
        <%
            String nombre = request.getParameter("nombre");
            String password = request.getParameter("contrasenia");
        %>
        <h3>Registra tus datos</h3>
        <form>
            <table cellspacing="3" cellpadding="3" border="1" >
                <tr>
                    <td align="right"> Id: </td>
                    <td><input type="text" name="id"></td>
                </tr>
                <tr>
                    <td align="right"> Nombre: </td>
                    <td><input type="text" name="nombre" value="<%=nombre %>"></td>
                </tr>
                <tr>
                    <td align="right"> Apellido Paterno: </td>
                    <td><input type="text" name="apePaterno"></td>
                </tr>
                <tr>
                    <td align="right"> Apellido Materno: </td>
                    <td><input type="text" name="apeMaterno"></td>
                </tr>
                <tr>
                    <td align="right"> Contraseña: </td>
                    <td><input type="text" name="contrasenia" value="<%=password %>"></td>
                </tr>
                <tr>
                    <td align="right"> Cargo: </td>
                    <td><input type="text" name="cargo"></td>
                </tr>
            </table>
            <input type="reset" value="Borrar">
            <input type="submit" value="Guardar">
        </form>
        <form action="index.jsp" method="post">
            <input type="submit" value="Regresar">
        </form>
    </body>
</html>
