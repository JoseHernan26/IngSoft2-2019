/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.PresupuestoDao;
import Interfaces.PresupuestoMvp;
import Modelos.Cliente;
import Modelos.Equipo;
import Modelos.Presupuesto;
import Modelos.Producto;
import Modelos.Tarea;
import Modelos.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author demig
 */
public class PresupuestoController implements PresupuestoMvp.Controller{
    private PresupuestoMvp.View mView;
    private PresupuestoMvp.Dao mDao;
    private HashMap<String,Producto> repuestos = new HashMap<>();
    private HashMap<String,Tarea> tareasPredef = new HashMap<>();

    public PresupuestoController(PresupuestoMvp.View aThis) {
        mView = aThis;
        mDao = new PresupuestoDao(this);
        tareasPredef = mDao.getTareas("");
        repuestos = mDao.getRepuestos("");
    }

    @Override
    public void buscarCliente(String nombre) {
        List<Cliente> clientes = new ArrayList<>();
        clientes= mDao.getClientes(nombre);
        mView.mostrarClientes(clientes);
    }

    @Override
    public void buscarRepuesto(String nombre) {
        HashMap<String,Producto> aux = new HashMap<>();
        aux = mDao.getRepuestos(nombre);
        List<Producto> prods = new ArrayList<>(aux.values());
        mView.mostrarRepuestos(prods);
    }

    @Override
    public void buscarTareasPredef(String nombre) {
        HashMap<String,Tarea> aux = new HashMap<>();
        aux = mDao.getTareas(nombre);
        List<Tarea> tareas = new ArrayList<>(aux.values());
        mView.mostrarPredef(tareas);
    }

    @Override
    public void recuperarCelulares(int idCliente) {
       List<Equipo> equipos = new ArrayList<>();
       equipos = mDao.getEquiposCliente(idCliente);
       HashMap<String,Equipo> aux = new HashMap<>();
       for(Equipo e : equipos){
           aux.put(e.getModelo(), e);
           System.out.println(e.getModelo());
       }
        System.out.println("Llega ok aca");
       mView.mostrarEquipos(aux);
    }

    @Override
    public void guardarCambiosCelu(Equipo e, int opt) {
        int res = 0;
        if(opt == 1){
           res = mDao.actualizarEquipo(e);
        }else{
            res = mDao.insertarEquipoNuevo(e);
        }
        if(res == 0){
            String text = "Ocurrio un problema al guardar los datos del celular";
            mView.showError(text);
        }else{
            String text = "Los datos fueron guardados con exito";
            mView.mostrarExito(text);
        }
    }

    @Override
    public void añadirPresupuesto(Presupuesto presu) {
        List<Integer> tareas = new ArrayList();
        presu.setIdEmpleado(User.getUser().getIdEmpleado());
        for(String s : presu.getListaTareas()){
            tareas.add(tareasPredef.get(s).getId());
            System.out.println("s = " + s);
            System.out.println("tareasPredef.get(s).getId() = " + tareasPredef.get(s).getId());
        }
        int res = mDao.insertarPresupuesto(presu, tareas);
        if(res == 0){
            String text = "Ocurrio un problema al agregar el presupuesto";
            mView.showError(text);
        }else{
            String text = "El presupuesto se agrego con exito";
            mView.mostrarExito(text);
        }
    }

    @Override
    public void añadirTareaAlPresu(String nombreTarea) {
        Tarea aux = tareasPredef.get(nombreTarea);
        mView.agregarTarea(aux.getNombre(), aux.getGarantia(), aux.getValorServicio());
    }

    @Override
    public void añadirRepAlPresu(String nombreRepuesto, int cantidad) {
        Producto aux = repuestos.get(nombreRepuesto);
        mView.agregarRepuesto(nombreRepuesto, cantidad, aux.getPrecio()*cantidad);
    }

    @Override
    public void añadirCliente(Cliente client) {
        int res = mDao.insertarCliente(client);
        if(res == 0){
            String text = "Ocurrio un problema al agregar el cliente nuevo";
            mView.showError(text);
        }else{
            String text = "El cliente se agrego con exito";
            mView.mostrarExito(text);
        }
    }
    
}
