/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Main.Funciones;
import Interfaces.LoginMvp.View;
import Modelos.Producto;
import Modelos.Tarea;
import DAO.TareasDao;
import Interfaces.TareasMvp;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author demig
 */
public class TareasController implements TareasMvp.Controller {
    private TareasMvp.View mView;
    private TareasMvp.Dao mDao;
    private List<Producto> repuestos;
    private HashMap<String,Tarea> predefinidas;
    private List<Producto> repuestosTarea;
    
    public TareasController(TareasMvp.View mView) {
        this.mView = mView;
        this.mDao = new TareasDao(this);
        this.repuestos = mDao.getAll();
        this.predefinidas = mDao.getPredefs();

        mostrarAll();
        this.mView.mostrarPredefinidas(predefinidas);
    }
    public void mostrarAll(){
        List<Object> filas = new ArrayList<>();
        Object[] row = new Object[4];
        for(Producto p : repuestos){
            row[0] = p.getNombre();
            row[1] = p.getGarantia();
            row[2] = p.getStock();
            row[3] = p.getPrecio();
            filas.add(row);
        }
        mView.mostrarTablaRepuestos(filas);
    }
    @Override
    public void buscarProductos(String buscador) {
        if(Funciones.controlText(buscador)){
            List<Object> filas = new ArrayList<>();
            Object[] row = new Object[4];
            for(Producto p : repuestos){
                if(Funciones.compareStrings(p.getNombre(), buscador)){

                    row[1] = p.getGarantia();
                    row[0] = p.getNombre();
                    row[2] = p.getStock();
                    row[3] = p.getPrecio();
                    filas.add(row);
                }
            }
            mView.mostrarTablaRepuestos(filas);
        }
        
    }

    @Override
    public void agregarRepuesto(String p) {
        for(Producto prod : repuestos){
            if(prod.getNombre().equals(p)){
                System.out.println("agrego el producto");
                repuestos.add(prod);
            }
        }
    }

    @Override
    public void agregarTarea(Tarea tarea, boolean isPredef) {

        tarea.setInsumos(repuestosTarea);
        int respuesta = mDao.insertar(tarea);
        if(respuesta == 1){
            if(isPredef){
                respuesta = mDao.insertarPredef(tarea);

                predefinidas.put(tarea.getNombre(),tarea);

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
        }
        repuestosTarea.clear();
    }
    
}
