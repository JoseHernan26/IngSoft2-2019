/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Note250
 */
public class Presupuesto {
    private int id;
    private int idEmpleado;
    private int idEquipo;
    private Date fechaEmision;
    private List<String> listaTareas;
    private float precioFinal;
    private HashMap<String,Integer> insumos;

    public Presupuesto(int id, int idEmpleado, int idEquipo, Date fechaEmision, float precioFinal) {
        this.id = id;
        this.idEmpleado = idEmpleado;
        this.idEquipo = idEquipo;
        this.fechaEmision = fechaEmision;
        this.precioFinal = precioFinal;
    }

    public Presupuesto() {
        listaTareas = new ArrayList<>();
        insumos = new HashMap<>();
    }
    
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

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
        return precioFinal;
    }

    public void setCostoServicio(float precioFinal) {
        this.precioFinal = precioFinal;
    }

    public List<String> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(List<String> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public HashMap<String,Integer> getInsumos() {
        return insumos;
    }

    public void setInsumos(HashMap<String,Integer> insumos) {
        this.insumos = insumos;
    }

    
}
