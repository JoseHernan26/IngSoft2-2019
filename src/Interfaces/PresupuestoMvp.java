/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.Cliente;
import Modelos.Tarea;
import Modelos.Reparacion;
import Modelos.Equipo;
import Modelos.Presupuesto;
import Modelos.Producto;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author demig
 */
public interface PresupuestoMvp {
    interface Dao{
        public List<Cliente> getClientes(String buscador);
        /**
         * this method return null if dont have any equipo asociated whit a client
         * @param idCliente
         * @return 
         */
        public List<Equipo> getEquiposCliente(int idCliente);
        public HashMap<String,Producto> getRepuestos(String buscador);
        public HashMap<String,Tarea> getTareas(String buscador);
        public int insertarEquipoNuevo(Equipo equipo);
        public int actualizarEquipo(Equipo equipo);
        public int insertarPresupuesto(Presupuesto presu,List<Integer> tareas);
        public int insertarCliente(Cliente cliente);
    }
    interface Controller{
        public void buscarCliente(String nombre);
        public void buscarRepuesto(String nombre);
        public void buscarTareasPredef(String nombre);
        public void recuperarCelulares(int idCliente);
        public void añadirRepAlPresu(String nombreRepuesto,int cantidad);
        /**
         * 
         * @param e
         * @param opt 0 new phone | 1 change cambios
         */
        public void guardarCambiosCelu(Equipo e,int opt);
        public void añadirPresupuesto(Presupuesto presu);
        public void añadirTareaAlPresu(String nombreTarea);
        public void añadirCliente(Cliente client);
    }
    
    interface View{
        public void mostrarClientes(List<Cliente> list);
        public void agregarRepuesto(String nombre,int cantidad, float subtotal);
        public void agregarTarea(String nombre, int garantia, float valorServicio);
        public void showError(String text);
        public void mostrarExito(String text);
        public void mostrarRepuestos(List<Producto> list);
        public void mostrarEquipos(HashMap<String,Equipo> list);
        public void mostrarPredef(List<Tarea> list);
        
    }
}
