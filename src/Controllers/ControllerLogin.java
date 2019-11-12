/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.LoginDAO;
import Main.Funciones;
import Interfaces.LoginMvp;
import Modelos.User;
import Vistas.Principal;

/**
 *
 * @author Note250
 */
public class ControllerLogin implements LoginMvp.Controller {
    private LoginMvp.View mView;
    private LoginMvp.Dao mDao;
    public ControllerLogin(LoginMvp.View mView){
        this.mView = mView;
        this.mDao = new LoginDAO(this);
    }
    @Override
    public void validaForm(String user,String pass){
        if(!(Funciones.controlText(user))){
            mView.errorText(0);
            return;
        }
        if(!(Funciones.controlText(pass))){
            mView.errorText(1);
            return;
        }
        mDao.start(user, pass);
    }

    @Override
    public void processResult(int result) {
        switch(result){
            case 0:{
                mView.errorConnect();
                break;
            }
            case 1:{
                Principal p;
                if(User.getInstance().getTipoEmpleado().equals("ADMINISTRADOR")){
                    p = new Principal(1);
                }else if(User.getInstance().getTipoEmpleado().equals("TECNICO")){
                    p = new Principal(2);
                }else{
                    p = new Principal(3);
                }
                p.setVisible(true);
                mView.finish();
                break;
            }
            case 2:{
                mView.errorValidacion(); 
                break;
            }
        }
    }

    
}
