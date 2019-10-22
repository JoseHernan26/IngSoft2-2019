/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Note250
 * Clase Tarea con sus atributos y metodos basicos
 */
public class Tarea {
    private int id;
    private int garantia;
    private String nombre;
    private String descripcion;
    private float valorServicio = 0f;
    private float subTotal= 0f;
    private List<Producto> repuestos;
    private int idReparacion;

    public int getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(int idReparacion) {
        this.idReparacion = idReparacion;
    }
    
    public Tarea() {
        Random rnd = new Random(System.currentTimeMillis());
        this.id = rnd.nextInt(9999);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tarea(int id, int garantia, String nombre, String descripcion, float valorServicio, float subTotal, List<Producto> repuestos) {
        this.id = id;
        this.garantia = garantia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorServicio = valorServicio;
        this.subTotal = subTotal;
        this.repuestos = repuestos;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(float valorServicio) {
        this.valorServicio = valorServicio;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public List<Producto> getRepuestos() {
        return repuestos;
    }

    public void setRepuestos(List<Producto> repuestos) {
        this.repuestos = repuestos;
    }
    
    
}
