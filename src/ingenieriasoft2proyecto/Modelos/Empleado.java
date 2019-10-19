/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto.Modelos;

import java.util.Date;

/**
 *
 * @author Note250
 */
enum tipoE{
        TECNICO,
        ADMINISTRADOR,
        EMPLEADO
    };
public class Empleado {
    private int id;
    private String nombre;
    private int documento;
    private String direccion;
    private int telefono;
    private String correo;
    private Date fechaIngreso;
    private tipoE tipo;
    /*
        1- Admin
        2- Atencion al publico
        3- Tecnico
    */

    public Empleado(int id, String nombre, int documento, String direccion, int telefono, String correo, Date fechaIngreso, tipoE tipo) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaIngreso = fechaIngreso;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public tipoE getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipoE.valueOf(tipo);
    }

    
    
}
