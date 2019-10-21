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
    private int idEmpleado;
    private Equipo idEquipo;
    private Date fechaEmision;
    private float costoServicio;
    private String listaTareas;
    private float precio;
    private List<Producto> insumos;

    public Presupuesto(int id, int idEmpleado, Equipo idEquipo, Date fechaEmision, float costoServicio, String listaTareas, float precio, List<Producto> insumos) {
        this.id = id;
        this.idEmpleado = idEmpleado;
        this.idEquipo = idEquipo;
        this.fechaEmision = fechaEmision;
        this.costoServicio = costoServicio;
        this.listaTareas = listaTareas;
        this.precio = precio;
        this.insumos = insumos;
    }

    public Presupuesto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
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

    
}
