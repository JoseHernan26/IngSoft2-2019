/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

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
    private static String db = "jdbc:mysql://127.0.0.1";  
    
    //private static final String db = "jdbc:mysql:/"server":"port"/"nameBD"";
    
    /*
    public String user = "";
    public String pass = ""; 
    */
    public final String nameBD = "/serviciotecnico";
    public String user = "root";
    public String pass = ""; 

    public static java.sql.Statement s;
    public static java.sql.ResultSet resultado;
    public static Connection conexion = null;

    public ConexionBD() {
       db+= nameBD;
       
    }
    
    public void transaccionCommit(String accion){
        try{
            switch(accion){
                case "commit":{
                    conexion.commit();
                    break;
                }
                case "quitarAutoCommit":{
                    conexion.setAutoCommit(false);
                    break;
                }
                case "activarCommit":{
                    conexion.setAutoCommit(true);
                    break;
                }
                case "rollBack":{
                    conexion.rollback();
                    break;
                }
            }
        }catch(SQLException e){
            while(e != null){
                System.out.println("SQLState "+e.getSQLState());
                System.out.println("MENSAJE "+e.getMessage());
                System.out.println("Error code "+e.getErrorCode());
                e = e.getNextException();
            }
            
        }
    }
        
    public String Conectar(){
        try{
            if (conexion != null)
               return "OK";
            Class.forName(drv);
            conexion = DriverManager.getConnection(db,user,pass);
            if (conexion !=null){
                System.out.println("Conexión a base de datos: Ok"+db);
                s = conexion.createStatement();
            }
        }catch (SQLException e) {
            System.out.println("Problema al establecer la Conexión a la base de datos");
            e.printStackTrace();
            return "ERROR";
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
            System.out.println("Error de clase");
            return "ERROR";
        } 
        return "OK";
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
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return resultado;
    }
    /**
     * 0 ni se ejecuto el codigo
     * 1 todo OK
     * 2 error al agregar
     * 3 Exepcion
     * @param sql
     * @return 
     */
    public int EjecutarOperacion(String sql){
        int respuesta = 0;
        try {           
            respuesta = this.s.executeUpdate(sql);
                if(respuesta==1){
                    System.out.println("Registro Guardado");
                    return respuesta;
                }
                else{
                    System.out.println("Ocurrio un problema al agregar el registro");
                    return 2;
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
                return 3;
            }
        return respuesta;
      }
}
