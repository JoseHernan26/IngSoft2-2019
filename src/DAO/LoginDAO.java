/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Main.ConexionBD;
import Interfaces.LoginMvp;
import Modelos.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author demig
 */
public class LoginDAO implements LoginMvp.Dao{
    private LoginMvp.Controller mController;
    private ConexionBD conect = null;
    private User user;

    public LoginDAO(LoginMvp.Controller mController) {
        this.mController = mController;
        conect = new ConexionBD();
    }
    @Override
    public void start(String user, String pass) {
        if(conect.Conectar().equals("Error")){
            mController.processResult(0);
        }else{
            String sql = "SELECT * FROM usuario,empleado WHERE user = '"+user+"' AND password = '"+pass+"' AND empleado.idEmpleado = usuario.idEmpleado";
            ResultSet rs = conect.EjecutarConsultaSQL(sql);
            try {
                if(rs.next()){
                    this.user = User.getInstance();
                    this.user.setId(rs.getInt("idUsuario"));
                    this.user.setIdEmpleado(rs.getInt("idEmpleado"));
                    this.user.setPassword(pass);
                    this.user.setUsuario(user);
                    this.user.setTipoEmpleado(rs.getString("tipo"));
                    mController.processResult(1);
                }
            } catch (SQLException ex) {
                mController.processResult(2);
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
