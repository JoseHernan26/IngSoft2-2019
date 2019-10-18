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
public class ControllerLogin implements LoginMvp.Controller {
    private ConexionBD conect = null;
    private LoginMvp.View mView;
    private String user;
    private String pass;
    public ControllerLogin(LoginMvp.View mView) {
        conect = new ConexionBD();
        this.mView = mView;
    }
    public boolean ValidaForm(String user,String pass){
        this.user = user;
        this.pass = pass;
        
        return true;
        
    }

    @Override
    public void start() {
       conect.Conectar();
    }
}
