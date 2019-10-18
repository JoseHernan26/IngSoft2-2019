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
public class Producto {
    private int id;
    private int idProveedor;
    private int cantidad;
    private float precio;
    private String nombre;
    private Date garantia;
    private String tipo;

    public Producto(int id, int idProveedor, int cantidad, float precio, String nombre, Date garantia, String tipo) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombre = nombre;
        this.garantia = garantia;
        this.tipo = tipo;
    }

    public Producto() {
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getGarantia() {
        return garantia;
    }

    public void setGarantia(Date garantia) {
        this.garantia = garantia;
    }
    
    
}
