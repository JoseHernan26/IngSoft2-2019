/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto.Modelos;

import ingenieriasoft2proyecto.Fecha;

/**
 *
 * @author Note250
 */
public class Telefono {
    private int id;
    private int idCliente;
    private String detallesIngreso;
    private String motivoFalla;
    private Fecha fechaRecepcion;
    private String estado; //ENTREGADO, PENDIENTE O PROCESADO   y en GARANTIA
    private Fecha modelo;
    private Fecha marca;

    public Telefono(int id, int idCliente, String detallesIngreso, String motivoFalla, Fecha fechaRecepcion, String estado, Fecha modelo, Fecha marca) {
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

    public Fecha getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Fecha fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Fecha getModelo() {
        return modelo;
    }

    public void setModelo(Fecha modelo) {
        this.modelo = modelo;
    }

    public Fecha getMarca() {
        return marca;
    }

    public void setMarca(Fecha marca) {
        this.marca = marca;
    }

    

    
    
}
