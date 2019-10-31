/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.GestionarReparacionesMVP;
import Main.ConexionBD;
import Modelos.Equipo;
import Modelos.Presupuesto;
import Modelos.Producto;
import Modelos.Reparacion;
import Modelos.Tarea;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Note250
 */
public class GestionarReparacionesDAO implements GestionarReparacionesMVP.DAO {
    
    private GestionarReparacionesMVP.Controller mController;
    private ConexionBD conect;

    public GestionarReparacionesDAO(GestionarReparacionesMVP.Controller mController) {
        this.mController = mController;
        this.conect=new ConexionBD();
    }
    @Override
    public ArrayList<Presupuesto> getPresupuestos() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return null;
    }

    @Override
    public HashMap<Integer, Equipo> getEquipos() {
        if(conect.Conectar().equals("ERROR")){
            return null;
        }
        String SQL;
        SQL = "SELECT * FROM Equipo";
        ResultSet rs = conect.EjecutarConsultaSQL(SQL);
        HashMap<Integer,Equipo> equipos;
        equipos = new HashMap<>();

        try{
            Equipo e;
            while(rs.next()){
        
                e = new Equipo();
                e.setDetallesIngreso(rs.getString("detalles"));
                e.setEstado(rs.getString("estado"));
                e.setFechaRecepcion(rs.getDate("fechaRecepcion"));
                e.setId(rs.getInt("idEquipo"));
                e.setIdCliente(rs.getInt("idCliente"));
                e.setModelo(rs.getString("modelo"));
                e.setMarca(rs.getString("marca"));
                e.setMotivoFalla(rs.getString("motivo"));
                equipos.put(e.getId(), e);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return equipos; 

    }

    @Override
    public Reparacion getReparacion(int idEquipo) {
        String SQL;
        SQL = "SELECT * FROM Reparacion WHERE idEquipo="+idEquipo;
        ResultSet rsReparacion = conect.EjecutarConsultaSQL(SQL);

        Reparacion rep;
        rep = new Reparacion();
        System.out.println(" HOla= "); 
        try{
            if(rsReparacion.next()){
                
                rep.setId(rsReparacion.getInt("idReparacion"));
                rep.setIdEmpleado(rsReparacion.getInt("idEmpleado"));
                rep.setTotal(rsReparacion.getFloat("total"));
                List<Tarea> tareas = new ArrayList<Tarea>();
                try{                    
                    SQL= "SELECT * FROM Tarea WHERE idReparacion = "+rep.getId();
                    ResultSet rsTarea=conect.EjecutarConsultaSQL(SQL);
                    Tarea tarea;
                    while(rsTarea.next()){
                        tarea= new Tarea();
                        tarea.setId(rsTarea.getInt("idTarea"));
                        System.out.println("tarea.getId() = " + tarea.getId());
                        tarea.setValorServicio(rsTarea.getFloat("valorServicio"));
                        tarea.setSubTotal(rsTarea.getFloat("subtotal"));
                        tarea.setDescripcion(rsTarea.getString("descripcion"));
                        tarea.setGarantia(rsTarea.getInt("garantia"));
                        tarea.setNombre(rsTarea.getString("nombre"));
                        tareas.add(tarea);
                    }
                }catch(Exception e){
                    System.out.println("Error al cargar las tareas o no tenia tareas"+e.getMessage());
                }
                try{
                for(Tarea t : tareas){
                    //pidiendo prods
                    SQL = "SELECT producto.* FROM producto,repuestoTarea WHERE repuestoTarea.idTarea = "+t.getId()+" AND producto.idProducto = RepuestoTarea.idProducto";
                    ResultSet rsProds = conect.EjecutarConsultaSQL(SQL);
                    List<Producto> list = new ArrayList<>();
                    Producto p;
                    while(rsProds.next()){
                        p = new Producto();
                        p.setId(rsProds.getInt("idProducto"));
                        p.setNombre(rsProds.getString("nombre"));
                        p.setStock(rsProds.getInt("stock"));
                        p.setGarantia(rsProds.getInt("garantia"));
                        p.setIdProveedor(rsProds.getInt("idProveedor"));
                        p.setPrecio(rsProds.getFloat("precio"));
                        p.setTipo(rsProds.getString("tipo"));
                        list.add(p);
                    }
                    t.setRepuestos(list);
                }
                }catch(Exception es){
                    System.out.println("Error al insertar los repuestos de la tarea"+es.getMessage());
                }
                System.out.println("tareas = " + tareas);
                rep.setTareas(tareas);
            }
        }catch (Exception ex){
            System.out.println("Error al encontrar la reparacion"+ex.getMessage());
        }
        return rep;
        }

    @Override
    public void insertarReparacion(Reparacion r) {
        String values = " ("+r.getTotal()+","+r.getIdEmpleado()+","+r.getEquipo().getId()+");";
        String SQL = "INSERT INTO reparacion (,total,idEmpleado,idEquipo) VALUES "+values;
        System.out.println(SQL);
        int respuesta = conect.EjecutarOperacion(SQL);
        SQL = "UPDATE equipo SET estado = "+"'REPARANDO' WHERE idEquipo = "+r.getEquipo().getId();
        respuesta = conect.EjecutarOperacion(SQL);
    }
    
}
