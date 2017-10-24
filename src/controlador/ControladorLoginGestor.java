/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dominio.Gestor;
import dominio.RestaurantException;
import dominio.Sistema;
import vista.VistaLoginGestor;
import vista.VistaLoginMozo;

/**
 *
 * @author william
 */
public class ControladorLoginGestor {
    private Sistema modelo = Sistema.getInstancia();
    private VistaLoginGestor vistaGestor;

    public ControladorLoginGestor(VistaLoginGestor vg) {
        this.vistaGestor = vg;
    }

    public void LoginGestor(String nombre, String clave) {
        try{
            Gestor g = modelo.loginGestor(nombre, clave);
            if (g != null) {
                vistaGestor.ingresarGestor(g);
            }    
        }catch(RestaurantException ex){
            vistaGestor.error(ex.getMessage());
        }
        
    }

}
