/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Note250
 */
public class Reparacion {
    private int id;
    private Equipo equipo;
    private int idEmpleado;
    private Date fechaFin;
    private float total;
    private String observacion;
    private List<Tarea> tareas = new ArrayList<>();
    private static int MaxId = 0;
    public static void setMaxId(int id){
        MaxId = id;
    }
    public Reparacion() {
        id = MaxId;
        MaxId++;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
    public Reparacion(int id, Equipo equipo, int idEmpleado, Date fechaFin, int total, String observacion) {
        this.id = id;
        this.equipo = equipo;
        this.idEmpleado = idEmpleado;
        this.fechaFin = fechaFin;
        this.total = total;
        this.observacion = observacion;
    }
    
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
    
    
}
