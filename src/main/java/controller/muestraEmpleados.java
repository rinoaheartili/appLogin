/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleado;

/**
 *
 * @author alberto
 */
@WebServlet(name = "muestraEmpleados", urlPatterns = {"/muestraEmpleados"})
public class muestraEmpleados extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            ArrayList <Empleado> empleados = new ArrayList<Empleado>();
            Empleado empleado;
            EmpleadoDAO empleadoBD = new EmpleadoDAO();

            empleados = empleadoBD.leeTodos();
            if (empleados != null){
                request.setAttribute("Empleados", empleados);
                request.getRequestDispatcher("/listaEmpleados.jsp").forward(request, response);
            }else
                request.getRequestDispatcher("/noHayRegistros.jsp").forward(request, response);
            } finally {
                out.close();
        }
    
    }
    
}
