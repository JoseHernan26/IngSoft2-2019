/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Date;
import java.util.List;
import DAO.VentaDAO;
import Modelos.DetalleVenta;
/**
 *
 * @author Note250
 */
public class Venta {
    private static int maxCodigo;
    private int id;
    private int idEmpleado;
    private int idCliente;
    private Date fecha;
    private List<DetalleVenta> detalles;
    private float total;

    public static void setMaxCode(int code){
       maxCodigo = code;
    }
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
  
    public Venta(){
    }
    
    public Venta(int idEmpleado, int idCliente, Date fecha, List<DetalleVenta> detalles, float total) {
        this.idEmpleado = idEmpleado;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.detalles = detalles;
        this.total = total;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
}
