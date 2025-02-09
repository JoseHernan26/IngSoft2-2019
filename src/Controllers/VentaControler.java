/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Modelos.Producto;
import Modelos.Venta;
import DAO.VentaDAO;
import Interfaces.VentaMVC;
import java.util.ArrayList;

/**
 *
 * @author aleja
 */
public class VentaControler implements VentaMVC.Controler{
    private VentaMVC.DAO mDao;
    private VentaMVC.View mView;

    public VentaControler(VentaMVC.View mView) {
        this.mView = mView;
        this.mDao = new VentaDAO(this);
    }
    
    @Override
    public ArrayList<Producto> obtenerTodo() {
        return this.mDao.obtenerProductos();
    }
    @Override
    public void insertarVenta(Venta venta) {
        int respuesta = mDao.insertVenta(venta);
        if(respuesta == 1){
            mView.mostrarExito();
        }else{
            mView.mostrarError("Error al insertar la venta");
        }
    }
    
}
