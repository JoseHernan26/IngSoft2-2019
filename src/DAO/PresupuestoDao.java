/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.PresupuestoMvp;
import Main.ConexionBD;
import Modelos.Cliente;
import Modelos.Equipo;
import Modelos.Presupuesto;
import Modelos.Producto;
import Modelos.Tarea;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author demig
 */
public class PresupuestoDao implements PresupuestoMvp.Dao {
    private PresupuestoMvp.Controller mController;
    private ConexionBD conect = null;

    public PresupuestoDao(PresupuestoMvp.Controller mController) {
        this.mController = mController;
        this.conect = new ConexionBD();
    }
    
    
    
    @Override
    public List<Cliente> getClientes(String buscador) {
        String SQL = "SELECT * FROM cliente";
        if(!buscador.equals("")){
            SQL += " WHERE nombre LIKE '%"+buscador+"%'";
        }
        ResultSet rsClient = conect.EjecutarConsultaSQL(SQL);
        List<Cliente> clientes = new ArrayList<>();
        try{
            while(rsClient.next()){
                Cliente c = new Cliente();
                c.setId(rsClient.getInt("idCliente"));
                c.setCorreo(rsClient.getString("correo"));
                c.setTelefono(rsClient.getString("telefono"));
                c.setNombre(rsClient.getString("nombre"));
                clientes.add(c);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public List<Equipo> getEquiposCliente(int idCliente) {
        String SQL = "SELECT * FROM equipo WHERE idCliente ="+idCliente;
        ResultSet rsEquipo = conect.EjecutarConsultaSQL(SQL);
        List<Equipo> equipos = new ArrayList<>();
        try{
            while(rsEquipo.next()){
                Equipo e = new Equipo();
                e.setDetallesIngreso(rsEquipo.getString("detalles"));
                e.setEstado(rsEquipo.getString("estado"));
                e.setFechaRecepcion(rsEquipo.getDate("fechaRecepcion"));
                e.setId(rsEquipo.getInt("idEquipo"));
                e.setIdCliente(rsEquipo.getInt("idCliente"));
                e.setMarca(rsEquipo.getString("marca"));
                e.setModelo(rsEquipo.getString("modelo"));
                e.setMotivoFalla(rsEquipo.getString("motivo"));
                equipos.add(e);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return equipos;
    }

    @Override
    public HashMap<String, Producto> getRepuestos(String buscador) {
         String SQL = "SELECT * FROM producto";
        if(!buscador.equals("")){
            SQL += " WHERE nombre LIKE '%"+buscador+"%'";
        }
        ResultSet rsRepuestos = conect.EjecutarConsultaSQL(SQL);
        HashMap<String,Producto> repuestos = new HashMap<>();
        try{
            while(rsRepuestos.next()){
                Producto p = new Producto();
                p.setGarantia(rsRepuestos.getInt("garantia"));
                p.setId(rsRepuestos.getInt("idProducto"));
                p.setIdProveedor(rsRepuestos.getInt("idProveedor"));
                p.setNombre(rsRepuestos.getString("nombre"));
                p.setPrecio(rsRepuestos.getFloat("precio"));
                p.setStock(rsRepuestos.getInt("stock"));
                p.setTipo(rsRepuestos.getString("tipo"));
                repuestos.put(p.getNombre(), p);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return repuestos;
    }

    @Override
    public HashMap<String, Tarea> getTareas(String buscador) {
        String SQL = "SELECT * FROM tareapredef";
        if(!buscador.equals("")){
            SQL += " WHERE nombre LIKE '%"+buscador+"%'";
        }
        ResultSet rsTareas = conect.EjecutarConsultaSQL(SQL);
        HashMap<String, Tarea> tareas = new HashMap<>();
        try{
            while(rsTareas.next()){
                Tarea t  = new Tarea();
                t.setDescripcion(rsTareas.getString("descripcion"));
                t.setGarantia(rsTareas.getInt("garantia"));
                t.setId(rsTareas.getInt("idTareaPredef"));
                t.setNombre(rsTareas.getString("nombre"));
                t.setValorServicio(rsTareas.getFloat("valorServicio"));
                tareas.put(t.getNombre(), t);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tareas;
    }

    @Override
    public int insertarEquipoNuevo(Equipo equipo) {
        java.sql.Timestamp sq = new java.sql.Timestamp(equipo.getFechaRecepcion().getTime());
        String SQL = "INSERT INTO equipo (idCliente,motivo,detalles,modelo,marca,estado,fechaRecepcion) VALUES ";
        String values = "("+equipo.getIdCliente()+",'"+equipo.getMotivoFalla()+"','"+equipo.getDetallesIngreso()+"','"+equipo.getModelo()+"','"+equipo.getMarca()+"','PENDIENTE','"+sq+"')";
        SQL+=values;
        System.out.println("SQL = " + SQL);
        int res = conect.EjecutarOperacion(SQL);
        return res;
    }

    @Override
    public int actualizarEquipo(Equipo equipo) {
        java.sql.Timestamp sq = new java.sql.Timestamp(equipo.getFechaRecepcion().getTime());
        String SQL = "UPDATE equipo SET motivo = '"+equipo.getMotivoFalla()+"', detalles = '"+equipo.getDetallesIngreso()+"',estado = 'PENDIENTE', fechaRecepcion = '"+sq+"'";
        int res = conect.EjecutarOperacion(SQL);
        return res;
    }

    @Override
    public int insertarPresupuesto(Presupuesto presu, List<Integer> tareas) {
        String SQL = "INSERT INTO presupuesto (idEmpleado,idEquipo,fechaEmision,precioFinal) VALUES ";
        String values = "";
        java.sql.Timestamp sq = new java.sql.Timestamp(presu.getFechaEmision().getTime());
        if(presu.getIdEquipo() == 0){
            values = "("+presu.getIdEmpleado()+",(SELECT MAX(idEquipo) FROM equipo),'"+sq+"',"+presu.getCostoServicio()+")";
        }else{
            values = "("+presu.getIdEmpleado()+","+presu.getIdEquipo()+",'"+sq+"',"+presu.getCostoServicio()+")";  
        }
        SQL +=values;
        int res = conect.EjecutarOperacion(SQL);
        if(res != 0){
            List <String> nombres = new ArrayList<>(presu.getInsumos().keySet());
            if(nombres.size() != 0){
                SQL = "INSERT INTO repuestopresupuesto (idPresupuesto,idProducto,cantidad) VALUES ";
                for (int i = 0; i< nombres.size()-1 ; i++) {
                    SQL += " ((SELECT MAX(idPresupuesto) FROM presupuesto),(SELECT producto.idProducto from producto WHERE nombre ='"+nombres.get(i)+"'),"+presu.getInsumos().get(nombres.get(i))+"),";
                }
                SQL += " ((SELECT MAX(idPresupuesto) FROM presupuesto),(SELECT producto.idProducto from producto WHERE nombre ='"+nombres.get(nombres.size()-1)+"'),"+presu.getInsumos().get(nombres.get(nombres.size()-1))+")";
                res = conect.EjecutarOperacion(SQL);
            }
            if(res != 0){
                SQL = "INSERT INTO tareaspresupuesto (idTareaPredef,idPresupuesto) VALUES ";
                for(int i = 0; i<tareas.size()-1;i++){
                    SQL += "("+tareas.get(i)+",(SELECT MAX(idPresupuesto) FROM presupuesto)),";
                }
                SQL += "("+tareas.get(tareas.size()-1)+",(SELECT MAX(idPresupuesto) FROM presupuesto))";
                res = conect.EjecutarOperacion(SQL);
            }
        }
        return res;
    }

    @Override
    public int insertarCliente(Cliente cliente) {
        String SQL = "INSERT INTO cliente (nombre,telefono,correo) VALUES ('"+cliente.getNombre()+"','"+cliente.getTelefono()+"','"+cliente.getCorreo()+"')";
        return conect.EjecutarOperacion(SQL);
    }
    
}
