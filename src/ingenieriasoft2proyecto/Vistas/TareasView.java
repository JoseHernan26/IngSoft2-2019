/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto.Vistas;

import ingenieriasoft2proyecto.Modelos.Producto;
import ingenieriasoft2proyecto.Modelos.Tarea;
import ingenieriasoft2proyecto.TareasMvp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author demig
 */
public class TareasView implements TareasMvp.View {
    private TareasMvp.Controller mController;
    private Tarea tarea;
    private List<Producto> repuestosTarea;
    public TareasView(TareasMvp.Controller mController) {
        this.mController = mController;
        this.tarea = new Tarea();
        this.repuestosTarea = new ArrayList();
    }
    
    @Override
    public void mostrarTablaRepuestos(List repuestos) {
       //cargar tabla frontend
    }
    
    @Override
    public void mostrarPredefinidas(List<Tarea> tareas) {
        //cargar lista desplegable frontend
    }
    
    @Override
    public void mostrarExito() {
        JOptionPane.showMessageDialog(null, "La tarea se agrego con exito.", "EXITO",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarError(String text) {
        JOptionPane.showMessageDialog(null, text, "ERROR",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void preEnvioDatos() {
        tarea.setNombre("");
        tarea.setGarantia(0);
        tarea.setDescripcion("");
        tarea.setSubTotal(0f);
        tarea.setInsumos(repuestosTarea);
        tarea.setSubTotal(0);
        tarea.setValorServicio(0);
        //if(checkbutton.ischecked() && no era predefinida) //algo asi quedaria la condicion
        mController.agregarTarea(tarea, true);
        //else
        mController.agregarTarea(tarea, false);
    }

    @Override
    public void preBusqueda() {
       //Obtener jtextfield. implementar el listener adecuado.
       mController.buscarProductos("");
    }
}
