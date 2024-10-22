/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Note250
 */
public class Funciones {
    static SimpleDateFormat plantilla = new SimpleDateFormat("yyyy-mm-dd");
    public static boolean compareStrings(String s1, String s2){
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        return s1.contains(s2);
        
    }
    
    public static boolean controlText(String text){
        if(text.length() == 0 || text.equals(" ")){
            return false;
        }else{
            return true;
        }
    }
    public static String dateFormat(Date date){
        //Locale locale = new Locale("us", "US");
        //DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        return plantilla.format(date);
    }
    public static Float redondeo2Deci(Float f){
        return  Float.parseFloat(String.format(Locale.US,"%.2f",f));
    }
    public static String redondeo2String(Float f){
        return  String.format(Locale.US,"%.2f",f);
    }
    public static boolean isNumeric(String cadena){
        try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
}
