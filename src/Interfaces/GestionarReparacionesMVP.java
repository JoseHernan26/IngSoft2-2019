/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import Modelos.Equipo;
import Modelos.Presupuesto;
import Modelos.Reparacion;
import Modelos.Tarea;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Note250
 * Falta el DAO
 */
public interface GestionarReparacionesMVP {
    //añadir el dao
    
    interface Controller{
        //devolveme un array con todos los presupuestos
        public void buscarTareas(String textBuscador);
        //devolveme las tareas de 1 presupuesto en particular
        public void obtenerReparacion(int id);
        public void obtenerPresupuesto(Integer idPresupuesto);
        public ArrayList<Equipo> obtenerEquipos();
    }
    interface View{
        //Me parece que deberia recibir un array list. COntrolar
        public void mostrarTablaGestRepEquiposParaReparar(List presupuestos);
        public void mostrarTablaGestRepListadoTareasSeleccionadas(Reparacion reparacion);
        public void mostrarCamposReparacion(Reparacion reparacion);
    }

    public static interface DAO {
        public ArrayList<Presupuesto> getPresupuestos();
        public int getMaxCode();
        public HashMap<Integer,Equipo> getEquipos();
        public Reparacion getReparacion(int idEquipo);
        public void insertarReparacion(Reparacion r);
    }
    
}
