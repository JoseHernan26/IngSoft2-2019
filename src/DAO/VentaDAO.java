/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Main.ConexionBD;
import Modelos.DetalleVenta;
import Modelos.Producto;
import Modelos.Venta;
import Interfaces.VentaMVC;
import Modelos.tipoProd;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleja
 */
public class VentaDAO implements VentaMVC.DAO{
    private VentaMVC.Controler mController;
    private ConexionBD conect = null;
    public VentaDAO(VentaMVC.Controler mController) {
        this.mController = mController;
        this.conect = new ConexionBD();
    }
    @Override
    public ArrayList<Producto> obtenerProductos() {
        String SQL;
        SQL = "SELECT * FROM Producto WHERE tipo = 'INSUMO'";
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
        return (ArrayList<Producto>) list;
    }

    @Override
    public int insertVenta(Venta venta) {
        String SQL;
        int respuestaTarea;
        int respuestaRepuesto;
        //preparando insert en tabla tarea
        String values = "('"+venta.getIdEmpleado()+"',"+venta.getIdCliente()+",'"+venta.getFecha()+"',"+venta.getTotal()+");";
        SQL = "INSERT INTO venta (idEmpleado,idCliente,fecha,total) VALUES "+values;
        //Empieza la transaccion
        conect.transaccionCommit("quitarAutoCommit");
        respuestaTarea = conect.EjecutarOperacion(SQL);
        if(respuestaTarea == 1){
            //preparando insert en tabla RepuestoTarea
            SQL = "INSERT INTO detalleVenta(idProducto,idVenta,cantidad,subtotal) VALUES ";
            List<DetalleVenta> prods = venta.getDetalles();
            for (int i = 0; i< prods.size()-1 ; i++) {
                values = "("+prods.get(i).getIdInsumo()+",(SELECT MAX(idVenta) FROM venta),"+prods.get(i).getCantidad()+","+prods.get(i).getSubtotal()+")";
                String SQL1 = "UPDATE producto SET stock = stock -"+prods.get(1).getCantidad()+"WHERE idProducto = "+prods.get(1).getIdInsumo();
                SQL += values+",";
                conect.EjecutarOperacion(SQL1);
            }
            SQL += "("+prods.get(prods.size()-1).getIdInsumo()+","+prods.get(prods.size()-1).getIdVenta()+","+prods.get(prods.size()-1).getCantidad()+","+prods.get(prods.size()-1).getSubtotal()+");";
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
    
}
