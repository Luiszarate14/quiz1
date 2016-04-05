/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;

/**
 *
 * @author luisza
 */
public class Calculador {
    private ArrayList pila = new ArrayList();  
    
    private String limpia_numero(String numero){
        return numero.replaceAll("\\s|\\,", "");
    }
     
    public void ingresa_numero(String numero){
        numero = limpia_numero(numero);
        pila.add(Double.parseDouble(numero));
    }
    
    public void ingresa_operacion(String op, String numero){
        Double oper1=null;
        Double oper2=null;
        numero = limpia_numero(numero);
        switch(op){
            case "*":
                  oper1 = (Double)pila.remove(0);
                  oper2 = Double.parseDouble(numero);
                  pila.add(0, oper1*oper2); 
                  break;
            case "/":
                  oper1 = (Double)pila.remove(0);
                  oper2 = Double.parseDouble(numero);
                  pila.add(0, oper1/oper2); 
                  break;
            case "+":
            case "-":
                pila.add(0, op);
                pila.add(0, Double.parseDouble(numero));
        
        }
    }
    
    public Double get_resultado(){        
        Double resultado = (Double)pila.remove(0);
        
        while(pila.size()>0){
            String op = (String) pila.remove(0);
            Double oper2 = (Double) pila.remove(0);
            switch(op){
                case "+":
                    resultado += oper2;
                    break;
                case "-":
                    resultado = oper2 - resultado;
                    break;
            }
        }
        
        return resultado;
    }
    
}
