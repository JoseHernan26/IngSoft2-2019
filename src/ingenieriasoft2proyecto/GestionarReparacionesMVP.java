/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto;


import ingenieriasoft2proyecto.Modelos.Presupuesto;
import ingenieriasoft2proyecto.Modelos.Reparacion;
import ingenieriasoft2proyecto.Modelos.Tarea;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Note250
 * Falta el DAO
 */
public interface GestionarReparacionesMVP {
    //añadir el dao
    
    interface Controller{
        public ArrayList<Presupuesto> buscarPresupuestos(String textBuscador);
        //devolveme un array con todos los presupuestos
        public void buscarTareas(String textBuscador);
        //devolveme las tareas de 1 presupuesto en particular
    }
    interface View{
        //Me parece que deberia recibir un array list. COntrolar
        public void mostrarTablaGestRepEquiposParaReparar(List presupuestos);
        public void mostrarTablaGestRepListadoTareasSeleccionadas(Reparacion reparacion);
        public void mostrarCamposReparacion(Reparacion reparacion);
    }
    
}
