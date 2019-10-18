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
    interface Dao{
        public void start(String user, String pass);
    }
    interface Controller{
        public  void validaForm(String user,String pass);
        /**
         * result = 0 error de conexion
         * result = 1 error al encontrar
         * result = 2 todo correcto
         * @param result 
         */
        public void processResult(int result);
    }
    interface View{
        public void errorValidacion();
        public void errorConnect();
        public void iniciarSesion();
        public void finish();
        public void errorText(int text);
    }
    
}
