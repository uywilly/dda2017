/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dominio.Gestor;
import dominio.Mozo;
import dominio.RestaurantException;
import dominio.Sistema;
import vista.VistaLoginGestor;
import vista.VistaLoginMozo;

/**
 *
 * @author william
 */
public class ControladorLoginMozo {

    private Sistema modelo = Sistema.getInstancia();
    private VistaLoginMozo vistaMozo;
    private VistaLoginGestor vistaGestor;

    public ControladorLoginMozo(VistaLoginMozo vm) {
        this.vistaMozo = vm;
    }

    public void LoginMozo(String nombre, String clave) {
        try {
            Mozo m = modelo.loginMozo(nombre, clave);
            if (m != null) {
                vistaMozo.ingresarMozo(m);
            }
        }catch(RestaurantException ex){
            vistaMozo.error(ex.getMessage());
        }
    }

}
