/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto;

import java.util.List;

/**
 *
 * @author Note250
 */
public interface ProductoMVP {
    interface DAO{
        public List<Productos> getAll();
    }
    interface Controller{
        public void insertarDatos(Productos p);
    }
    interface View{
        public void agregarDato(); 
        public void showExito();
        public void showError(String text);
    }
    
}
