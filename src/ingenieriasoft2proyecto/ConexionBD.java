/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Note250
 */
public class ConexionBD {
    private static final String drv = "com.mysql.jdbc.Driver";
    private static String db = "jdbc:mysql://";  
    
    //private static final String db = "jdbc:mysql:/"server":"port"/"nameBD"";
    
    /*
    public String user = "";
    public String pass = ""; 
    */
    public final String nameBD = "/name";
    public String user;
    public String pass; 

    public java.sql.Statement s;
    public java.sql.ResultSet resultado;
    public Connection conexion = null;

    public ConexionBD(String user, String password, String ip) {
       this.user = user;
       this.pass = password;
       db+= ip+ namebd;
       
    }
    
    
        
    public void Conectar() throws SQLException, ClassNotFoundException{
        try{
            if (conexion != null)
               return;
            Class.forName(drv);
            conexion = DriverManager.getConnection(db,user,pass);
            if (conexion !=null)
                System.out.println("Conexión a base de datos: Ok"+db);
        }catch (SQLException e) {
            System.out.println("Problema al establecer la Conexión a la base de datos");
        } 
        s = conexion.createStatement();
    }
    
    public void Desconectar(){
        try{
            conexion.close();
            conexion= null;
        }catch(Exception e)
        {
            System.out.println("Problema para cerrar la Conexión a la base de datos ");
        }
    }
    
    public java.sql.ResultSet EjecutarConsultaSQL(String sql){        
        try {
            this.resultado=this.s.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public int EjecutarOperacion(String sql){
        int respuesta = 0;
        try {           
            respuesta = this.s.executeUpdate(sql);
                if(respuesta==1){
                    System.out.println("Registro Guardado");
                }
                else{
                    System.out.println("Ocurrio un problema al agregar el registro");

                }
            } catch(SQLException ex){
                // Mostramos toda la informacion sobre el error disponible
                System.out.println( "Error: SQLException" );
                while (ex != null) {
                    System.out.println ("SQLState: " + ex.getSQLState ());
                    System.out.println ("Mensaje:  " + ex.getMessage ());
                    System.out.println ("ErrorCode:   " + ex.getErrorCode ());
                    ex = ex.getNextException();
                }
            } catch(Exception e) {
                System.out.println("Se produjo un error inesperado:    "+e.getMessage());
            }
        return respuesta;
      }
}
