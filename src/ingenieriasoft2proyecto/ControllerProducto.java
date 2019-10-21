/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto;

/**
 *
 * @author Note250
 */
public class ControllerProducto implements ProductoMVP.Controller{
   ProductoMVP.View mView;
   ProductoMVP.DAO mDao;

    public ControllerProducto(ProductoMVP.View mView) {
        this.mView = mView;
        mDao = (ProductoMVP.DAO) new ProductoDao(this);
    }
    
   
}
