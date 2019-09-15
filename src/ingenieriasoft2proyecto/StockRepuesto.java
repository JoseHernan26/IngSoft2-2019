/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto;

/**
 *
 * @author Note250
 */
public class StockRepuesto {
    private int id;
    private char [] repuesto= new char [45];
    private float precio;
    private int cantidad;
/**
 * s
 * @param id
 * @param precio
 * @param cantidad 
 */
    public StockRepuesto(int id, float precio, int cantidad) {
        this.id = id;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char[] getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(char[] repuesto) {
        this.repuesto = repuesto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
