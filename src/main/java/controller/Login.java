package controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger; 

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alberto
 */
@WebServlet("/login")
public class Login extends HttpServlet
{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try
        {
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            Double promedio = Double.parseDouble(request.getParameter("prom"));
            
            /*Alumno alumno = new Alumno(nombre, apellidos, promedio);*/
            
            /*request.setAttribute("atribAlumn", alumno);
            request.getRequestDispatcher("/muestraRegistroServletV2.jsp").forward(request, response);*/
            
        }finally
        {
            out.close();
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Logger logger = Logger.getLogger(Login.class.getName()); 
        logger.info(request.getParameter("username"));
        logger.info(request.getParameter("password"));
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
    }
    
}
