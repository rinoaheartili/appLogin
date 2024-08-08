/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alberto
 */

@WebServlet(name = "borraUsuario", urlPatterns = {"/borraUsuario"})
public class BorrarUsuario {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String nombre = request.getParameter("nombre");
            String contrasenia= request.getParameter("contrasenia");
            EmpleadoDAO empleadoBD = new EmpleadoDAO();
            if (empleadoBD.borrar(nombre, contrasenia)){
                request.getRequestDispatcher("/registroBorrado.jsp").forward(request, response);
            }else
                request.getRequestDispatcher("/noBorroRegistro.jsp").forward(request, response);
        } finally {
            out.close();
        }
    }
    
}
