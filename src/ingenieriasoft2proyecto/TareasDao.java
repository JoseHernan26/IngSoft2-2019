/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto;

import ingenieriasoft2proyecto.Modelos.Producto;
import ingenieriasoft2proyecto.Modelos.Tarea;
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
        SQL = "SELECT * FROM Producto WHERE tipo = 'Repuesto' ";
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
        String values = "("+t.getId()+",'"+t.getNombre()+"',"+t.getGarantia()+",'"+t.getDescripcion()+"',"+t.getValorServicio()+","+t.getSubTotal()+");";
        SQL = "INSERT INTO tarea (idTarea,nombre,garantia,descripcion,manoDeObra,subtotal) VALUES "+values;
        //Empieza la transaccion
        conect.transaccionCommit("quitarAutoCommit");
        respuestaTarea = conect.EjecutarOperacion(SQL);
        if(respuestaTarea == 1){
            //preparando insert en tabla RepuestoTarea
            SQL = "INSERT INTO repuestotarea (idTarea,idProducto) VALUES ";
            List<Producto> prods = t.getInsumos();
            for (int i = 0; i< prods.size()-1 ; i++) {
                values = "("+t.getId()+","+prods.get(i).getId()+")";
                SQL += values+",";
            }
            SQL += "("+t.getId()+","+prods.get(prods.size()-1).getId()+");";
            respuestaRepuesto = conect.EjecutarOperacion(SQL);
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
        String values = "("+t.getNombre()+"',"+t.getGarantia()+",'"+t.getDescripcion()+"',"+t.getValorServicio()+");";
        String SQL = "INSERT INTO tareapredef (nombre,garantia,descripcion,manoDeObra)"+values+");";
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
                p.setId(rs.getInt("int"));
                p.setNombre(rs.getString("nombre"));
                p.setGarantia(rs.getInt("garantia"));
                p.setValorServicio(rs.getFloat("int"));
                p.setDescripcion(rs.getString("int"));
                list.put(p.getNombre(),p);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list; 
    }
}
