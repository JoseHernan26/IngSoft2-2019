/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto.Modelos;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Note250
 */
public class Presupuesto {
    private int id;
    private Date fechaEmision;
    private float costoServicio;
    private String listaTareas;
    private float precio;
    private List<Producto> insumos;

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public float getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(float costoServicio) {
        this.costoServicio = costoServicio;
    }

    public String getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(String listaTareas) {
        this.listaTareas = listaTareas;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public List<Producto> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<Producto> insumos) {
        this.insumos = insumos;
    }

    public Presupuesto(Date fechaEmision, float costoServicio, String listaTareas, float precio, List<Producto> insumos) {
        this.fechaEmision = fechaEmision;
        this.costoServicio = costoServicio;
        this.listaTareas = listaTareas;
        this.precio = precio;
        this.insumos = insumos;
    }
    
}
