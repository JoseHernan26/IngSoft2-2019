/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto.Modelos;

/**
 *
 * @author Note250
 */
public class DetalleVenta {
    private int id;
    private int cantidad;
    private int idInsumo;
    private int idVenta;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
    private float subtotal;

    public DetalleVenta(int id, int cantidad, int idInsumo,int idVenta, float subtotal) {
        this.id = id;
        this.cantidad = cantidad;
        this.idInsumo = idInsumo;
        this.subtotal = subtotal;
        this.idVenta = idVenta;
    }
    
    public DetalleVenta(){
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
    
}
