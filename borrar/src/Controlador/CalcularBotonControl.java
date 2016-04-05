/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CalculadoraException;
import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisza
 */
public class CalcularBotonControl implements ActionListener {

    Validador valida;
    VentanaPrincipal ventana;
    public CalcularBotonControl(VentanaPrincipal vent) {
        valida = new Validador();
        ventana = vent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            valida.validar(ventana.get_expresion());
        } catch (CalculadoraException ex) {
            ventana.set_mensaje(ex.getMessage());
            return ;
        }
        valida.procesar(ventana.get_expresion());
        ventana.set_resultado(valida.get_resultado());
    }
    
}
