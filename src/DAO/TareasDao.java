/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Main.ConexionBD;
import Modelos.Producto;
import Modelos.Tarea;
import Interfaces.TareasMvp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author demig
 */
public class TareasDao implements TareasMvp.Dao{
    private ConexionBD conect = null;
    private TareasMvp.Controller mController;

    public TareasDao(TareasMvp.Controller mController) {
        this.mController = mController;
        this.conect = new ConexionBD();
    }
    
    @Override
    public List<Producto> getAll() {
        String SQL;
        SQL = "SELECT * FROM Producto WHERE tipo = 'REPUESTO' ";
        ResultSet rs = conect.EjecutarConsultaSQL(SQL);
        List<Producto> list = new ArrayList<>();
        try{
            Producto p;
            while(rs.next()){
                p = new Producto();
                p.setId(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));               
                p.setStock(rs.getInt("stock"));
                p.setGarantia(rs.getInt("garantia"));
                p.setIdProveedor(rs.getInt("idProveedor"));
                p.setPrecio(rs.getFloat("precio"));
                p.setTipo(rs.getString("tipo"));
                list.add(p);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list; 
    }

    @Override
    public List<Producto> getProducts(String nombre) {
        String SQL;
        SQL = "SELECT * FROM Producto WHERE tipo = 'Repuesto' AND nombre = '"+nombre+"'";
        ResultSet rs = conect.EjecutarConsultaSQL(SQL);
        List<Producto> list = new ArrayList<>();
        try{
            Producto p;
            while(rs.next()){
                p = new Producto();
                p.setId(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setStock(rs.getInt("stock"));
                p.setGarantia(rs.getInt("garantia"));
                p.setIdProveedor(rs.getInt("idProveedor"));
                p.setPrecio(rs.getFloat("precio"));
                p.setTipo(rs.getString("tipo"));
                list.add(p);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list; 
    }
    
    @Override
    public int insertar(Tarea t) {
        String SQL;
        int respuestaTarea;
        int respuestaRepuesto;
        //preparando insert en tabla tarea
        String values = "("+t.getId()+",'"+t.getNombre()+"',"+t.getGarantia()+",'"+t.getDescripcion()+"',"+t.getValorServicio()+","+t.getSubTotal()+","+t.getIdReparacion()+");";
        SQL = "INSERT INTO tarea (idTarea,nombre,garantia,descripcion,manoDeObra,subtotal,idReparacion) VALUES "+values;
        //Empieza la transaccion
        System.out.println(SQL);
        conect.transaccionCommit("quitarAutoCommit");
        respuestaTarea = conect.EjecutarOperacion(SQL);
        if(respuestaTarea == 1){
            if(t.getRepuestos().size() >0 ){
                //preparando insert en tabla RepuestoTarea
                SQL = "INSERT INTO repuestotarea (idTarea,idProducto,cantidad) VALUES ";
                List<Producto> prods = t.getRepuestos();
                for (int i = 0; i< prods.size()-1 ; i++) {
                    values = "("+t.getId()+","+prods.get(i).getId()+","+prods.get(i).getStock()+")";
                    SQL += values+",";
                }
                SQL += "("+t.getId()+","+prods.get(prods.size()-1).getId()+","+prods.get(prods.size()-1).getStock()+");";
                respuestaRepuesto = conect.EjecutarOperacion(SQL);
            }else{
                respuestaRepuesto = 1;
            }
            
            if(respuestaRepuesto == 1){
                conect.transaccionCommit("commit");
                conect.transaccionCommit("activarCommit");
                return respuestaRepuesto;
            }else{
                conect.transaccionCommit("rollback");
                conect.transaccionCommit("activarCommit");
                return respuestaRepuesto;
            }
        }else{
            conect.transaccionCommit("rollback");
            conect.transaccionCommit("activarCommit");
            return respuestaTarea;
        }
    }

    @Override
    public int insertarPredef(Tarea t) {
        String values = " ('"+t.getNombre()+"',"+t.getGarantia()+",'"+t.getDescripcion()+"',"+t.getValorServicio()+");";
        String SQL = "INSERT INTO tareapredef (nombre,garantia,descripcion,valorServicio) VALUES "+values;
        System.out.println(SQL);
        int respuesta = conect.EjecutarOperacion(SQL);
        return respuesta;
    }

    @Override
    public HashMap<String,Tarea> getPredefs() {
        String SQL;
        SQL = "SELECT * FROM tareapredef";
        ResultSet rs = conect.EjecutarConsultaSQL(SQL);
        HashMap<String,Tarea> list = new HashMap<>();
        try{
            Tarea p;
            while(rs.next()){
                p = new Tarea();
                p.setId(rs.getInt("idTareaPredef"));
                p.setNombre(rs.getString("nombre"));
                System.out.println("p.getNombre() = " + p.getNombre());
                p.setGarantia(rs.getInt("garantia"));
                p.setValorServicio(rs.getFloat("valorServicio"));
                p.setDescripcion(rs.getString("descripcion"));
                list.put(p.getNombre(),p);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list; 
    }
}
