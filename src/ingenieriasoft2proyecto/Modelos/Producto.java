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
enum tipoProd{
    INSUMO,
    REPUESTO,
}
public class Producto {
    private int id;
    private int idProveedor;
    private int stock;
    private float precio;
    private String nombre;
    private int garantia;
    private tipoProd tipo;

    public Producto(int id, int idProveedor, int stock, float precio, String nombre, int garantia, tipoProd tipo) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public tipoProd getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipoProd.valueOf(tipo);
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

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }
    
    
}
