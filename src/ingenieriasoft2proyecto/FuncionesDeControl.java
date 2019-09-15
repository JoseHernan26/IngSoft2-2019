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
public class FuncionesDeControl {
    private boolean controlText(String text){
        if(text.length() == 0 || text.equals(" ")){
            return false;
        }else{
            return true;
        }
    }
}
