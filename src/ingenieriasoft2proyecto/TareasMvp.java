/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto;

import ingenieriasoft2proyecto.Modelos.Producto;
import ingenieriasoft2proyecto.Modelos.Tarea;
import java.util.List;

/**
 *
 * @author demig
 */
public interface TareasMvp {
    interface Controller{
        public List<Producto> buscarProductos(String textBuscador);
        public void agregarRepuesto(Producto p);
        public void agregarTarea(Tarea tarea, boolean isPredef);
    }
    interface View{
        public void mostrarTablaRepuestos(String bucador);
        public void mostrarExito();
        public void mostrarError();
        public void preEnvioDatos();
        public void preBusqueda();
    }
}
