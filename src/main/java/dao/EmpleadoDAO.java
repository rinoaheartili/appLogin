package dao;

import controller.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.naming.NamingException;
import modelo.Empleado;
import persistencia.ConexionAzureSQL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alberto
 */
public class EmpleadoDAO 
{
    Connection conn = null;
    Statement stm=null;
    ResultSet empleadoResultSet;
    Empleado empleadoHallado;
    int id;
    String nombre, apellidoPa, apellidoMa, contrasenia, cargo;
    private ArrayList<Empleado> listEmpleados;
    

    public EmpleadoDAO() 
    {
        this.listEmpleados = new ArrayList<Empleado>();
    }
    
    public boolean agregar(int id, String nombre, String apellidoPa, String apellidoMa, String contrasenia, String cargo)
    {
        int resultUpdate = 0;
        try{
            conn = ConexionAzureSQL.getConnection();
            stm = ConexionAzureSQL.getStatement();
            empleadoResultSet = ConexionAzureSQL.getResultSet("insert into empleado values ('" + id + "','" + nombre + "','" + apellidoPa + "','" + apellidoMa + "','"+ contrasenia + "','" + cargo + "');");
            if(resultUpdate != 0)
            {
                ConexionAzureSQL.Cerrar(conn);
                return true;
            }else
            {
                ConexionAzureSQL.Cerrar(conn);
                return false;
            }
        }catch(Exception e)
        {
            Logger logger = Logger.getLogger(Login.class.getName()); 
            logger.info(e.getMessage());
            return false;
        }
    }
    
    public Empleado consultar(String nombre, String contrasenia)
    {
        Logger logger = Logger.getLogger(Login.class.getName());
        try
        {
            conn = ConexionAzureSQL.getConnection();
            stm = ConexionAzureSQL.getStatement();
            empleadoResultSet = ConexionAzureSQL.getResultSet("select * from empleado where nombre = '" + nombre + "' and contrasenia = '" + contrasenia +"';");
            if(!empleadoResultSet.next())
            {
                logger.info("No se encontro registro");
                ConexionAzureSQL.Cerrar(conn);
                return null;
            }else
            {
                logger.info("Se encontro 1 registro");
                this.id = empleadoResultSet.getInt("id");
                this.nombre = empleadoResultSet.getString("nombre");
                this.apellidoPa = empleadoResultSet.getString("apellidoPaterno");
                this.apellidoMa = empleadoResultSet.getString("apellidoMaterno");
                this.contrasenia = empleadoResultSet.getString("contrasenia");
                this.cargo = empleadoResultSet.getString("cargo");
                empleadoHallado = new Empleado(this.id, this.nombre, this.apellidoPa, this.apellidoMa, this.contrasenia, this.cargo);
                return empleadoHallado;
            }
        }catch(ClassNotFoundException | SQLException | NamingException e)
        {
            logger.info(e.getMessage());
            return null;
        }
        
    }
    
    public boolean borrar(String nombre, String contrasenia)
    {
        int resultUpdate = 0;
        Logger logger = Logger.getLogger(Login.class.getName());
        try
        {
            conn = ConexionAzureSQL.getConnection();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("DELETE FROM empleado WHERE (nombre='" + nombre + "'and contrasenia='"+ contrasenia +"');");
            if(resultUpdate != 0)
            {
                ConexionAzureSQL.Cerrar(conn);
                return true;
            }else
            {
                ConexionAzureSQL.Cerrar(conn);
                return false;
            }
        } catch (ClassNotFoundException | SQLException | NamingException e) 
        {
            logger.info(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Empleado> leeTodos()
    {
        Logger logger = Logger.getLogger(Login.class.getName());
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        try{
            conn = ConexionAzureSQL.getConnection();
            stm = conn.createStatement();
            empleadoResultSet = stm.executeQuery("SELECT * FROM empleado");
            if(!empleadoResultSet.next()){
                logger.info("No se encontraron registros");
                ConexionAzureSQL.Cerrar(conn);
                return null;
            }else{
                do{
                    this.id = empleadoResultSet.getInt("id");
                    this.nombre = empleadoResultSet.getString("nombre");
                    this.apellidoPa = empleadoResultSet.getString("apellidoPaterno");
                    this.apellidoMa = empleadoResultSet.getString("apellidoMaterno");
                    this.contrasenia = empleadoResultSet.getString("contrasenia");
                    this.cargo = empleadoResultSet.getString("cargo");
                    empleadoHallado = new Empleado(this.id, this.nombre, this.apellidoPa, this.apellidoMa, this.contrasenia, this.cargo);
                    empleados.add(empleadoHallado);
                }while(empleadoResultSet.next());
                    ConexionAzureSQL.Cerrar(conn);
                    return empleados;
                }
        }catch(Exception e){
            logger.info(e.getMessage());
            return null;
        }
    }
    
}
