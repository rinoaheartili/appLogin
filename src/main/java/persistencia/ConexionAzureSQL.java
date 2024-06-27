/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author alberto
 */
public class ConexionAzureSQL 
{
    public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException
    {
        Context initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource)envContext.lookup("jdbc/appLogin");
        Connection conexion = ds.getConnection();
        return conexion;
    }

    public static Statement getStatement() throws ClassNotFoundException, SQLException, NamingException
    {
        Statement estado = null;
        estado = ConexionAzureSQL.getConnection().createStatement();
        return estado;
    }
    
    public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException, NamingException
    {
        PreparedStatement estado = ConexionAzureSQL.getConnection().prepareStatement(sql);
        return estado;
    }
    
    public static ResultSet getResultSet(String consulta) throws ClassNotFoundException, SQLException, NamingException
    {
        ResultSet query = null;
        query = ConexionAzureSQL.getStatement().executeQuery(consulta);
        return query;
    }
    
    public static void Cerrar(Connection conexion) throws SQLException
    {
        conexion.close();
    }
    
    public static void Cerrar(Statement estado) throws SQLException
    {
        estado.close();
    }
    
    public static void Cerrar(PreparedStatement estado) throws SQLException
    {
        estado.close();
    }
    
    public static void Cerrar(ResultSet resultado) throws SQLException
    {
        resultado.close();
    }
    
}
