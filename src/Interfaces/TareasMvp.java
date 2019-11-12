/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.Producto;
import Modelos.Tarea;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author demig
 */
public interface TareasMvp {
    interface Dao{
        public HashMap<String,Tarea> getPredefs();
        public List<Producto> getAll();
        public List<Producto> getProducts(String nombre);
        public int insertar(Tarea t);
        public int insertarPredef(Tarea t);
    }
    
    interface Controller{
        public void buscarProductos(String textBuscador);

        public void agregarRepuesto(String p);
        public void agregarTarea(Tarea tarea, boolean isPredef);
    }
    interface View{
        public void mostrarPredefinidas(HashMap<String,Tarea> tareas);
        public void mostrarTablaRepuestos(List repuestos);
        public void mostrarExito();
        public void mostrarError(String text);
        public void preEnvioDatos();
        public void preBusqueda();
    }
}
