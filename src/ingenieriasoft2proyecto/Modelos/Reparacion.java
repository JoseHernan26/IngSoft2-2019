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
public class Reparacion {
    private int id;
    private Equipo equipo;
    private int idEmpleado;
    private Date fechaFin;
    private int total;
    private String observacion;

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
    
    
}
