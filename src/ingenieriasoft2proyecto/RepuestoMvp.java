/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto;

import ingenieriasoft2proyecto.Modelos.Tarea;
import ingenieriasoft2proyecto.Modelos.Reparacion;
import ingenieriasoft2proyecto.Modelos.Equipo;
import java.util.List;

/**
 *
 * @author demig
 */
public interface RepuestoMvp {
    interface Dao{
        public List<Tarea> getAllTarea(int idReparacion);
        public Reparacion getReparacion(int idEquipo);
        public int updateReparacion(Reparacion rep);
        public int deleteReparacion(int idReparacion);
        public int eliminarTarea(int idTarea,int idReparacion);
    }
    interface Controller{
        public void buscarEquipo(String nombre);
        public void buscarReparacion(int idEquipo);
        public void finalizarReparacion(Reparacion rep);
    }
    interface View{
        public void mostrarEquipos(List<Equipo> list);
        public void mostrarError(String text);
        public void mostrarExito();
        public void pedirConfirmacion();
        
    }
}
