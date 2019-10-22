/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto;

import ingenieriasoft2proyecto.Modelos.Equipo;
import ingenieriasoft2proyecto.Modelos.Presupuesto;
import ingenieriasoft2proyecto.Modelos.Reparacion;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Note250
 */
public class GestionarReparacionesDAO implements GestionarReparacionesMVP.DAO {
    
    private GestionarReparacionesMVP.Controller mController;

    public GestionarReparacionesDAO(GestionarReparacionesMVP.Controller mController) {
        this.mController = mController;
    }

    @Override
    public ArrayList<Presupuesto> getPresupuestos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Equipo> getEquipos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reparacion getReparacion(int idEquipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
