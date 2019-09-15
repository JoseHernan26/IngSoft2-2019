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
public class Servicios {
    private int id;
    private char descripcion [] = new char[45];
    private float precio;
    private char nombre [] = new char[45];
    private Fecha garantia;
/**
 * 
 * @param id
 * @param descripcion
 * @param precio
 * @param nombre
 * @param garantia 
 */
    public Servicios(int id, char [] descripcion, float precio,char [] nombre, Fecha garantia) {
        this.id = id;
        this.descripcion =descripcion;
        this.precio = precio;
        this.nombre=nombre;
        this.garantia = garantia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char[] getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(char[] descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public char[] getNombre() {
        return nombre;
    }

    public void setNombre(char[] nombre) {
        this.nombre = nombre;
    }

    public Fecha getGarantia() {
        return garantia;
    }

    public void setGarantia(Fecha garantia) {
        this.garantia = garantia;
    }
    
    
    
}
