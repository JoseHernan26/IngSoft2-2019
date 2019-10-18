/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto;

/**
 *
 * @author demig
 */
public interface LoginMvp {
    interface Controller{
        public  boolean ValidaForm(String user,String pass);
        public void start();
    }
    interface View{
        public void errorValidacion();
        public void errorConnect();
        public void iniciarSecion();
        public void transferControl(int tipo);
    }
    
}
