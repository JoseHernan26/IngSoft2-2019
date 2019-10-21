/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto.Vistas;
import ingenieriasoft2proyecto.Modelos.Reparacion;
import ingenieriasoft2proyecto.Modelos.Equipo;
import ingenieriasoft2proyecto.Modelos.Presupuesto;
import ingenieriasoft2proyecto.Modelos.Tarea;
import ingenieriasoft2proyecto.GestionarReparacionesMVP;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Note250
 */
public class GestionarReparacionesView implements GestionarReparacionesMVP.View {

    
    private GestionarReparacionesMVP.Controller mController;
    private List<Tarea> listTareas;
    private List<Presupuesto> listPresupuestos;
    private Presupuesto presupuesto;
    private Equipo equipo;
    
    public GestionarReparacionesView(GestionarReparacionesMVP.Controller mController){
        this.mController=mController;
        this.listTareas=new ArrayList();
        this.listPresupuestos=new ArrayList();
        this.presupuesto=new Presupuesto();
        this.equipo= new Equipo();
     
    }
    @Override
    public void mostrarTablaGestRepEquiposParaReparar(List presupuestos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarTablaGestRepListadoTareasSeleccionadas(Reparacion reparacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarCamposReparacion(Reparacion reparacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
