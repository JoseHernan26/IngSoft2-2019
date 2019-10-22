/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto.Modelos;

import ingenieriasoft2proyecto.Fecha;
import java.util.Date;

/**
 *
 * @author Note250
 */
enum estadoEquipo{
    ENTREGADO,
    PENDIENTE,
    REPARANDO,
}
public class Equipo {
    private int id;
    private int idCliente;
    private String detallesIngreso;
    private String motivoFalla;
    private Date fechaRecepcion;
    private estadoEquipo estado;
    private String modelo;
    private String marca;

    public Equipo(int id, int idCliente, String detallesIngreso, String motivoFalla, Date fechaRecepcion, estadoEquipo estado, String modelo, String marca) {
        this.id = id;
        this.idCliente = idCliente;
        this.detallesIngreso = detallesIngreso;
        this.motivoFalla = motivoFalla;
        this.fechaRecepcion = fechaRecepcion;
        this.estado = estado;
        this.modelo = modelo;
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDetallesIngreso() {
        return detallesIngreso;
    }

    public void setDetallesIngreso(String detallesIngreso) {
        this.detallesIngreso = detallesIngreso;
    }

    public String getMotivoFalla() {
        return motivoFalla;
    }

    public void setMotivoFalla(String motivoFalla) {
        this.motivoFalla = motivoFalla;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public estadoEquipo getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estadoEquipo.valueOf(estado);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    

    
    
}
