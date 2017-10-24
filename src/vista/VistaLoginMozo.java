/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dominio.Mozo;

/**
 *
 * @author william
 */
public interface VistaLoginMozo {

    public void ingresarMozo(Mozo m);

    public void error(String message);

}
