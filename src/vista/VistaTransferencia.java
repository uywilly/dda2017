/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dominio.Mozo;
import java.util.ArrayList;

/**
 *
 * @author william
 */
public interface VistaTransferencia {

    public void cargarMozosLogueados(ArrayList<Mozo> verMozosLoguados);

    public void error(String message);
    
}
