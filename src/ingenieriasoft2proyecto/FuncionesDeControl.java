/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
    private String dateFormat(Date date){
        Locale locale = new Locale("us", "US");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        return dateFormat.format(date);
    }
    private Float redondeo2Deci(Float f){
        return  Float.parseFloat(String.format(Locale.US,"%.2f",f));
    }
    private String redondeo2String(Float f){
        return  String.format(Locale.US,"%.2f",f);
    }
}
