/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto;

import ingenieriasoft2proyecto.LoginMvp.View;
import ingenieriasoft2proyecto.Modelos.Producto;
import ingenieriasoft2proyecto.Modelos.Tarea;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author demig
 */
public class TareasController implements TareasMvp.Controller {
    private TareasMvp.View mView;
    private TareasMvp.Dao mDao;
    private List<Producto> repuestos;
    private List<Tarea> predefinidas;
    public TareasController(TareasMvp.View mView) {
        this.mView = mView;
        this.mDao = new TareasDao(this);
        this.repuestos = mDao.getAll();
        this.predefinidas = mDao.getPredefs();
    }
    @Override
    public void buscarProductos(String buscador) {
        if(Funciones.controlText(buscador)){
            List<Object> filas = new ArrayList<>();
            Object[] row = new Object[4];
            for(Producto p : repuestos){
                if(Funciones.compareStrings(p.getNombre(), buscador)){
                    row[0] = p.getId();
                    row[1] = p.getNombre();
                    row[2] = p.getStock();
                    row[3] = p.getPrecio();
                    filas.add(row);
                }
            }
            mView.mostrarTablaRepuestos(filas);
        }
        
    }

    @Override
    public void agregarRepuesto(Producto p) {
        
    }

    @Override
    public void agregarTarea(Tarea tarea, boolean isPredef) {
        int respuesta = mDao.insertar(tarea);
        if(respuesta == 1){
            if(isPredef){
                respuesta = mDao.insertarPredef(tarea);
                if(respuesta == 1){
                    mView.mostrarExito();
                }else{
                    mView.mostrarError("Error al insertar la tarea como predefinida");
                }
            }else{
                mView.mostrarExito();
            }
        }else{
            mView.mostrarError("Error al insertar la tarea");
            return;
        }
    }
    
}
