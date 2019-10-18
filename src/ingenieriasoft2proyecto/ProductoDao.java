/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto;

import ingenieriasoft2proyecto.Modelos.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Note250
 */
public class ProductoDao {
    private ProductoMVP.Controller mController;

    public ProductoDao(ProductoMVP.Controller mController) {
        this.mController = mController;
        this.conect = conect;
    }
    
    private ConexionBD conect;
    public void getAll(){
        String sql = "SELECT * FROM producto";
        ResultSet rs = conect.EjecutarConsultaSQL(sql);
        try {
            while(rs != null){
                Producto p = new Producto();
                p.setCantidad(rs.getInt("cantidad"));
                p.setGarantia(rs.getInt("garantia"));
                p.setId(rs.getInt());
            }
        } catch (SQLException ex) {
            
        }
    }
}
