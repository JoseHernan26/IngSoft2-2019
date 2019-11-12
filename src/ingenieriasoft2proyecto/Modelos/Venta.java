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
public class Venta {
    private int id;
    private Date fecha;
    private List<detalleVenta> detalles;
    private float total;

    public Venta(int id, Date fecha, List<detalleVenta> detalles, float total) {
        this.id = id;
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

    public List<detalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<detalleVenta> detalles) {
        this.detalles = detalles;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
}
