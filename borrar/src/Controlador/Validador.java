/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.CalculadoraException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author luisza
 */
public class Validador {
    // Las expresiones regulares son muy útiles así que estudienlas bien :)
    private static String numeropattern = "\\d{1,3}(?:\\s*\\,?\\s*\\d{3})*(?:\\.\\d+)?"; 
    private static String operacionespattern = "[\\+|\\-|\\*|/]";
    private Pattern patron_numero = null;
    private Pattern patron_operacion_num = null;
    private Pattern patron = null;
    private Calculador cal = new Calculador();
    
    String operacion = "";
    
    public Validador() {
        patron_numero =   Pattern.compile("("+numeropattern+")+");
        patron_operacion_num =   Pattern.compile(
                "\\s*("+operacionespattern+")\\s*(("+numeropattern+")+)");             

        patron = Pattern.compile(numeropattern+"(\\s*"+operacionespattern+"\\s*"+
                numeropattern+")*");
        
    }
    
    public void validar(String cadena) throws CalculadoraException{
        Matcher matcher = patron.matcher(cadena);
        if(!matcher.matches()){
            throw new CalculadoraException("Expresión no válida");
        }
    }
    public void procesar(String cadena_entrada){
        String cadena = cadena_entrada;
        operacion = cadena_entrada;
        Matcher matcher = patron_numero.matcher(cadena);
        if(matcher.find()){
            cal.ingresa_numero(matcher.group());
            cadena = cadena.replaceFirst(patron_numero.pattern(), "");
        }
 
        Matcher matcher_opnum = patron_operacion_num.matcher(cadena);        
        while(matcher_opnum.find()){
            cal.ingresa_operacion( matcher_opnum.group(1),
            matcher_opnum.group(2));
        }
        
    }   

    public String get_resultado(){
        return operacion + " = "+cal.get_resultado();
    }
}
