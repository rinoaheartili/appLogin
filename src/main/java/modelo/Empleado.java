/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alberto
 */
public class Empleado 
{
    private int id;
    private String nombre;
    private String apellidoPa;
    private String apellidoMa;
    private String contrasenia;
    private String cargo;

    public Empleado(int id, String nombre, String apellidoPa, String apellidoMa, String contrasenia, String cargo) 
    {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPa = apellidoPa;
        this.apellidoMa = apellidoMa;
        this.contrasenia = contrasenia;
        this.cargo = cargo;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getApellidoPa() 
    {
        return apellidoPa;
    }

    public void setApellidoPa(String apellidoPa) 
    {
        this.apellidoPa = apellidoPa;
    }

    public String getApellidoMa() 
    {
        return apellidoMa;
    }

    public void setApellidoMa(String apellidoMa) 
    {
        this.apellidoMa = apellidoMa;
    }

    public String getContrasenia() 
    {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) 
    {
        this.contrasenia = contrasenia;
    }

    public String getCargo() 
    {
        return cargo;
    }

    public void setCargo(String cargo) 
    {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Id: \n" + id + "Nombre: \n" + nombre + "Apellido Paterno: \n" + apellidoPa + "Apellido Materno: \n" + apellidoMa + "Contrasenia: \n" + contrasenia + "Cargo: " + cargo;
    }
    
}
