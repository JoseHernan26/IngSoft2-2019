/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.DetalleVenta;
import Modelos.Producto;
import Modelos.Venta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleja
 */
public class VentaMVC {
    public interface DAO{
        public int getObtenerCodigo();
        public ArrayList<Producto> obtenerProductos();
        public int insertVenta(Venta venta);
    }
    
    public interface Controler{
        public void insertarVenta(Venta venta);
        public ArrayList<Producto> obtenerTodo();
    }
    
    public interface View{
        public void buscarProducto();
        public void mostrarExito();
        public void mostrarError(String error);
    }
}
