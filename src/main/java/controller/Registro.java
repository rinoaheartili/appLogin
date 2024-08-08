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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author alberto
 */
@WebServlet(name = "registro", urlPatterns = {"/registro"})
public class Registro extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String apellidoPa = request.getParameter("apePaterno");
            String apellidoMa = request.getParameter("apeMaterno");
            String contrasenia = request.getParameter("contrasenia");
            String cargo = request.getParameter("cargo");
            EmpleadoDAO empleadoBD = new EmpleadoDAO();
            if (empleadoBD.agregar(id, nombre, apellidoPa, apellidoMa, contrasenia, cargo)){
                request.getRequestDispatcher("/registroGuardado.jsp").forward(request, response);
            }else
                request.getRequestDispatcher("/errorEnRegistro.jsp").forward(request, response);
        } finally {
            out.close();
        }
    }
}
