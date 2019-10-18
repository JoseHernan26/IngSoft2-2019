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
    private ConexionBD conect = null;
    private TareasMvp.View mView;
    public TareasController(TareasMvp.View mView) {
        conect = new ConexionBD();
        this.mView = mView;
    }
    @Override
    public List<Producto> buscarProductos(String buscador) {
            String SQL;
        if(buscador.equals("")){
            SQL = "SELECT * FROM Producto WHERE tipo = 'Repuesto' ";
        }else{
            SQL = "SELECT * FROM Producto WHERE tipo = 'Repuesto' AND nombre = '"+buscador+"'";
        }
        ResultSet rs = conect.EjecutarConsultaSQL(SQL);
        List<Producto> list = new ArrayList<>();
        try{
            Producto p;
            while(rs.next()){
                p = new Producto();
                p.setId(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setCantidad(rs.getInt("stock"));
                p.setGarantia(rs.getDate("garantia"));
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
    public void agregarRepuesto(Producto p) {
        
    }

    @Override
    public void agregarTarea(Tarea tarea, boolean isPredef) {
        
    }
    
}
