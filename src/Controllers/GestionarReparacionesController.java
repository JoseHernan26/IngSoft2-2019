/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.GestionarReparacionesDAO;
import Interfaces.GestionarReparacionesMVP;
import Modelos.Equipo;
import Modelos.Presupuesto;
import Modelos.Reparacion;
import Modelos.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Note250
 */
public class GestionarReparacionesController implements GestionarReparacionesMVP.Controller {
    private GestionarReparacionesMVP.View mView;
    private GestionarReparacionesMVP.DAO mDao;
    private ArrayList<Presupuesto> presupuestos;
    private HashMap<Integer,Equipo> equipos;

    public GestionarReparacionesController(GestionarReparacionesMVP.View mView) {
        this.mView = mView;
        this.mDao = new GestionarReparacionesDAO (this);
        this.presupuestos = mDao.getPresupuestos();
        this.equipos = mDao.getEquipos();
    }

    
    
    @Override
    public void buscarTareas(String textBuscador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Equipo> obtenerEquipos() {
            ArrayList<Equipo> eq = new ArrayList<>(equipos.values());
        return eq;
    }
    @Override
    public void obtenerReparacion(int id){
        Equipo e = equipos.get(id);
        Reparacion rep;
        switch(e.getEstado()){
            case PENDIENTE:{
                rep = new Reparacion();
                rep.setEquipo(e);
                rep.setIdEmpleado(User.getUser().getIdEmpleado());
                mDao.insertarReparacion(rep);
                mView.mostrarCamposReparacion(rep);
                break;
            }
            default:{
                rep = mDao.getReparacion(e.getId());
                rep.setEquipo(e);
                mView.mostrarCamposReparacion(rep);
                break;
            }
        }
    }
    @Override
    public void obtenerPresupuesto(Integer idPresupuesto){
        for(Presupuesto p : presupuestos){
                if(p.getId()== idPresupuesto){
                    Reparacion reparacion= new Reparacion();
                    p.getFechaEmision();
                    p.getListaTareas();
                    
                }
            }
    }


    
    
}
