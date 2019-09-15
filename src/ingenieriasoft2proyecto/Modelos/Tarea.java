/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto.Modelos;

import java.util.List;

/**
 *
 * @author Note250
 */
public class Tarea {
    private int id;
    private int garantia;
    private String nombre;
    private String descripcion;
    private float valorServicio;
    private float subTotal;
    private List<Producto> insumos;

    public Tarea(int id, int garantia, String nombre, String descripcion, float valorServicio, float subTotal, List<Producto> insumos) {
        this.id = id;
        this.garantia = garantia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorServicio = valorServicio;
        this.subTotal = subTotal;
        this.insumos = insumos;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(float valorServicio) {
        this.valorServicio = valorServicio;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public List<Producto> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<Producto> insumos) {
        this.insumos = insumos;
    }
    
    
}
